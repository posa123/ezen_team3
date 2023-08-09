package project_csb.newInterface;

import java.util.Scanner;

import project_csb.companySys.view.View;

public interface MainInterface {
	static Scanner sc = new Scanner(System.in);
	
	public abstract void mainPage();
	
	public default void exeMain() {
		
		while(true) {
		System.out.println("=========메인 페이지==========");
		System.out.print("1.회사 시스템 2.핸드폰 3.무인택배함");
		
		int ch = sc.nextInt();
						
		switch ( ch ) {
		case 1 :
			mainPage( View.getInstance() );
			break;
		case 2 :
			
		}
		
	
		}			
	}
	
	public default void mainPage( MainInterface i ) {
		i.mainPage();
	}
	
		
		
	
		
		
	}

