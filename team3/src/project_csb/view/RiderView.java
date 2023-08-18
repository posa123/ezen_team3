package project_csb.view;

import java.util.ArrayList;
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
	
	


		
		/*
		 	1. 택배사입력
		 	2. 인증메소드
		 	3. 카테고리입력(어디에보관할껀지 , 해당카테고리보관함이 출력되야함) 
		 	4. 보관함 번호,비밀번호 입력 
		 	5. 고객에게 보관함 번호 , 비밀번호 입력
		 	
		 - 기사가 택배를 등록할때 	
		 	언제 : 고객에게 택배를 전달할때
		 	어디서 : 무인택배함에서
		 	무엇을 : 택배사(1) , 고객전화번호(2) , 인증번호(3) , 함번호(4) , 비밀번호(5) , 카테고리(6) 등록해서 고객에게 전달한다. 
		 	어떻게 : 각각 6개를 모두 입력받는다 인증번호는 일치여부
		 			카테고리 : 선택된 비어있는 카테고리보관함을 찾는다/출력한다 , 카테고리를 선택했을때 null값인 보관함을 출력한다 
		 			카테고리를 선택한이유는?
		 				등록할 택배가 어떻게 보관할지 식별하기위해 
		*/
	
	// 기사인증 메소드 
	@Override
	public void OutPutFront() {
		System.out.println("\n\n ========= Rider System ==============");
		System.out.println("1.Cj대한통운 2.로젠택배 3.우체국택배 4.한진택배 5.롯데택배 6.대신택배 7.대신택배 8.건영택배 9.농협택배 10.편의점택배");
		
		System.out.println("\n\n전화번호를 입력해주세요 : "); String phoneNumber = sc.next();
		// 난수 생성 메소드호출 
		int result1 = 
				ExtraUtil.getInstance().certNumber();
		
		System.out.println("인증번호를 입력하세요 : "); int cNumber = sc.nextInt();
		
		// 입력받은 인증번호가 맞는지 검사
		if(result1 == cNumber) {
			System.out.println("인증 되었습니다");
		}else {System.out.println("인증 실패됬습니다");}
		
		
		// 카테고리선택
		System.out.println("\n\n ======= 원하시는 보관 카테고리를 선택해주세요 ====== ");
		System.out.println("1.실온 2.냉장 3.냉동");
		int ch = sc.nextInt();
		
		// 들어오는값이 숫자가아닌 문자열이므로 String 타입생성 
		String category = null;
		// 선택한 카테고리를 컨트롤러에게 보낸다
		if(ch == 1) {
			category = "실온";
			// 선택한 번호가 1번이면 해당 category 변수에 "실온" 을담는다 
		}// if e
		if(ch == 2) {
			category = "냉장";
		}// if e
		if(ch == 3) {
			category = "냉동";
		}// if e
		// 배열로 선언하면 모든 보관함의 유효성검사를 해줘야하기때문에 ArrayList 로 자동길이를 설정했다 
		// selectCategory 배열에 RiderController 에게 category를담아서 컨트롤러에게 전달한다.
		ArrayList<Integer> selectCategory = RiderController.getInstance().categoryPrint(category);	
		//  리스트내에 저장된 객체를 첫번째부터 마지막까지
			// 인덱스를 0부터 .size() 미만까지 
		for(int i = 0; i<selectCategory.size(); i++) {
			System.out.println(selectCategory.get(i));
		}
		
		
		
		// 비밀번호
		passwordCreate() ;
		
	
	}
	
	// 보관함 카테고리 선택 후 보관 가능한 보관함 모두 출력 메소드
	public void parcelboxUpdate() {
		
	}
	
	// 보관함 비밀번호 설정/생성 메소드
	public void passwordCreate() {
		// 함번호
		System.out.println("함 번호를 입력하세요 : "); int bnumber = sc.nextInt();
		
		System.out.println("\n\n ----- 비밀번호 생성해주세요 -------- ");
		System.out.println("비밀번호 : "); String pwCreate = sc.next();
		
		// 생성한 비밀번호 컨트롤에게 전달 
		boolean result2 = 
				RiderController.getInstance().passwordCreate( bnumber , pwCreate);
		
	}
	
	// 고객에게 문자 발송 메소드
	
	
	
}














