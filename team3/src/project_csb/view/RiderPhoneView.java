package project_csb.view;

import project_csb.interfaceSet.MainInterface;

//기사 핸드폰 view
public class RiderPhoneView implements MainInterface {
	// 싱글톤
	private static RiderPhoneView view = new RiderPhoneView();
	private RiderPhoneView() {}
	public static RiderPhoneView getInstance() {return view;}
	@Override
	public void OutPutFront() {
		System.out.println("기사폰 실행");
		
	}
}
