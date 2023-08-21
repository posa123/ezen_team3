package project_csb.model.dao;

import java.util.ArrayList;

import project_csb.database.ConnectJdbc;

// 기사 dao
public class RiderDao extends ConnectJdbc{
	// 싱글톤
	private static RiderDao riderDao = new RiderDao();
	private RiderDao() {}
	public static RiderDao getInstance() {return riderDao;}	
	
	// 1. 보관함 카테고리 선택 후 보관 가능한 보관함 모두 출력 메소드
		 // 함번호가 들어오는 값이 숫자로 들어오기때문에 Integer로 타입설정 
	public ArrayList<Integer> categoryPrint(String bsituation){
		ArrayList<Integer> riderList = new ArrayList<Integer>(); // 가변길이/자동길이 로 설정 
	
		try {
			// sql 작성
				// 선택된 카테고리의 비어있는 보관함을찾을껀데 비밀번호가 입력받지않아야함/null값 이어야한다.
			String sql = "select bnumber from anmdtable where bsituation = ? and bpw is null";
			
			ps = conn.prepareStatement(sql);
			// 매개변수 bsituation 가져와서 저장
			ps.setString(1, bsituation);
			
			// 검색결과의 레코드를 여러개 반환 하기위해 rs 반환
			rs = ps.executeQuery();
			while(rs.next()) {
				 riderList.add(rs.getInt(1));
			}
		} catch (Exception e) {System.out.println(e);}
		return riderList;
	}
	
	//  보관함 비밀번호 설정 메소드
		public boolean passwordCreate(int bnumber  , String bpw) {
			try {
				// sql작성
					// update 함번호를 설정했고 해당 함번호의 비밀번호를 생성해야한다.
				String sql = "update anmdtable set bpw = ? where bnumber = ? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, bpw);
				ps.setInt(2 , bnumber);
				// 실행
				int row = ps.executeUpdate();
				
				if( row == 1) {
					parcelboxUpdate( bnumber );
					return true;
				}			
									
			} catch (Exception e) {System.out.println(e);}
			
			return false;
		}	
		
	//  parcelboxUpdate : 택배함 보관 내역 테이블 수정 
	public void parcelboxUpdate( int bnumber ) {
		try {
		String sql = "insert into archistable( bnumber ) values( ? )";
		ps = conn.prepareStatement(sql);
		ps.setInt( 1 , bnumber);
		ps.executeUpdate();
		} catch (Exception e) {System.out.println(e);}	
	}
	
	
	// 고객에게 문자발송 메소드
	public boolean CustomerRelay(int bnumber , String phoneNumber){
		try {
			// sql작성
			String sql = "insert into texting(customerPhoneNumbe , bnumber) values( ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString( 1, phoneNumber);
			ps.setInt( 2 , bnumber );
			int row = ps.executeUpdate();
			if(row == 1 )
				return true;	
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	
}
