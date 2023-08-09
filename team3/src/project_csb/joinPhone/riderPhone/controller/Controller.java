package project_csb.joinPhone.riderPhone.controller;

// 기사 핸드폰 컨트롤러
public class Controller {
	// 싱글톤
	private static Controller controller = new Controller();
	private Controller() {}
	public static Controller getInstance() {return controller;}
}
