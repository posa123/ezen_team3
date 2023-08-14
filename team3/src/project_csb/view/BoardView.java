package project_csb.view;

import project_csb.utilSet.MainInterface;

//게시판 view
public class BoardView implements MainInterface{
	// 싱글톤
	private static BoardView view = new BoardView();
	private BoardView() {}
	public static BoardView getInstance() {return view;}	
	
	@Override
	public void OutPutFront() {
		System.out.println("\n\n게시판 view 실행");
	}
}
