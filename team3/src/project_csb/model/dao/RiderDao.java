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
	
	// 택배함 보관 내역 테이블 수정 
	
	
	// 문자테이블 등록
	
	
	// 2. 고객에게 보관함 번호와 비밀번호 전달 하기 
	public ArrayList<RiderDto> CustomerRelay(RiderDto riderDto){
		try {
			// sql작성
			String sql = "";
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
}
