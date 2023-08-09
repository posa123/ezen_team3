package project_csb.companySys.view;


//회사 시스템 view
public class View {
	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}	
}
