package project_csb.model.dao;

import project_csb.database.ConnectJdbc;
import project_csb.model.dto.RiderPhoneDto;

//기사 핸드폰 dao
public class RiderPhoneDao extends ConnectJdbc{
	// 싱글톤
	private static RiderPhoneDao dao = new RiderPhoneDao();
	private RiderPhoneDao() {}
	public static RiderPhoneDao getInstance() {return dao;}	
	
	// 배달현황 수정
		// 물건코드로 식별할꺼기 때문에 컨트롤러에서 보낸 물건코드를 매게변수에 담는다
	public boolean deliveryCorrection(int bitem) {
		try{
			// 1. SQL 작성한다 
				// 수정할 배송현황 물건코드를 입력하고 배송상태를 수정한다 false로 
			String sql = "update Delivery_status set Delivery_status = false where bitem = ?";
			ps = conn.prepareStatement(sql);
			// int로 선언된 물건코드 setter부르기 
			ps.setInt(1, bitem);
			int row = ps.executeUpdate(sql);
			if( row == 1) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
}
