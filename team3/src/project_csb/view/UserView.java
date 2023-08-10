package project_csb.view;

import project_csb.interfaceSet.MainInterface;

// 사용자 view
public class UserView implements MainInterface{
	// 싱글톤
	private static UserView view = new UserView();
	private UserView() {}
	public static UserView getInstance() {return view;}	
	
	@Override
	public void OutPutFront() {
		System.out.println("\n\n사용자 view 실행");
	}
}
