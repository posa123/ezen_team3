package project_csb.csb.board.view;


//게시판 view
public class View {
	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}	
}
