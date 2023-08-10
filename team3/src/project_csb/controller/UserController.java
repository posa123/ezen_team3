package project_csb.controller;

// 사용자 컨트롤러
public class UserController {
	// 싱글톤
	private static UserController controller = new UserController();
	private UserController() {}
	public static UserController getInstance() {return controller;}
}
