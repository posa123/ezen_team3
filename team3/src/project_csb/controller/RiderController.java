package project_csb.controller;

import java.util.ArrayList;

import project_csb.model.dao.RiderDao;
import project_csb.model.dto.RiderDto;

//기사 컨트롤러
public class RiderController {
	// 싱글톤
	private static RiderController controller = new RiderController();
	private RiderController() {}
	public static RiderController getInstance() {return controller;}
	
	
	
	// 2. 보관함 카테고리 선택 후 보관 가능한 보관함 모두 출력 메소드
		// 해당카테고리를 선택/입력 했을때 비어있는/null 테이블을 찾아야한다 
	public ArrayList<Integer> categoryPrint( String bsituation ) {
		
		                                                              
		return RiderDao.getInstance().categoryPrint(bsituation);
	}
	
	// 3. parcelboxUpdate : 택배함 보관 내역 테이블 수정 
	public boolean parcelboxUpdate() {return false;}
	
	// 5. 비밀번호 설정/생성 메소드
	public boolean passwordCreate(int bnumber  , String bpw) {
		System.out.println("\n\n ----- passwordCreate 컨트롤 도착 -----");

		
		boolean result = RiderDao.getInstance().passwordCreate( bnumber , bpw);
		return result;
		
	}
}
