package project_csb.joinPhone.userPhone.controller;


// 유저 핸드폰 컨트롤러
public class Controller {
	// 싱글톤
	private static Controller controller = new Controller();
	private Controller() {}
	public static Controller getInstance() {return controller;}
}
