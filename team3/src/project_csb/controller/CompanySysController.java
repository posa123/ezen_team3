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
	public boolean boxRegistration(int bitem, int barticle, String Customer_phone_numbe) {
		
		// dto 송장번호 , 물건코드 , 기사코드 , 유저핸드폰번호 , 배송상태 를 등록함 
		// boolean deliveryStatus 는 매개변수에 선언할필요가없다 sql설계과정에서 default true 기본값으로 true를 주었기때문에 
		CompanySysDto companySysDto =
					new CompanySysDto(madeInvoiceNumber() , bitem , barticle , Customer_phone_numbe);
		// 유효성 검사
			// 1. 전화번호가 11자리가 아니라면 false
		if(companySysDto.getUserPhone().length() != 11)return false;
			// 2. 전화번호에 -가 포함 되어있다면 false
		if(companySysDto.getUserPhone().contains("-") )return false;
			// 3. 전화번호에 앞 세개의 문자가 010이 아니라면 false
		if(!"010".equals(				
				""+companySysDto.getUserPhone().charAt(0) + 
					companySysDto.getUserPhone().charAt(1) +
						companySysDto.getUserPhone().charAt(2))				
				) return false;
			
		
				 
		//  dao로 보낸다							
		return	CompanySysDao.getInstance().boxRegistration(companySysDto);
	}
	// 배송 관리
	public ArrayList<CompanySysDto> boxShipping() {
		// boxManagement();dao메소드를 return 값으로 view에게 보낸다 
		return CompanySysDao.getInstance().boxManagement();
	}
	
	// 3. 배송  수정 [ 선택한 배송 수정 ] // bitem = 수정할 물건의 식별[누구를 식별할껀가?] / barticle = 물건등록을요청한 기사와 물건코드가 일치할경우 [유효성검사]	
	//  line_number 는 수정하는애가아니고 따로 식별
	public boolean boxRegistUpdate(int lineNumber , int Invoice_number , int bitem , int barticle , String userPhone) {
		
		CompanySysDto companySysDto = new CompanySysDto();
		companySysDto.setLineNumber(lineNumber);
		// 1. 유효성 검사
			// set : 값을 설정할때
		if(Invoice_number != 0) 
			companySysDto.setInvoiceNumber(Invoice_number);		
		
		else if(bitem != 0) 
			companySysDto.setBitem(bitem);	
		
		else if(barticle != 0) 
			companySysDto.setBarticle(barticle);
		
		else if(userPhone != null) {
			// 전화번호 유효성 검사
				// 1. 전화번호가 11자리가 아니라면 false
				if(userPhone.length() != 11)return false;
					// 2. 전화번호에 -가 포함 되어있다면 false
				if(userPhone.contains("-") )return false;
					// 3. 전화번호에 앞 세개의 문자가 010이 아니라면 false
				if(!"010".equals(				
						""+ userPhone.charAt(0) + 
								userPhone.charAt(1) +
									userPhone.charAt(2))				
								) return false;
				companySysDto.setUserPhone(userPhone);
		}
					
		
		// dto로 포장한 값을 dao에게 보낸다 (companySysDto)
		// dao에서 반환된 true/false 값을 view에게 보낸다 		 		
		return CompanySysDao.getInstance().boxRegistUpdate(companySysDto);
	}
	
	
	// 4. 배송 삭제 [ 선택한 배송 삭제 ]
	public boolean boxRegistDelete( int lineNumber ) {	
		// dao에게 행 번호 전달
		// 뷰에게 true/false 반환
		return CompanySysDao.getInstance().boxRegistDelete(lineNumber);
	}
	
	// 송장번호 생성 메소드
      public int madeInvoiceNumber() {
         return (int)((Math.random() * 89999999) + 10000000);      
      }

}
