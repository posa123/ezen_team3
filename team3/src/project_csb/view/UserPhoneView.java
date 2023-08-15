package project_csb.view;

import java.util.Scanner;

import project_csb.interfaceSet.MainInterface;

// 유저 핸드폰 화면
public class UserPhoneView implements MainInterface{
	// 싱글톤
	private static UserPhoneView view = new UserPhoneView();
	private UserPhoneView() {}
	public static UserPhoneView getInstance() {return view;}
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void OutPutFront() {
		System.out.println("유저폰뷰 실행");
		System.out.println("1. 배송조회 2. 문자확인하기   선택 > ");
		try {
			int ch = sc.nextInt();
			if( ch == 1 ) {
				//배송조회 메소드 불러와야함!! 아직 안만듬
			}
			if( ch == 2 ) {
				//문자확인 메소드 불러와야함!! 아직 안만듬
			}
			
		}catch (Exception e) {
			System.out.println("경고] 잘못된 입력입니다. ");
			sc = new Scanner(System.in); 
		}//catch e
		
	}//OutPutFront e
}//class e