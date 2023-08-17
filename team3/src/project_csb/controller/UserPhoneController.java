package project_csb.controller;

import project_csb.model.dao.UserPhoneDao;


import java.util.ArrayList;
import project_csb.model.dto.UserPhoneDto;

// 유저 핸드폰 컨트롤러
public class UserPhoneController {
	// 싱글톤
	private static UserPhoneController userPhoneController = new UserPhoneController();
	private UserPhoneController() {}
	public static UserPhoneController getInstance() {return userPhoneController;}
		

	/*
	   송장번호 확인하는메소드 
	 */
	public ArrayList<String> invoiceNumber() {		
		// MainPhoneController.getInstance().getPhoneSession() 에 값이들어오는걸 dao에게 전달 
		return UserPhoneDao.getInstance().invoiceNumber(MainPhoneController.getInstance().getPhoneSession());
	}
	
	/*
	 * 	배송상태 확인하는 메소드
	 */
	public int checkDeliveryStatus( String invoiceNumber ) {	
		return UserPhoneDao.getInstance().deliveryStatus(invoiceNumber);
		
	}
	
	/*
	 *  문자확인 메소드
	 */
	public ArrayList<UserPhoneDto> checkMail(){				
		return UserPhoneDao.getInstance().checkMail(MainPhoneController.getInstance().getPhoneSession());
	}

}

















