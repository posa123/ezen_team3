package project_csb.view;

import project_csb.interfaceSet.MainInterface;

//회사 시스템 view
public class CompanySysView implements MainInterface{
	// 싱글톤
	private static CompanySysView view = new CompanySysView();
	private CompanySysView() {}
	public static CompanySysView getInstance() {return view;}
	
	@Override
	public void OutPutFront() {
		System.out.println("companySys 실행");
	}
}
