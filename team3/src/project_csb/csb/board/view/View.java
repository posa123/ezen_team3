package project_csb.csb.board.view;

import project_csb.interfaceSet.MainInterface;

//게시판 view
public class View implements MainInterface{
	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}	
	
	@Override
	public void OutPutFront() {
		System.out.println("\n\n게시판 view 실행");
	}
}
