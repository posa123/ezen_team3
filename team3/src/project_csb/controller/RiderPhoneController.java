package project_csb.controller;

import java.util.ArrayList;

import project_csb.model.dao.RiderPhoneDao;
import project_csb.model.dto.RiderPhoneDto;

// 기사 핸드폰 컨트롤러
public class RiderPhoneController {
	// 싱글톤
	private static RiderPhoneController controller = new RiderPhoneController();
	private RiderPhoneController() {}
	public static RiderPhoneController getInstance() {return controller;}
	
	
	
	// 자신에게 할당된 배달건 확인
	public ArrayList<RiderPhoneDto> boxRegistList(){
		return RiderPhoneDao.getInstance().boxRegistList( PhoneMainController.getInstance().getPhoneSession());
	}
	
}
