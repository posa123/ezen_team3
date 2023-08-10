package project_csb.view;
// 유저 핸드폰 화면
public class UserPhoneView {
	// 싱글톤
	private static UserPhoneView view = new UserPhoneView();
	private UserPhoneView() {}
	public static UserPhoneView getInstance() {return view;}
	
}
