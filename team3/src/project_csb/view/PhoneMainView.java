package project_csb.view;

import project_csb.interfaceSet.MainInterface;

// 핸드폰 메인화면 view
public class PhoneMainView implements MainInterface{
	// 싱글톤
	private static PhoneMainView view = new PhoneMainView();
	private PhoneMainView() {}
	public static PhoneMainView getInstance() {return view;}	
		
	@Override
	public void OutPutFront() {	
		System.out.print("\n\n전화번호 입력 : "); 
		
		//String phoneNumber = scannerValue();
		
		//만약 전화번호가 기사 전화번호라면 기사 view 사용자 전화번호라면 사용자 view		
		
	}
}
