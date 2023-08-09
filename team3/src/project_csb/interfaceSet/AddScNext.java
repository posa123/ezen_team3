package project_csb.interfaceSet;

import java.util.Scanner;

public interface AddScNext extends MainInterface{
	
		// 입력 객체 디폴트 메소드
	   public default String scannerValue() {
		   
		   Scanner sc = new Scanner(System.in);
		   
		   try {	   
			   String value = sc.next();
			   return value;	   
		   }
		   catch(Exception e) { 
			   System.out.println("Scanner 입력 실패 : " + e);
			   sc = new Scanner(System.in);
		   }
		   return null;
	   }   
}
