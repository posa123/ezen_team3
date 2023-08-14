package project_csb;

import project_csb.view.MainView;

public class AppStart {
	public static void main(String[] args) {
		// 메인 view 실행 
		/*
		 먼저 interfaceSet패키지의 MainInterface에서 추상메소드인 OutPutFront를 선언합니다.ㅇ
		 모든 View 클래스들은 MainInterface를 구현합니다. 또한 OutPutFront를 오버라이딩합니다.
		 ViewList클래스에서 ArrayList배열을 만들고, MainInterface를 구현한 객체들을 담습니다.
		 MainView와 CbsMainView는 배열의 인덱스에 접근하여 객체들의 오버라이딩 된 OutPutFront메소드를 사용합니다.
		 추가로 난수생성이 필요한 view클래스는 MainInterface를 구현하는게 아닌 MainInterface를 상속받은 AddRandom 인터페이스를 구현합니다.
		 */
		MainView.getInstance().OutPutFront();
	}
}
