package project_csb.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import project_csb.controller.CompanySysController;
import project_csb.model.dto.CompanySysDto;
import project_csb.utilSet.ExtraUtil;
import project_csb.utilSet.MainInterface;

//회사 시스템 view
public class CompanySysView implements MainInterface {
	// 싱글톤
	private static CompanySysView companySysView = new CompanySysView();
	private CompanySysView() {}
	public static CompanySysView getInstance() {return companySysView;}
	
	@Override
	public void OutPutFront() {

		while (true) {// 회사시스템 실행
			System.out.println("\n\n=============== 시스템 ==============");
			System.out.print("1.배송 등록하기 2.배송 관리 3.뒤로가기 선택>>");
			try {
				int ch = ExtraUtil.getInstance().getScInstance().nextInt();
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
			// 입력 타입이 정수가 아닌 다른 타입이라면
			catch(InputMismatchException e) {
				System.out.println("[잘못 입력하셨습니다.]");
				ExtraUtil.getInstance().setScInstance(new Scanner(System.in));} 
			//그 외
			catch (Exception e) {	System.out.println(e);break;}			
		} // while e
		
	}//회사시스템 메인 화면 끝

	// 배송 관리하기 메소드
	public void deliveryManegement() throws InputMismatchException{

		while (true) {
			System.out.println(" \n\n------- Delivery Management ------- ");
			System.out.println("1.배송현황 2.배송 건 수정 3.배송 건 삭제 4.뒤로가기 선택>>");
			
				int ch2 = ExtraUtil.getInstance().getScInstance().nextInt();
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
		} // while
		
	}// deliveryManegement e

	// 배송 등록하기 메소드
	public void boxRegistration() throws InputMismatchException{
		System.out.println(" \n\n------- Shipping registration ------- ");
		System.out.print("물건코드 입력 : "); int bitem = ExtraUtil.getInstance().getScInstance().nextInt();		
		System.out.print("기사코드 입력 : "); int barticle = ExtraUtil.getInstance().getScInstance().nextInt();		
		System.out.print("고객 전화번호 입력( '-' 제외 ) : "); String Customer_phone_numbe = ExtraUtil.getInstance().getScInstance().next();
		// 컨트롤러 메소드 호출 결과
		boolean result = CompanySysController.getInstance().boxRegistration(
											bitem, barticle, Customer_phone_numbe
											);		
		if(result) 
			System.out.println("안내) 배송 등록하기 완료");
		 else 
			System.out.println("안내) 배송 등록하기 실패");
		
	}//boxRegistration() e

	// 배송 현황출력 메소드
	public void boxShipping() {
		ArrayList<CompanySysDto> dto = CompanySysController.getInstance().boxShipping();
		System.out.printf("%-9s %-24s %-9s %-8s %-10s %-10s \n" , "배송번호" , "송장번호" , "물건코드" , "기사코드" , "고객휴대번호", "배송상태" );
		System.out.println("=============================================================================");
		for (int i = 0; i < dto.size(); i++) {
			CompanySysDto tmpDto = dto.get(i); // i번째의 객체를 호출
			System.out.printf("%-10s %-25s %-10s %-10s %-13s %-10s \n", 
					tmpDto.getLineNumber() , tmpDto.getInvoiceNumber(),
					tmpDto.getBitem() , tmpDto.getBarticle(), tmpDto.getUserPhone() , 
					(tmpDto.isDeliveryStatus() == false ? "배송 중" : "배송 완료"));
		}
	}

	// 배송 수정하기 메소드
	public void boxRegistUpdate() throws InputMismatchException{
		
		
		while(true) {
				System.out.println("\n\n========= 현황 수정 =========="); 	
				System.out.print("[수정할 건 번호를 입력해주세요]"); int lineNumber  = ExtraUtil.getInstance().getScInstance().nextInt();
								
				System.out.println("\n\n======수정하실 항목을 선택해주세요=====");
				System.out.print("1.송장번호 2.물건코드 3.기사코드 4.고객 전화번호 5.뒤로가기 선택>>");
				String invoiceNumber = null; int bitem = 0; int barticle = 0; String userPhone = null;
				
				int ch = ExtraUtil.getInstance().getScInstance().nextInt();
				
				switch(ch) {
					case 1 : 
						System.out.print("[수정하실 송장번호를 입력해주세요 (20자리이상)]"); invoiceNumber = ExtraUtil.getInstance().getScInstance().next();
						break;
					case 2 :
						System.out.print("[수정하실 물건코드를 입력해주세요]"); bitem = ExtraUtil.getInstance().getScInstance().nextInt();
						break;
					case 3 :
						System.out.println("[수정하실 기사코드를 입력해주세요]"); barticle = ExtraUtil.getInstance().getScInstance().nextInt();
						break;
					case 4 :
						System.out.println("[수정하실 고객 전화번호를 입력해주세요]( '-' 제외 )"); userPhone = ExtraUtil.getInstance().getScInstance().next();
						break;
					case 5 :
						return;											
				}	
				// 컨트롤러의 업데이트 메소드
				boolean result = CompanySysController.getInstance().boxRegistUpdate ( 
							lineNumber , invoiceNumber  ,  bitem  ,  barticle ,  userPhone );	
				
				if(result) 
					System.out.println("[수정 완료되었습니다]");				
				else 
					System.out.println("[수정 실패했습니다]");																	
		}		
	}	
	
	// 배송 삭제하기 메소드
	public void boxRegistDelete() throws InputMismatchException{
		
		System.out.println("\n\n========= 현황 삭제하기 ==========");
		System.out.print("[삭제할 건 번호를 입력해주세요]"); int lineNumber = ExtraUtil.getInstance().getScInstance().nextInt();
		
		boolean result = CompanySysController.getInstance().boxRegistDelete( lineNumber );
		if(result)System.out.println("[삭제 성공]");
		else System.out.println("[삭제 실패]");
		
	}
}
