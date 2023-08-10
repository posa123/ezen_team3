package project_csb.controller;

//핸드폰 메인화면 controller
public class PhoneMainController {
	// 싱글톤
	private static PhoneMainController controller = new PhoneMainController();
	private PhoneMainController() {}
	public static PhoneMainController getInstance() {return controller;}
}
