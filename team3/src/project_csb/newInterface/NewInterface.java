package project_csb.newInterface;

import java.util.Scanner;

public interface NewInterface {
	static Scanner sc = new Scanner(System.in);
	
	public default void exeMain() {
		
		while(true) {
		System.out.println("======메인 페이지=====");
		System.out.print("1.회사 시스템 2.핸드폰 3.무인택배함");
		int ch = sc.nextInt();
		NewInterface newInterface;
		if (ch == 1) {
			
		}
		
//		mainPage( )
//		}			
//	}
//	public abstract void mainPage( newInterface i ) ;
		
	
		
}
	}
}
