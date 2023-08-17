package project_csb.view;

import java.util.Scanner;

import project_csb.utilSet.MainInterface;
import project_csb.utilSet.ViewList;

// 메인 화면
public class MainView implements MainInterface {
	// 싱글톤
	private static MainView mainView = new MainView();
	private MainView() {}
	public static MainView getInstance() {return mainView;}	
	
	private	MainInterface mainFront;
	private Scanner sc = new Scanner(System.in);
	@Override
	public void OutPutFront() {
		
		while(true) {		
			 
		      System.out.println("\n\n=========메인 페이지==========");
		      System.out.print("1.회사 시스템 2.핸드폰 3.무인택배함");
		     
			// scannerValue()는 인터페이스의 디폴트 메소드
		      int ch = sc.nextInt()-1;
		      // ViewList 클래스에서 구현 객체 배열 확인 가능	   		    
		      mainFront = ViewList.getInstance().arr.get(ch);
		     		       	 	      	      
		      mainFront.OutPutFront();	    	 		      		   
		}         
	}	
}
