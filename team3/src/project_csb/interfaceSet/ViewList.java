package project_csb.interfaceSet;

import java.util.ArrayList;
import java.util.Arrays;


public class ViewList {
	// 싱글톤
	private static ViewList viewList = new ViewList();
	private ViewList() {}
	public static ViewList getInstance() {return viewList;}
	// 메인 인터페이스 구현 객체 배열
	public ArrayList<MainInterface> arr = new ArrayList<>(Arrays.asList(
			
			project_csb.companySys.view.View.getInstance() ,				// 회사 시스템 		view
			project_csb.joinPhone.phoneMain.view.View.getInstance() , 		// 휴대폰 메인 		view
			project_csb.csb.CsbMainView.getInstance() ,						// 무인택배함 메인	view
			project_csb.csb.rider.view.View.getInstance() ,					// 	-기사 		view
			project_csb.csb.user.view.View.getInstance() ,					// 	-사용자		view
			project_csb.csb.board.view.View.getInstance() 					//	-게시판		view
			
		));// ArrayList
	
}
