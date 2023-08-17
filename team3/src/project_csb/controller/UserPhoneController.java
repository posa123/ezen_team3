package project_csb.controller;

import project_csb.model.dao.UserPhoneDao;

// 유저 핸드폰 컨트롤러
public class UserPhoneController {
	// 싱글톤
	private static UserPhoneController controller = new UserPhoneController();
	private UserPhoneController() {}
	public static UserPhoneController getInstance() {return controller;}
	
	// 송장번호를 입력받아 배송상태확인 함수
	public void InvoiceNumber() {
		
		
		UserPhoneDao.getInstance().
	}
	
}
