package project_csb.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import project_csb.controller.MainPhoneController;
import project_csb.utilSet.MainInterface;

// 핸드폰 메인화면 view
public class PhoneMainView implements MainInterface{
	// 싱글톤
	private static PhoneMainView view = new PhoneMainView();
	private PhoneMainView() {}
	public static PhoneMainView getInstance() {return view;}
	//입력객체
	private Scanner sc = new Scanner(System.in);	

	@Override
	public void OutPutFront() {	
		try {
			
		
		System.out.print("\n\n전화번호 입력( '-' 제외 : "); String phoneNumber = sc.next();
		// 세션등록 메소드
		if(MainPhoneController.getInstance().setPhoneSession(phoneNumber) == false) {
			System.out.println("입력 실패");		
			return;
		}
			
	
			
		while(true) {
		
			System.out.print("1.기사 핸드폰 열기 2.사용자 핸드폰 열기 3.뒤로가기 선택>>");
			
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				// 컨트롤러의 기사 판단 메소드
				if(MainPhoneController.getInstance().isRiderPhone()) 
					RiderPhoneView.getInstance().OutPutFront();
				else
					System.out.println("기사 휴대폰이 아닙니다.");				
				break;
			//사용자 핸드폰 열기
			case 2:
				UserPhoneView.getInstance().OutPutFront();
				break;
			//뒤로가기
			case 3:
				MainPhoneController.getInstance().setPhoneSession(null);
				break;
			}
		}
		// 입력 타입이 정수가 아닌 다른 타입이라면
		}catch(InputMismatchException e) {
			System.out.println("[잘못 입력하셨습니다.]");
			sc=new Scanner(System.in);} 
		// 그 외
		catch(Exception e) {
			System.out.println(e);
			sc = new Scanner(System.in);
		}
	}
}
