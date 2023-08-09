package project_csb.newInterface;

import java.util.Scanner;

import project_csb.companySys.view.View;

public interface MainInterface {
     
	// 실행 메소드 
   public abstract void OutPutFront();
   
   public default int scannerValue() {
	   Scanner sc = new Scanner(System.in);
	   int value = sc.nextInt();
	   return value;
   }
   
}