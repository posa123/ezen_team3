package project_csb.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import project_csb.controller.RiderPhoneController;
import project_csb.model.dto.CompanySysDto;
import project_csb.model.dto.RiderPhoneDto;
import project_csb.utilSet.MainInterface;

//기사 핸드폰 view
public class RiderPhoneView implements MainInterface{
	// 싱글톤
	private static RiderPhoneView view = new RiderPhoneView();
	private RiderPhoneView() {}
	public static RiderPhoneView getInstance() {return view;}	
	
	private Scanner sc = new Scanner(System.in);
	
	// 1. 기사 휴대폰 메뉴/기능 
	@Override
	public void OutPutFront() {
		while(true) {
			System.out.println("\n\n =============== 기사 시스템 ============== ");
			System.out.println("1.할당된 배달건확인 2.배달 현황수정 3.뒤로가기 선택 >>");
			try {
				int ch = sc.nextInt();
				
				switch(ch) {
				case 1:
					cheakDelivery();
					break;
				case 2:
					updateDelivery();
					break;
				case 3:
					return;				
				}	
			}
			catch(InputMismatchException e) {System.out.println("[잘못 입력하셨습니다]");}
			catch(Exception e) {System.out.println(e);}
		}
		
		
		
	} // RiderSystem e
	
	// 2. 할당된 배달건확인 메소드
	public void cheakDelivery() {
		ArrayList<RiderPhoneDto> dtoList = RiderPhoneController.getInstance().boxRegistList();
		System.out.printf("\n\n%-8s %-8s %-8s %-8s %-8s %-9s \n" , "배송번호" , "송장번호" , "물건코드" , "기사코드" , "고객휴대번호", "배송상태" );
		System.out.println("==================================================================");
		for (int i = 0; i < dtoList.size(); i++) {
			RiderPhoneDto tmpDto = dtoList.get(i); // i번째의 객체를 호출
			System.out.printf("%-10s %-10s %-10s %-10s %-11s %-10s \n", 
					tmpDto.getLineNumber() , tmpDto.getIncoiceNumber(),
					tmpDto.getBitem() , tmpDto.getBarticle(), (tmpDto.getUserPhone()) , 
					(tmpDto.isDeliveryStatus() == false ? "배송 중" : "배송 완료"));
		}
	}
	// 3. 배달현황 수정 메소드 
	public void updateDelivery() {
		System.out.print("[수정하실 현황의 배송 번호를 입력해주세요]"); int lineNumber = sc.nextInt();
		if(RiderPhoneController.getInstance().deliveryCorrection( lineNumber ))
			System.out.println("수정 성공");
		else 
			System.out.println("수정 실패");
	}
	
}// class e
