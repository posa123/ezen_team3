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
	
	
	// 해당 카테고리의 보관함 출력 메소드 
		// 해당카테고리를 선택/입력 했을때 비어있는/null 테이블을 찾아야한다 
	public ArrayList<RiderDto> categoryPrint(String bsituation) {
		
		return RiderDao.getInstance().categoryPrint(bsituation);
	}
	
	// 2. 고객에게 보관함 번호와 비밀번호 전달 하기  
	public ArrayList<RiderDto> CustomerRelay(){
		
		return null;
	}
	
}
