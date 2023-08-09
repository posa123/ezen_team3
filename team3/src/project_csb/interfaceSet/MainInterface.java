package project_csb.interfaceSet;

import java.util.Scanner;


public interface MainInterface {
     
	// 실행 메소드 
   public abstract void OutPutFront();
   
   // 입력 객체 디폴트 메소드
   public default int scannerValue() {
	   
	   Scanner sc = new Scanner(System.in);
	   
	   try {	   
		   int value = sc.nextInt();
		   return value;	   
	   }
	   catch(Exception e) { 
		   System.out.println("Scanner 입력 실패 : " + e);
		   sc = new Scanner(System.in);
	   }
	   return 0;
   }   
}