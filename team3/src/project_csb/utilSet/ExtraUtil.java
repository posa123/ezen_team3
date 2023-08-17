package project_csb.utilSet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraUtil {
	private static ExtraUtil extraUtil = new ExtraUtil();
	private ExtraUtil() {}
	public static ExtraUtil getInstance() {return extraUtil;}
	
	//입력 객체
	private Scanner sc = new Scanner(System.in);
	// 게터
	public Scanner getScInstance() {return sc;}
	// 세터
	public void setScInstance( Scanner sc ) { this.sc = sc;}
	// 정규식에 필요한 클래스
	private Pattern p;
	private Matcher m;

	/*
	 	phoneNumberCheck( String phoneNumber )메소드는 인자값으로 문자열(휴대폰 번호)를 받습니다.
	 	그 후 각각의 검사를 진행합니다.
	 	1. 전화번호가 null인지
	 	2. 전화번호가 11자리인지
	 	3. 전화번호 앞 세자리에 010이 포함되어 있는지
	 	4. 숫자가 아닌 문자를 입력했는지
	 	한 가지라도 해당될 경우 false를 반환합니다.
	 	
	 	08/17 정규식 패턴으로 바꿨습니다.
	 */
	public boolean phoneNumberCheck( String phoneNumber ) {
		// 유효성 검사
		if(phoneNumber == null)return false;
    	p = Pattern.compile("010\\d{8}");
		m = p.matcher(phoneNumber);
		
		if(!m.matches() ) 
			return false;
			
		return true;
	}
	
	/*
	 *  invoiceNumberCheck( String invoiceNumber )메소드는 인자값으로 문자열( 송장 번호)를 받습니다.
	 *  그 후 각각의 검사를 진행합니다.
	 *  1. 송장번호가 null인지
	 *  2. 송장번호가 20자리 이상인지
	 *  3. 송장번호에 문자가 들어가는지
	 *  
	 *  08/17 정규식 패턴으로 바꿨습니다.
	 */
    public boolean invoiceNumberCheck( String invoiceNumber ) {
    	// 유효성 검사
    	if(invoiceNumber == null) return false;
    	p = Pattern.compile("\\d{20}");
		m = p.matcher(invoiceNumber);
		
		if(!m.matches() ) 
			return false;
		
    	return true;
    } 	
 	/*=================================================================
 	 *  비밀번호 유효성 검사 메소드는 인자 값으로 문자열(password)를 받습니다.
 	 *  그 후 각각의 검사를 진행합니다.
 	 *  1. password가 null이 아닌지
 	 *  2. password의 총 길이가 4가 아닌지
 	 *  3. 숫자가 아닌 문자를 입력했는지
 	 *  
 	 *  08/17 정규식 패턴으로 바꿨습니다.
 	 *  
 	 */
 	public boolean passwordCheck(String password) {
 		// 유효성 검사
 		if(password == null) return false;
 		p = Pattern.compile("\\d{4}");
		m = p.matcher(password);
		
		if(!m.matches() ) 
			return false;	
		
 		return true;
 	}
/*
 	===================================================================
 	certNumber() 메소드는 1000부터 9999까지의 난수를 생성합니다.
 	휴대전화 인증번호가 필요할 때 사용합니다.
*/
    // 인증번호 생성 메소드
 	public int certNumber() {
 		int certNumber = (int)((Math.random() * 8999) + 1000 );
 		return certNumber;
 	}
	


}
