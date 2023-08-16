package project_csb.view;

import java.util.Scanner;

import project_csb.controller.RiderController;
import project_csb.utilSet.ExtraUtil;
import project_csb.utilSet.MainInterface;

//기사 view
public class RiderView implements MainInterface {
	// 싱글톤
	private static RiderView riderView = new RiderView();
	private RiderView() {}
	private Scanner sc = new Scanner(System.in);
	public static RiderView getInstance() {return riderView;}	
	
	
	@Override
	public void OutPutFront() {

		
		/*
		 	1. 택배사입력
		 	2. 인증메소드
		 	3. 카테고리입력(어디에보관할껀지 , 해당카테고리보관함이 출력되야함) 
		 	4. 보관함 번호,비밀번호 입력 
		 	5. 고객에게 보관함 번호 , 비밀번호 입력
		*/
		
	}// OutPutFront e
	
	// 기사인증 메소드 
	public void RiderCheckNumber() {
		System.out.println("\n\n ========= Rider System ==============");
		System.out.println("1.Cj대한통운 2.로젠택배 3.우체국택배 4.한진택배 5.롯데택배 6.대신택배 7.대신택배 8.건영택배 9.농협택배 10.편의점택배");
		
		System.out.println("\n\n전화번호를 입력해주세요 : "); String phoneNumber = sc.next();
		// 난수 생성 메소드호출 
		int result = 
				ExtraUtil.getInstance().certNumber();
		
		System.out.println("인증번호를 입력하세요 : "); int cNumber = sc.nextInt();
		
		// 인증한후에 기사가 고객에게 전달하기전 필요한 양식 입력
		// 함번호
		System.out.println("함 번호를 입력하세요 : "); int bnumber = sc.nextInt();
		
		// 비밀번호
		System.out.println("비밀번호를 입력하세요 : "); int bpw = sc.nextInt();
		
		// 카테고리선택
		System.out.println("\n\n ======= 원하시는 보관 카테고리를 선택해주세요 ====== ");
		System.out.println("1.실온 2.냉장 3.냉동");
		
		//기사 인증하기
		RiderController.getInstance().RiderCertification(bnumber, bpw, phoneNumber);
		
		//고객(사용자)에게 보관함 번호와 비밀번호 전달하기
		RiderView.getInstance().CustomerRelay();
		
	}
	// 택배함 보관 내역 테이블 등록
		// 함번호는 기사인증 메소드에서 입력받았기때문에 매개변수로 가져온다 
	public void boxKeep() {
		System.out.println(" ==================== 택배함 보관 내역 시스템 ============= ");
		
		
	}
	
	// 택배함 보관 내역 테이블 수정 
	
	
	// 문자테이블 등록
	
	
	// 고객에게 보관함 번호와 비밀번호 전달하기 메소드
	 public void CustomerRelay() {}
	
	
	
}
