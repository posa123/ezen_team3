package project_csb.joinPhone.phoneMain.view;


// 핸드폰 메인화면 view
public class View {
	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}	
}
