package project_csb;

import project_csb.interfaceSet.AddScInt;
import project_csb.interfaceSet.MainInterface;

// 메인 화면
public class MainView implements AddScInt{
	// 싱글톤
	private static MainView mainView = new MainView();
	private MainView() {}
	public static MainView getInstance() {return mainView;}	
	
	private	MainInterface mainFront;
	
	@Override
	public void OutPutFront() {
		
		while(true) {			
		      System.out.println("\n\n=========메인 페이지==========");
		      System.out.print("1.회사 시스템 2.핸드폰 3.무인택배함");
		      
		      int ch = scannerValue();
		      
		      switch ( ch ) {
		      // 회사시스템 view
		      case 1 :
		    	  mainFront = project_csb.companySys.view.View.getInstance();
		         break;
		      // 핸드폰 메인 view
		      case 2 :
		    	  mainFront = project_csb.joinPhone.phoneMain.view.View.getInstance();
		    	  break;
		      // 무인택배함 메인 view
		      case 3 : 
		    	  mainFront = project_csb.csb.CsbMainView.getInstance();		    	 
		      }		      
		      mainFront.OutPutFront();	    	 		      		   
		}         
	}	
}
