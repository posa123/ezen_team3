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
	
	
	// 1. 기사 인증메소드
	public int RiderCertification() {
		
		
		return 1;
	}
	
	// 무인택배함 테이블 등록 
		// 보관함번호 , 비밀번호 , 보관함 카테고리/설정 
	public boolean SoldierCourierBox(int bnumber , int bpw , String bsituation) {
		RiderDto riderDto = 
				new RiderDto(bnumber, bpw, bsituation);
		
		return false;
	}
	
	// 2. 고객에게 보관함 번호와 비밀번호 전달 하기  
	public ArrayList<RiderDto> CustomerRelay(){
		
		return null;
	}
	
}
