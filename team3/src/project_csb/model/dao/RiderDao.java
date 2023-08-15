package project_csb.model.dao;

import java.util.ArrayList;

import project_csb.database.ConnectJdbc;
import project_csb.model.dto.RiderDto;

// 기사 dao
public class RiderDao extends ConnectJdbc{
	// 싱글톤
	private static RiderDao dao = new RiderDao();
	private RiderDao() {}
	public static RiderDao getInstance() {return dao;}	
	
	
	// 기사 인증메소드 
	
	
	// 무인택배함 테이블 등록
	public boolean SoldierCourierBox(RiderDto riderDto) {
		try {
			// sql작성 
			String sql = "insert into anmdtable( bnumber , bsituation , bpw ) values( ? , ? , ? )";
			// 작성한 sql 조작할 ps 객체 반환 
			ps = conn.prepareStatement(sql);
			ps.setInt(1, riderDto.getBnumber()); // 보관함번호
			ps.setString(2, riderDto.getBsituation());	// 카테고리 
			ps.setInt(3, riderDto.getBpw()); 	// 비밀번호 
			int row = ps.executeUpdate();
			if(row == 1) {return false;}
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 2. 고객에게 보관함 번호와 비밀번호 전달 하기 
	public ArrayList<RiderDto> CustomerRelay(RiderDto riderDto){
		try {
			// sql작성
			String sql = "";
			
			
		} catch (Exception e) {System.out.println(e);}
		
		
		return null;
	}
	
}
