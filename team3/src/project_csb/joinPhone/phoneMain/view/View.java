package project_csb.joinPhone.phoneMain.view;

import project_csb.newInterface.MainInterface;

// 핸드폰 메인화면 view
public class View implements MainInterface{
	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}	
	
	@Override
	public void OutPutFront() {	
		System.out.println("mainPhone 실행");
	}
}
