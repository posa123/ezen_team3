package project_csb.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import project_csb.controller.UserPhoneController;
import project_csb.model.dto.UserPhoneDto;
import project_csb.utilSet.ExtraUtil;
import project_csb.utilSet.MainInterface;

// 유저 핸드폰 화면
public class UserPhoneView implements MainInterface{
	// 싱글톤
	private static UserPhoneView userPhoneView = new UserPhoneView();
	private UserPhoneView() {}
	public static UserPhoneView getInstance() {return userPhoneView;}
	
	
	@Override
	public void OutPutFront() {
		while(true) {				
			try {
				System.out.println("\n\n=========== UserPhone System =============");
				System.out.println("1.송장번호 확인하기 2.배송상태 확인하기 3.문자 확인하기 4.뒤로가기  선택 >> ");
			
				int ch = ExtraUtil.getInstance().getScInstance().nextInt();
				switch( ch ) {
				//송장번호 확인하기
				case 1:
					checkInvoiceNumber();
					break;
				//배송상태 확인하기
				case 2:
					checkDeliveryStatus();
					break;
				//문자 확인하기
				case 3:	
					checkMail();
					break;
				case 4:
					return;				
				}	
	
			}catch(InputMismatchException e) {
				System.out.println("[잘못 입력하셨습니다.]");
				ExtraUtil.getInstance().setScInstance(new Scanner(System.in));
			}catch (Exception e) {	System.out.println(e);}					
		}				
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
	   배송상태 확인하기 메소드
	 */
	public void checkDeliveryStatus() throws InputMismatchException{
		System.out.println("[택배 어플 켜기]");
		System.out.print("송장 번호 입력 : "); int invoiceNumber = ExtraUtil.getInstance().getScInstance().nextInt();
		System.out.println("배송 상태");
		System.out.println("=============");
		int check = UserPhoneController.getInstance().checkDeliveryStatus( invoiceNumber );
		switch(check) {
		case 1:
			System.out.println("배송 완료");
			break;
		case 2:
			System.out.println("배송 중");
			break;
		case 0:
			System.out.println("내역이 없습니다.");
			break;
		}	
	}
	
	/*
	 *  문자 확인하기 메소드
	 */
	public void checkMail() {
		ArrayList<UserPhoneDto> dtoList =  UserPhoneController.getInstance().checkMail();
		System.out.printf("\n\n%-7s %-9s %-5s" , "보관함번호" , "보관함비밀번호" , "수신일");
		System.out.println("\n==================================================================");
		for (int i = 0; i < dtoList.size(); i++) {
			UserPhoneDto dto = dtoList.get(i); // i번째의 객체를 호출
			System.out.printf("%-9d %-12s %-5s" , dto.getBnumber() , dto.getBpw() , dto.getDateRecipt());								
		}
	}
	
	
}//class e
