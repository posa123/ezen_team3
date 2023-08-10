package project_csb.view;

import project_csb.interfaceSet.MainInterface;

// 유저 핸드폰 화면
public class UserPhoneView implements MainInterface{
	// 싱글톤
	private static UserPhoneView view = new UserPhoneView();
	private UserPhoneView() {}
	public static UserPhoneView getInstance() {return view;}
	
	@Override
	public void OutPutFront() {
		System.out.println("유저폰뷰 실행");
		
	}
}
