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
			
			project_csb.view.CompanySysView.getInstance() ,				// 회사 시스템 		view
			project_csb.view.PhoneMainView.getInstance() , 		// 휴대폰 메인 		view
			project_csb.view.CsbMainView.getInstance() ,						// 무인택배함 메인	view
			project_csb.view.RiderView.getInstance() ,					// 	-기사 		view
			project_csb.view.UserView.getInstance() ,					// 	-사용자		view
			project_csb.view.BoardView.getInstance() 					//	-게시판		view
			
		));// ArrayList
	
}
