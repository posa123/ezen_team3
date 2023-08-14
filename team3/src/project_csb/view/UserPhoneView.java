package project_csb.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import project_csb.controller.RiderPhoneController;
import project_csb.utilSet.MainInterface;

// 유저 핸드폰 화면
public class UserPhoneView implements MainInterface{
	// 싱글톤
	private static UserPhoneView view = new UserPhoneView();
	private UserPhoneView() {}
	public static UserPhoneView getInstance() {return view;}
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void OutPutFront() {
		System.out.println("1.송장번호 확인하기 2.배송상태 확인하기 3.뒤로가기  선택 >> ");
		try {
			int ch = sc.nextInt();
			switch( ch ) {
			//배송조회
			case 1:
				
				break;
			//문자확인하기
			case 2:
				
				break;
			case 3:
				return;
				
			}
		
		}
		catch(InputMismatchException e) {
			System.out.println("[잘못 입력하셨습니다.]");
			sc=new Scanner(System.in);} 
		catch (Exception e) {	System.out.println(e);}	
		
	}//OutPutFront e

}//class e
