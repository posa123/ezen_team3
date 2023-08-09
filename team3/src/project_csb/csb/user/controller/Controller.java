package project_csb.csb.user.controller;

// 사용자 컨트롤러
public class Controller {
	// 싱글톤
	private static Controller controller = new Controller();
	private Controller() {}
	public static Controller getInstance() {return controller;}
}
