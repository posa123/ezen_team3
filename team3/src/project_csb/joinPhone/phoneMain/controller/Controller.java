package project_csb.joinPhone.phoneMain.controller;

//핸드폰 메인화면 controller
public class Controller {
	// 싱글톤
	private static Controller controller = new Controller();
	private Controller() {}
	public static Controller getInstance() {return controller;}
}
