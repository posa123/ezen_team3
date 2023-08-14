package project_csb.view;

import java.util.Scanner;

//기사 핸드폰 view
public class RiderPhoneView {
	// 싱글톤
	private static RiderPhoneView view = new RiderPhoneView();
	private RiderPhoneView() {}
	public static RiderPhoneView getInstance() {return view;}	
	
	private Scanner sc = new Scanner(System.in);
	
	// 1. 기사 휴대폰 메뉴/기능 
	public void RiderSystem() {
		System.out.println("\n\n ------------------ 기사 시스템 ----------------- ");
		System.out.println("1.할당된 배달건확인 2.배달 현황수정");
		int ch = sc.nextInt();
		
		if(ch == 1) {} // 할당된 배달건확인 메소드 필요함
		if(ch == 2) {} // 배달 현황수정 메소드 필요함 
		
	} // RiderSystem e
	
	// 2. 할단된 배달건확인 메소드
	
	
	// 3. 배달현황 수정 메소드 
	
}// class e
