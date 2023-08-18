package project_csb.controller;

import java.util.ArrayList;

import project_csb.model.dao.RiderDao;


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
	
	// 5. 비밀번호 설정/생성 메소드
	public boolean passwordCreate(int bnumber  , String bpw) {	
		return RiderDao.getInstance().passwordCreate( bnumber , bpw);	
	}
	/*
	 * 문자 발송 메소드
	 */
	public boolean sendMsg(int bnumber , String phoneNumber) {
		return RiderDao.getInstance().CustomerRelay(bnumber ,  phoneNumber);
	}
	
}
