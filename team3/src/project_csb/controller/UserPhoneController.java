package project_csb.controller;


// 유저 핸드폰 컨트롤러
public class UserPhoneController {
	// 싱글톤
	private static UserPhoneController controller = new UserPhoneController();
	private UserPhoneController() {}
	public static UserPhoneController getInstance() {return controller;}
	
	// 송장번호 확인하는메소드 
	public boolean invoiceNumber() {
		
		return false;
	}
	
}
