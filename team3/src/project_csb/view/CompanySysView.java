package project_csb.view;

import java.util.ArrayList;
import java.util.Scanner;

import project_csb.controller.CompanySysController;
import project_csb.interfaceSet.AddScInt;
import project_csb.interfaceSet.AddScNext;
import project_csb.model.dto.CompanySysDto;

//회사 시스템 view
public class CompanySysView implements AddScInt , AddScNext {
	// 싱글톤
	private static CompanySysView view = new CompanySysView();
	private CompanySysView() {}
	public static CompanySysView getInstance() {return view;}
	private Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void OutPutFront() {
		System.out.println("companySys 실행");
		while(true) {//회사시스템 실행
			System.out.println("1.배송 등록하기 2.배송 관리");
			int ch = sc.nextInt();
			try {	
				if( ch == 1) {	//배송 등록하기 실행
					System.out.println(" ------- Shipping registration ------- ");
					String bitem = scannerNext();				System.out.println("물건코드 입력 : "+bitem);			
					String barticle= scannerNext();				System.out.println("기사코드 입력 : "+barticle);			
					String Customer_phone_numbe=scannerNext();	System.out.println("고객 전화번호 입력 : "+Customer_phone_numbe);	
					
					boolean result 
					= CompanySysController.getInstance().boxRegistration( bitem,barticle,Customer_phone_numbe);
					if(result) {System.out.println("안내) 배송 등록하기 완료");}
					else {System.out.println("오류) 배송 등록하기 실패");}
				}
				else if( ch == 2){	//배송 관리하기 실행
					System.out.println(" ------- Delivery Management ------- ");
					ArrayList<CompanySysDto> dto = CompanySysController.getInstance().boxManagement();
					for(int i = 0; i < dto.size(); i++) {
						CompanySysDto dto = dto.get(i);	// i번째의 객체를 호출
						System.out.println("%-10s %-10s %-10s %-10s \n",
								dto.Invoice_number, dto.bitem, dto.barticle, dto.Customer_phone_numbe,dto.Delivery_status);
				}
				
				}
			}catch (Exception e) {
				System.out.println("경고) 잘못된 입력입니다. ");
				sc = new Scanner(System.in); 
			}
		}//while e
	}
	
	//배송 등록하기 메소드
	
	//배송 관리하기 메소드
}
