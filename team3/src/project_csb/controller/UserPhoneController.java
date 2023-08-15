package project_csb.controller;



import java.util.ArrayList;

import project_csb.model.dao.UserPhoneDao;
import project_csb.model.dto.UserPhoneDto;

// 유저 핸드폰 컨트롤러
public class UserPhoneController {
	// 싱글톤
	private static UserPhoneController controller = new UserPhoneController();
	private UserPhoneController() {}
	public static UserPhoneController getInstance() {return controller;}
	
	// 송장번호 확인하는메소드 
	public ArrayList<Integer> invoiceNumber(String phoneSession) {
		
		
		// MainPhoneController.getInstance().getPhoneSession() 에 값이들어오는걸 dao에게 전달 
		return UserPhoneDao.getInstance().invoiceNumber(MainPhoneController.getInstance().getPhoneSession());
	
	}
	
	// 배송상태확인
	public boolean deliveryStatus() {
		
		
		return false;
	}
	
	// 문자확인
	
	
}

















