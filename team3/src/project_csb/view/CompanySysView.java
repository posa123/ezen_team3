package project_csb.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import project_csb.controller.CompanySysController;
import project_csb.interfaceSet.MainInterface;
import project_csb.model.dto.CompanySysDto;

//회사 시스템 view
public class CompanySysView implements MainInterface {
	// 싱글톤
	private static CompanySysView view = new CompanySysView();

	private CompanySysView() {
	}

	public static CompanySysView getInstance() {
		return view;
	}

	private Scanner sc = new Scanner(System.in);

	@Override
	public void OutPutFront() {

		while (true) {// 회사시스템 실행
			System.out.print("1.배송 등록하기 2.배송 관리 3.뒤로가기 선택>>");
			try {
				int ch = sc.nextInt();
				switch (ch) {
					// 배송 등록하기 실행
					case 1:						
						boxRegistration();
						break;
					// 배송 관리하기 실행
					case 2:						
						deliveryManegement();
						break;
					// 뒤로가기
					case 3:
						return;
						
				}// switch e
			}
			catch(InputMismatchException e) {
				System.out.println("[숫자만 입력가능합니다.]");
				sc=new Scanner(System.in);} 
			catch (Exception e) {	System.out.println(e);break;}			
		} // while e
		
	}//회사시스템 메인 화면 끝

	// 배송 관리하기 메소드
	public void deliveryManegement() {

		while (true) {
			System.out.println(" ------- Delivery Management ------- ");
			System.out.println("1.배송현황 2.배송 건 수정 3.배송 건 삭제 4.뒤로가기");
			try {
				int ch2 = sc.nextInt();
				switch (ch2) {
				// 배송 현황출력 메소드
				case 1:				
					boxShipping();
					break;
				// 배송 수정 메소드
				case 2:				
					boxRegistUpdate();
					break;
				// 배송 삭제 메소드
				case 3:				
					boxRegistDelete();
					break;
				// 뒤로가기
				case 4:
					return;

				}// switch e

			} 
			catch(InputMismatchException e) {
				System.out.println("[숫자만 입력가능합니다.]");
				sc=new Scanner(System.in);} 
			catch (Exception e) {	System.out.println(e);break;}			
		} // while
		
	}// deliveryManegement e

	// 배송 등록하기 메소드
	public void boxRegistration() {
		System.out.println(" ------- Shipping registration ------- ");
		System.out.print("물건코드 입력 : "); int bitem = sc.nextInt();		
		System.out.print("기사코드 입력 : "); int barticle = sc.nextInt();		
		System.out.print("고객 전화번호 입력 : "); String Customer_phone_numbe = sc.next();
		// 컨트롤러 메소드 호출 결과
		boolean result = CompanySysController.getInstance().boxRegistration(
											bitem, barticle, Customer_phone_numbe);		
		
		if(result) 
			System.out.println("안내) 배송 등록하기 완료");
		 else 
			System.out.println("오류) 배송 등록하기 실패");
		
	}//boxRegistration() e

	// 배송 현황출력 메소드
	public void boxShipping() {
		ArrayList<CompanySysDto> dto = CompanySysController.getInstance().boxShipping();

		for (int i = 0; i < dto.size(); i++) {
			CompanySysDto tmpDto = dto.get(i); // i번째의 객체를 호출
			System.out.printf("%-10s %-10s %-10s %-10s \n", tmpDto.getInvoiceNumber(), tmpDto.getBitem(),
					tmpDto.getBarticle(), tmpDto.getInvoiceNumber(), tmpDto.isDeliveryStatus());
		}
	}

	// 배송 수정하기 메소드
	public void boxRegistUpdate() {
		
		
		while(true) {
			try {
				System.out.print("\n\n========= 현황 수정 =========="); 	
				System.out.print("[수정할 건 번호를 입력해주세요]"); int lineNumber  = sc.nextInt();
								
				System.out.print("\n\n======수정하실 항목을 선택해주세요=====");
				System.out.print("1.송장번호 2.물건코드 3.기사코드 4.고객 전화번호 5.뒤로가기 선택>>");
				int invoiceNumber = 0; int bitem = 0; int barticle = 0; String userPhone = null;
				
				int ch = sc.nextInt();
				
				switch(ch) {
					case 1 : 
						System.out.print("[수정하실 송장번호를 입력해주세요]"); invoiceNumber = sc.nextInt();
						break;
					case 2 :
						System.out.print("[수정하실 물건코드를 입력해주세요]"); bitem = sc.nextInt();
						break;
					case 3 :
						System.out.println("[수정하실 기사코드를 입력해주세요]"); barticle = sc.nextInt();
						break;
					case 4 :
						System.out.println("[수정하실 고객 전화번호를 입력해주세요]"); userPhone = sc.next();
						break;
					case 5 :
						break;											
				}	
				// 컨트롤러의 업데이트 메소드
				boolean result = CompanySysController.getInstance().boxRegistUpdate ( 
							lineNumber , invoiceNumber  ,  bitem  ,  barticle ,  userPhone );	
				
				if(result)
					System.out.println("[수정 완료되었습니다]");
				else
					System.out.println("[수정 실패했습니다]");
			}
			catch(InputMismatchException e) {
				System.out.println("[숫자만 입력가능합니다.]");
				sc=new Scanner(System.in);} 
			catch (Exception e) {	System.out.println(e);break;}					
		}
		
	}	
	
	// 배송 삭제하기 메소드
	public void boxRegistDelete() {
		
		System.out.print("\n\n========= 현황 삭제하기 ==========");
		System.out.print("[삭제할 건 번호를 입력해주세요]"); int lineNumber = sc.nextInt();
		
		boolean result = CompanySysController.getInstance().boxRegistDelete( lineNumber );
		
	}
}
