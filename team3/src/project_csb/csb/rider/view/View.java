package project_csb.csb.rider.view;

import project_csb.interfaceSet.MainInterface;

//기사 view
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
