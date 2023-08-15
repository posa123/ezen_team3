package project_csb.controller;



//기사 컨트롤러
public class RiderController {
	// 싱글톤
	private static RiderController controller = new RiderController();
	private RiderController() {}
	public static RiderController getInstance() {return controller;}
	
	
}
