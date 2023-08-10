package project_csb.view;

import project_csb.interfaceSet.MainInterface;

//기사 view
public class RiderView implements MainInterface{
	// 싱글톤
	private static RiderView view = new RiderView();
	private RiderView() {}
	public static RiderView getInstance() {return view;}	
	
	@Override
	public void OutPutFront() {
		System.out.println("\n\n기사 view 실행");
	}
}
