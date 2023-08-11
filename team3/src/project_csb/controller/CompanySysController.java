package project_csb.controller;

import project_csb.model.dao.CompanySysDao;

//회사 시스템 컨트롤러
public class CompanySysController {
		// 싱글톤
		private static CompanySysController controller = new CompanySysController();
		private CompanySysController() {}
		public static CompanySysController getInstance() {return controller;}
		
		// 1. 배송 등록하기 메소드
		public boolean boxRegistration() {
			CompanySysDao.getInstance().boxRegistration();
			
			return false;
		}
		
		// 2. 배송 관리하기 메소드 
		public boolean boxManagement() {
			
			
			return false;
		}
		
}
