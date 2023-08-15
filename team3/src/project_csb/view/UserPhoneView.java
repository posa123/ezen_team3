package project_csb.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import project_csb.controller.UserPhoneController;
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
		System.out.println("\n\n=========== UserPhone System =============");
		System.out.println("1.송장번호 확인하기 2.배송상태 확인하기 3.뒤로가기  선택 >> ");
		try {
			int ch = sc.nextInt();
			switch( ch ) {
			//배송조회
			case 1:
				checkInvoiceNumber();
				break;
			//문자확인하기
			case 2:
				checkDeliveryStatus();
				break;
			case 3:				
				return;				
			}	
		}catch(InputMismatchException e) {
			System.out.println("[잘못 입력하셨습니다.]");
			sc=new Scanner(System.in);} 
		catch (Exception e) {	System.out.println(e);}							
	}//OutPutFront e
	
	
	/*
	 * 송장번호 확인하기 메소드
	 */	
	public void checkInvoiceNumber() {
		ArrayList<Integer> inNumberList = UserPhoneController.getInstance().invoiceNumber();
		System.out.println("\n\n송장번호" );
		System.out.println("==============");
		for (int i = 0; i < inNumberList.size(); i++) 
			System.out.println(inNumberList.get(i)); // i번째 송장번호 출력							
	}
	
	/*
	 * 배송상태 확인하기 메소드
	 */
	public void checkDeliveryStatus() {
		boolean result = UserPhoneController.getInstance().deliveryStatus();
		System.out.println("배송 상태"); 
	}
	
}//class e
