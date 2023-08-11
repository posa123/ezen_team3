package project_csb.controller;


//회사 시스템 컨트롤러
public class CompanySysController {
		// 싱글톤
		private static CompanySysController controller = new CompanySysController();
		private CompanySysController() {}
		public static CompanySysController getInstance() {return controller;}
	
}
