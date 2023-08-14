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
		} catch (Exception e) {System.out.println(e);}
		try {
			String sql = "select * from Delivery_status where barticle = " +barticle;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				RiderPhoneDto dto = new RiderPhoneDto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getBoolean(6));
				list.add(dto);
			}	
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
}
