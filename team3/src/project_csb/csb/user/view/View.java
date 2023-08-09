package project_csb.csb.user.view;

import project_csb.interfaceSet.MainInterface;

// 사용자 view
public class View implements MainInterface{
	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}	
	
	@Override
	public void OutPutFront() {
		System.out.println("\n\n기사 view 실행");
	}
}
