package project_csb.view;



//기사 핸드폰 view
public class RiderPhoneView {
	// 싱글톤
	private static RiderPhoneView view = new RiderPhoneView();
	private RiderPhoneView() {}
	public static RiderPhoneView getInstance() {return view;}	
}
