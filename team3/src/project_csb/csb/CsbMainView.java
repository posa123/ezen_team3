package project_csb.csb;

import project_csb.interfaceSet.MainInterface;

// 무인택배함 메인 페이지
public class CsbMainView implements MainInterface{
	// 싱글톤
	private static CsbMainView csbMainPage = new CsbMainView();
	private CsbMainView() {}
	public static CsbMainView getInstance() {return csbMainPage;}
	// 
	private MainInterface mainFront;
	
	@Override
	public void OutPutFront() {
		while(true) {
		      System.out.println("\n\n======= 환영합니다.==========");
		      System.out.print("1.물품등록 2.물품찾기 3.불편접수게시판 4.뒤로가기");
				int ch = scannerValue();
				
				switch (ch) {
				// 기사view
				case 1:
					mainFront = project_csb.csb.user.view.View.getInstance();
					break;
				// 사용자 view
				case 2:
					mainFront = project_csb.csb.user.view.View.getInstance();
					break;
				// 불편게시판 view
				case 3:
					mainFront = project_csb.csb.board.view.View.getInstance();
					break;
				case 4:
					return;
				}
				mainFront.OutPutFront();
		}
	}
	
}
