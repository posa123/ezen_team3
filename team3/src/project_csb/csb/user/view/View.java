package project_csb.csb.user.view;


// 사용자 view
public class View {
	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}	
}
