package project_csb.controller;


//게시판 컨트롤러
public class BoardController {
	// 싱글톤
	private static BoardController controller = new BoardController();
	private BoardController() {}
	public static BoardController getInstance() {return controller;}
}
