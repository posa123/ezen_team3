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
	
	// 배송 등록하기
	public boolean boxRegistration( CompanySysDto dto ) {
		try {
			String sql = "insert into Delivery_status( Invoice_number , bitem , barticle , Customer_phone_numbe ) values( ? , ? , ? , ? ); ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getInvoiceNumber());
			ps.setInt(2,dto.getBitem()); // 물건코드
			ps.setInt(3, dto.getBarticle()); // 기사코드
			ps.setString(4, dto.getUserPhone());// 고객전화번호
			int row = ps.executeUpdate();
			if( row==1 ) return true;
		} catch (Exception e) {System.out.println(e);}
		return false; // 실패
	}
	// 배송 관리하기 
	public ArrayList<CompanySysDto> boxManagement() {
		ArrayList<CompanySysDto> list = new ArrayList<>();
		try {
			String sql ="";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next()) {
				CompanySysDto dto = new CompanySysDto(
					rs.getInt(2) , rs.getInt(3) ,
					rs.getInt(4) ,rs.getString(5)
				);
				list.add(dto);
			}
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
}
