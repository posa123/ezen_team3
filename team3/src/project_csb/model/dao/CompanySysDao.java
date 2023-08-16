package project_csb.model.dao;

import java.util.ArrayList;

import project_csb.database.ConnectJdbc;
import project_csb.model.dto.CompanySysDto;

//회사 시스템 dao
public class CompanySysDao extends ConnectJdbc{
	// 싱글톤
	private static CompanySysDao dao = new CompanySysDao();
	private CompanySysDao() {}
	public static CompanySysDao getInstance() {return dao;}	
	
	// 1. 배송 등록하기
	public boolean boxRegistration( CompanySysDto dto ) {
		try {
			// 1. SQL 작성한다.
			String sql = "insert into deliveryStatus( InvoiceNumber , bitem , barticle , customerPhoneNumbe ) values( date_format(now(6) , '%Y%m%d%H%i%s%f' ) , ? , ? , ? ); ";
			// 2. 작성한 SQL 조작할 인터페이스PS 객체 반환한다. 
			ps = conn.prepareStatement(sql);
			ps.setInt(1,dto.getBitem()); // 물건코드
			ps.setInt(2, dto.getBarticle()); // 기사코드
			ps.setString(3, dto.getUserPhone());// 고객전화번호
			int row = ps.executeUpdate();
			if( row==1 ) return true;
		} catch (Exception e) {System.out.println(e);}
		return false; // 실패
	}
	// 2. 배송 관리하기 
	public ArrayList<CompanySysDto> boxManagement() {
		ArrayList<CompanySysDto> list = new ArrayList<>();
		try {
			// 1. SQL 작성한다.
			String sql ="select * from deliveryStatus";
			// 2. 작성한 SQL 조작할 인터페이스PS 객체 반환한다. 
			ps = conn.prepareStatement(sql);
			// 3. SQL에 ?(매개변수) 없으므로 set 생략 
			rs = ps.executeQuery();
			while( rs.next()) {
				// [ 레코드 개수만큼 반복 ]
				// 레코드 1개 마다 1개의 DTO 변환
				CompanySysDto dto = new CompanySysDto(
					rs.getInt(1) ,
					rs.getString(2) , rs.getInt(3) ,
					rs.getInt(4) , rs.getString(5) , rs.getBoolean(6)
				);
				// 변환된 Dto 를 리스트객체에 담는다  
				list.add(dto);
			}
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	
	// 3. 배송 수정 [ 선택한 배송 수정 ] ( 인수 : line_number , InvoiceNumber , Bitem , Barticle , UserPhone )
	public boolean boxRegistUpdate( CompanySysDto dto ) {
		try {
			// 업데이트 위치
			String spot = "";
			int value = 0;
			String stringValue = null;
			//송장번호 업데이트
			if(dto.getInvoiceNumber() != null) {
				spot = "InvoiceNumber";
				stringValue = dto.getInvoiceNumber();
			}				
			//기사코드 업데이트
			else if(dto.getBarticle() != 0) {
				spot = "barticle";
				value = dto.getBarticle();
			}				
			//물건코드 업데이트
			else if(dto.getBitem() != 0) {
				spot = "bitem";
				value = dto.getBitem();
			}						
			//고객핸드폰 업데이트
			else if(dto.getUserPhone() != null) {
				spot = "customerPhoneNumbe";
				stringValue = dto.getUserPhone();				
			}				
			// 1. sql 작성한다
			String sql = "update deliveryStatus set " + spot + " = ?  where lineNumber = ?";	
			// 2. 작성한 SQL 조작할 인터페이스PS 객체 반환한다. 
			ps = conn.prepareStatement(sql);
			
			if(value != 0) 
				ps.setInt(1, value);
			else
				ps.setString( 1 , stringValue );
						
			ps.setInt(2, dto.getLineNumber()); // 행번호			
			// row - 유효성 검사를 통해 레코드값이 있는지 없는지 한줄이라도 있으면 성공 
			int row = ps.executeUpdate();
			if( row == 1 ) return true;
			
		}catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 4. 배송 삭제 [ 선택한 배송 삭제 ] ( 인수 : line_number )
	public boolean boxRegistDelete(int lineNumber) {
		try {
			// 1. sql작성한다 
			String sql = "delete from deliveryStatus where lineNumber = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, lineNumber);
			int row = ps.executeUpdate();
			if(row == 1) return true;		
		}catch (Exception e) {System.out.println(e);}
		
		return false; // DB 오류 또는 수정된 레코드가 0 이면 실패 
	}
	
	
	
	
}
