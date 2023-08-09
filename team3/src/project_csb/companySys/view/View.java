package project_csb.companySys.view;

import project_csb.interfaceSet.MainInterface;

//회사 시스템 view
public class View implements MainInterface{
	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}
	
	@Override
	public void OutPutFront() {
		System.out.println("companySys 실행");
	}
}
