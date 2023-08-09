package project_csb.companySys.controller;


//회사 시스템 컨트롤러
public class Controller {
		// 싱글톤
		private static Controller controller = new Controller();
		private Controller() {}
		public static Controller getInstance() {return controller;}
}
