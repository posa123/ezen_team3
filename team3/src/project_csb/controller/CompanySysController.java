package project_csb.controller;

import java.util.ArrayList;

import project_csb.model.dao.CompanySysDao;
import project_csb.model.dto.CompanySysDto;

//회사 시스템 컨트롤러
public class CompanySysController {
	// 싱글톤
	private static CompanySysController controller = new CompanySysController();
	private CompanySysController() {}
	public static CompanySysController getInstance() {return controller;}

	
	// 1. 배송 등록하기 메소드
	public boolean boxRegistration(int bitem, int barticle, String userPhone) {
		
		// dto 송장번호 , 물건코드 , 기사코드 , 유저핸드폰번호 , 배송상태 를 등록함 
		// boolean deliveryStatus 는 매개변수에 선언할필요가없다 sql설계과정에서 default true 기본값으로 true를 주었기때문에 
		CompanySysDto companySysDto =
					new CompanySysDto(madeInvoiceNumber() , bitem , barticle , userPhone);
		
		//  dao로 보낸다							
		return	CompanySysDao.getInstance().boxRegistration(companySysDto);
	}
	// 배송 관리
	public ArrayList<CompanySysDto> boxShipping() {
		// boxManagement();dao메소드를 return 값으로 view에게 보낸다 
		return CompanySysDao.getInstance().boxManagement();
	}

	// 3. 배송  수정 [ 선택한 배송 수정 ] // bitem = 수정할 물건의 식별[누구를 식별할껀가?] / barticle = 물건등록을요청한 기사와 물건코드가 일치할경우 [유효성검사]
	public int boxRegistUpdate(int lineNumber , int bitem, int barticle, String userPhone) {
		// 1. 유효성 검사
		if(bitem == CompanySysDao.getInstance().boxRegistration()) {return 1;}
		
		return 1;
	}
	public boolean boxRegistUpdate( int bitem, int barticle, String userPhone ) {
		
	}
	public boolean boxRegistUpdate(int barticle, String userPhone) {
		
	}
	public boolean boxRegistUpdate(String userPhone) {
		
	}
	// 4. 배송 삭제 [ 선택한 배송 삭제 ]
	public boolean boxRegistDelete() {
		
		return false;
	}
	
	// 송장번호 생성 메소드
      public int madeInvoiceNumber() {
         return (int)((Math.random() * 89999999) + 10000000);      
      }

	

}
