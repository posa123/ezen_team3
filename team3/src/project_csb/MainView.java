package project_csb;

import java.util.Scanner;


import project_csb.newInterface.MainInterface;
// 메인 화면
public class MainView implements MainInterface{
	// 싱글톤
	private static MainView mainView = new MainView();
	private MainView() {}
	public static MainView getInstance() {return mainView;}
	
	private Scanner sc = new Scanner(System.in);
	private	MainInterface main;
	
	@Override
	public void OutPutFront() {
		
		while(true) {
		      System.out.println("=========메인 페이지==========");
		      System.out.print("1.회사 시스템 2.핸드폰 3.무인택배함");
		      
		      int ch = sc.nextInt();
		      
		      
		      switch ( ch ) {
		      case 1 :
		         main = project_csb.companySys.view.View.getInstance();
		         break;
		      case 2 :
		    	 main = project_csb.joinPhone.phoneMain.view.View.getInstance();
		    	  break;	
		      case 3 : 
		    	 main = project_csb.csb.CsbMainView.getInstance();
		      }
		      
		    	  
		      
		   
		      }         
	}
	
}
