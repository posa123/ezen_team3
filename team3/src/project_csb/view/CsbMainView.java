package project_csb.view;

import project_csb.utilSet.ExtraUtil;
import project_csb.utilSet.MainInterface;
import project_csb.utilSet.ViewList;

// 무인택배함 메인 페이지
public class CsbMainView implements MainInterface{
	// 싱글톤
	private static CsbMainView csbMainPage = new CsbMainView();
	private CsbMainView() {}
	public static CsbMainView getInstance() {return csbMainPage;}
	private MainInterface mainFront;
	
	@Override
	public void OutPutFront() {
		main : while(true) {
			try {
				 System.out.println("\n\n=========== 환영합니다 =============");
			      System.out.print("1.물품등록 2.물품찾기 3.불편접수게시판 4.뒤로가기 선택>>");
					int ch = ExtraUtil.getInstance().getScInstance().nextInt() + 2;
					 if( ch > 6 && 3 > ch ) {
				    	  System.out.println("잘못 입력하셨습니다.");
				    	  continue main;
				      }			 
					// 4입력시 return
					if(ch == 6) return;
					
					mainFront = ViewList.getInstance().arr.get(ch);						
					mainFront.OutPutFront();
			}catch(Exception e) { }  
		}
	}
	
}
