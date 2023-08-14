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
	
	

	// 배달현황 수정 메소드
		// 배송현황 dto 에 있는 deliverStatus 만 수정해야함 배송상태의 수정을위한것이때문에
	public boolean deliveryCorrection(int bitem) {
		// view 에서 컨드롤러에게 전달한 물건코드를 받아서 dao에게 전달한다.
			// 식별대상인 물건코드/bitem 을 dao에게 보낸다  
		RiderPhoneDao.getInstance().deliveryCorrection(bitem);
		
		return RiderPhoneDao.getInstance().deliveryCorrection(bitem);
	}
	
	// 자신에게 할당된 배달건 확인
	public ArrayList<RiderPhoneDto> boxRegistList(){
		return RiderPhoneDao.getInstance().boxRegistList( MainPhoneController.getInstance().getPhoneSession());
	}
	
}
