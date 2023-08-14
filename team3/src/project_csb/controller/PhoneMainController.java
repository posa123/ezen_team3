package project_csb.controller;

import project_csb.interfaceSet.PhoneNumberCheck;
import project_csb.model.dao.PhoneMainDao;

//핸드폰 메인화면 controller
public class PhoneMainController {
	// 싱글톤
	private static PhoneMainController controller = new PhoneMainController();
	private PhoneMainController() {}
	public static PhoneMainController getInstance() {return controller;}
	// 핸드폰세션
	private String phoneSession = null;
	// 핸드폰 세션 게터
	public String getPhoneSession() {	return phoneSession;}	
	// 핸드폰 세션 등록
	public boolean setPhoneSession( String phoneNumber ) {	
		// 유효성 검사
		if(PhoneNumberCheck.getInstance().phoneNumberCheck(phoneNumber)) {
			phoneSession = phoneNumber;
			return true;
		}
		else
			return false;	
		}
	// 기사 판단 메소드
	public boolean isRiderPhone() {
		return PhoneMainDao.getInstance().isRiderPhone( phoneSession );
	}
	
	
}
