package project_csb.csb.board.controller;


//게시판 컨트롤러
public class Controller {
	// 싱글톤
	private static Controller controller = new Controller();
	private Controller() {}
	public static Controller getInstance() {return controller;}
}
