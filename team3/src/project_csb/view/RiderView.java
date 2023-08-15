package project_csb.view;

import project_csb.utilSet.MainInterface;

//기사 view
public class RiderView implements MainInterface{
	// 싱글톤
	private static RiderView riderView = new RiderView();
	private RiderView() {}
	public static RiderView getInstance() {return riderView;}	
	
	@Override
	public void OutPutFront() {
		System.out.println("\n\n기사 view 실행");
		//택배사 입력하기
		System.out.println("택배사 입력하세요 : ");
		//기사 인증하기
		//보관함과 비밀번호 설정하기
		//고객(사용자)에게 보관함 번호와 비밀번호 전달하
	}
}
