package project_csb.joinPhone.phoneMain.view;

import project_csb.interfaceSet.MainInterface;

// 핸드폰 메인화면 view
public class View implements MainInterface{
	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}	
		
	@Override
	public void OutPutFront() {	
		System.out.print("\n\n전화번호 입력"); 
		
		//만약 전화번호가 기사 전화번호라면 기사 view 사용자 전화번호라면 사용자 view		
	}
}
