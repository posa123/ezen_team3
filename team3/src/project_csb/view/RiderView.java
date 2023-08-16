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

		System.out.println("\n\n ========= Rider System ==============");
		System.out.println("1.택배사 입력하기 2.기사 인증하기 3.고객에게 보관함 번호,비밀번호 전달하기 4.뒤로가기 선택 >>");
		try {
			int ch = sc.nextInt();
			switch(ch) {
			// 택배사 입력하기 
			case 1: 
				System.out.println("1.쿠팡 2.롯데 3.CJ 4.건영");
				break;
			case 2:
				// 기사인증메소드
				RiderCheckNumber();
				break;
			case 3:
				// 고객에게 보관함 번호와 비밀번호 전달하기 
				CustomerRelay();
				break;
			case 4:
				return;	
			}
			
		}catch (Exception e) {System.out.println(e);}
		
	}// OutPutFront e
	
	// 기사인증 메소드 
	public void RiderCheckNumber() {
		// 난수 생성 메소드호출 
		ExtraUtil.getInstance().certNumber();
		
		System.out.println("\n\n전화번호를 입력해주세요 : ");
		System.out.println("인증번호를 입력하세요 : ");
		

		System.out.println("\n\n기사 view 실행");
		//택배사 입력하기
		System.out.println("택배사 입력하세요 : ");
		//기사 인증하기
		RiderController.getInstance().RiderCertification();
		//보관함과 비밀번호 설정하기
		//고객(사용자)에게 보관함 번호와 비밀번호 전달하기

	}
	
	// 무인택배함 테이블 등록 
	public void SoldierCourierBox() {
		System.out.println("\n\n ------ 무인 택배함 -----------");
		System.out.println("보관함번호 : "); int bnumber = sc.nextInt();
		System.out.println("비밀번호  : "); int bpw = sc.nextInt();
		System.out.println("보관함 카테고리 : "); String bsituation = sc.next();
		// 컨트롤러 메소드 호출하기 
		boolean result = RiderController.getInstance()
				.SoldierCourierBox(bnumber, bpw, bsituation);
		
		if(result) {
			System.out.println("안내) 무인택배함 등록 완료");
		}else {System.out.println("안내) 무인택배함 등록 실패");}
		
	}
	
	// 고객에게 보관함 번호와 비밀번호 전달하기 메소드
	 public void CustomerRelay() {}
	
	
	
}
