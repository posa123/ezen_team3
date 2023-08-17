package project_csb.model.dao;

import java.util.ArrayList;

import project_csb.database.ConnectJdbc;
import project_csb.model.dto.RiderDto;

// 기사 dao
public class RiderDao extends ConnectJdbc{
	// 싱글톤
	private static RiderDao riderDao = new RiderDao();
	private RiderDao() {}
	public static RiderDao getInstance() {return riderDao;}	
	
	// 해당 카테고리의 보관함 출력 메소드
	public ArrayList<RiderDto> categoryPrint(String bsituation){
		ArrayList<RiderDto> dtolist = new ArrayList<RiderDto>();
		int bnumber[] = {}; 
	
		try {
			// sql 작성
			String sql = "select bnumber from anmdtable where bsituation = ?";
			
			ps = conn.prepareStatement(sql);
			// 매개변수는 없으므로 set은 생략

			
			ps.setString(1, bsituation);
			
			// 검색결과의 레코드를 여러개 반환 하기위해 rs 반환
			rs = ps.executeQuery();
			while(rs.next()) {
				bnumber = (rs.getInt(1);
			}
		} catch (Exception e) {System.out.println(e);}
		return dtolist;
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
