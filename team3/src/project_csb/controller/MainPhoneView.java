package project_csb.controller;

import project_csb.interfaceSet.ExtraUtil;
import project_csb.model.dao.PhoneMainDao;

//핸드폰 메인화면 controller
public class MainPhoneView {
	// 싱글톤
	private static MainPhoneView controller = new MainPhoneView();
	private MainPhoneView() {}
	public static MainPhoneView getInstance() {return controller;}
	// 핸드폰세션
	private String phoneSession = null;
	// 핸드폰 세션 게터
	public String getPhoneSession() {	return phoneSession;}	
	// 핸드폰 세션 등록
	public boolean setPhoneSession( String phoneNumber ) {	
		// 유효성 검사
		if(ExtraUtil.getInstance().phoneNumberCheck(phoneNumber)) {
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
