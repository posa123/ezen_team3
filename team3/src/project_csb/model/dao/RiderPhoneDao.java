package project_csb.model.dao;

import java.util.ArrayList;

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
		
	// 자신에게 할당된 배달건 확인
	public ArrayList<RiderPhoneDto> boxRegistList( String phoneNumber ){
		ArrayList<RiderPhoneDto> list = new  ArrayList<>();
		int barticle = 0;
		try {
			String sql = "select barticle from couriertale where barphone = ?";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				barticle = rs.getInt(1);
			}
		} catch (Exception e) {System.out.println("1" +e);}
		try {
			String sql = "select * from Delivery_status where barticle = " +barticle;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				RiderPhoneDto dto = new RiderPhoneDto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getBoolean(6));
				list.add(dto);
			}	
		} catch (Exception e) {System.out.println("2" + e);}
		return list;
	}
}
