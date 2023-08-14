package project_csb.model.dao;

import java.util.ArrayList;
import project_csb.database.ConnectJdbc;
import project_csb.model.dto.RiderPhoneDto;

//기사 핸드폰 dao
public class RiderPhoneDao extends ConnectJdbc{
	// 싱글톤
	private static RiderPhoneDao riderPhoneDao = new RiderPhoneDao();
	private RiderPhoneDao() {}
	public static RiderPhoneDao getInstance() {return riderPhoneDao;}	
	
	// 배달현황 수정
			// 물건코드로 식별할꺼기 때문에 컨트롤러에서 보낸 물건코드를 매게변수에 담는다
		public boolean deliveryCorrection(int lineNumber) {
			try{
				// 1. SQL 작성한다 
					// 수정할 배송현황 물건코드를 입력하고 배송상태를 수정한다 false로 
				// 터치 단말기이기 때문에 다른 번호 입력 걱정 필요 x
				String sql = "update Delivery_status set delivery_status = true where lineNumber = ?";
				ps = conn.prepareStatement(sql);
				// int로 선언된 물건코드 setter부르기 
				ps.setInt( 1 , lineNumber);
				int row = ps.executeUpdate();
				if( row == 1) {
					return true;
				}else {
					return false;
				}
				
			}catch (Exception e) {System.out.println(e);}
			
			return false;
		}
		
	// 자신에게 할당된 배달건 확인
	public ArrayList<RiderPhoneDto> boxRegistList( String phoneNumber ){
		//dto담을 ArrayList
		ArrayList<RiderPhoneDto> dtoList = new  ArrayList<>();
		int barticle = 0;
		try {
			// 기사 코드를 찾아서 barticle에 저장
			String sql = "select barticle from couriertale where barphone = ?";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , phoneNumber);
			rs = ps.executeQuery();
			if(rs.next()) {
				barticle = rs.getInt(1);
			}
		} catch (Exception e) {System.out.println("1" +e);}
		try {
			// 기사코드로 
			String sql = "select * from Delivery_status where barticle = " + barticle;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				RiderPhoneDto dto = new RiderPhoneDto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getBoolean(6));
				dtoList.add(dto);
			}	
		} catch (Exception e) {System.out.println("2" + e);}
		return dtoList;
	}
}
