package project_csb.interfaceSet;

public interface AddRandom extends MainInterface{
	
	// 인증번호 생성 메소드
	public default int certNumber() {
		int certNumber = (int)((Math.random() * 8888) + 1000 );
		return certNumber;
	}
}
