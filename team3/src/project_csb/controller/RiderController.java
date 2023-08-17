package project_csb.controller;

import java.util.ArrayList;

import project_csb.model.dao.RiderDao;
import project_csb.model.dto.RiderDto;

//기사 컨트롤러
public class RiderController {
	// 싱글톤
	private static RiderController controller = new RiderController();
	private RiderController() {}
	public static RiderController getInstance() {return controller;}
	
	
	// 1. 보관 가능한 모든 보관함 번호 출력 메소드
	public int numberPrint() {return 1;}
	
	// 2. 보관함 카테고리 선택 후 보관 가능한 보관함 모두 출력 메소드
		// 해당카테고리를 선택/입력 했을때 비어있는/null 테이블을 찾아야한다 
	public ArrayList<Integer> categoryPrint( String bsituation ) {
		
		                                                              
		return RiderDao.getInstance().categoryPrint(bsituation);
	}
	
	// 3. parcelboxUpdate : 택배함 보관 내역 테이블 수정 
	public boolean parcelboxUpdate() {return false;}
	
	// 5. 비밀번호 설정/생성 메소드
	public int passwordCreate(int bpw) {
		System.out.println("\n\n ----- passwordCreate 컨트롤 도착 -----");
		System.out.println(bpw);
		
		boolean result = RiderDao.getInstance().passwordCreate(bpw);
		
		// 결과를 view에게 전달 
		if(result) return 1;
		else return 2;
	}
	
	// 6. 고객에게 문자발송 메소드
	
	
	// 7. 고객에게 보관함 번호와 비밀번호 전달 하기  
	public ArrayList<RiderDto> CustomerRelay(){
		
		return null;
	}
	
}
