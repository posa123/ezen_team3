package project_csb;

import project_csb.view.MainView;

public class AppStart {
	public static void main(String[] args) {
		// 메인 view 실행 
		/*
		 utilSet패키지의 MainInterface에서 추상메소드인 OutPutFront를 선언합니다.
		 모든 View 클래스들은 MainInterface를 구현합니다. 또한 OutPutFront를 오버라이딩합니다.
		 ViewList클래스에서 ArrayList배열을 만들고, MainInterface를 구현한 객체들을 담습니다.
		 MainView와 CbsMainView는 배열의 인덱스에 접근하여 객체들의 오버라이딩 된 OutPutFront메소드를 사용합니다.
		 또한, ExtraUtil 클래스에 유효성 검사와 난수 생성 메소드 등 부가적인 기능들이 있습니다.
		 */
		MainView.getInstance().OutPutFront();
	}
}
