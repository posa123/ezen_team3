package project_csb.controller;



import java.util.ArrayList;
import project_csb.model.dao.UserPhoneDao;
import project_csb.view.UserPhoneView;

// 유저 핸드폰 컨트롤러
public class UserPhoneController {
	// 싱글톤
	private static UserPhoneController userPhoneController = new UserPhoneController();
	private UserPhoneController() {}
	public static UserPhoneController getInstance() {return userPhoneController;}
	

	/*
	   송장번호 확인하는메소드 
	 */
	public ArrayList<Integer> invoiceNumber() {
		
		
		// MainPhoneController.getInstance().getPhoneSession() 에 값이들어오는걸 dao에게 전달 

		return UserPhoneDao.getInstance().invoiceNumber(MainPhoneController.getInstance().getPhoneSession());

	}
	
                           
	// 배송상태확인
	public int deliveryStatus(int invoiceNumber) {
		
		// Dao에게 전달 
		return UserPhoneDao.getInstance().deliveryStatus(invoiceNumber);
		
	}
	
	// 문자확인
	
	

	

}

















