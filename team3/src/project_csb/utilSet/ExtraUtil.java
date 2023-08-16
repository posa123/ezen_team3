package project_csb.utilSet;

import java.util.Scanner;

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
	/*
	 	phoneNumberCheck( String phoneNumber )메소드는 인자값으로 문자열(휴대폰 번호)를 받습니다.
	 	그 후 각각의 검사를 진행합니다.
	 	1. 전화번호가 11자리인지
	 	2. 전화번호에 -가 포함 되어있는지
	 	3. 전화번호 앞 세자리에 010이 포함되어 있는지
	 	한 가지라도 해당될 경우 false를 반환합니다.
	 */
	public boolean phoneNumberCheck( String phoneNumber ) {
		// 유효성 검사
			// 전화번호가 null이면 false
			if(phoneNumber == null)return false;
			// 1. 전화번호가 11자리가 아니라면 false
			if(phoneNumber.length() != 11)return false;
				// 2. 전화번호에 -가 포함 되어있다면 false
			if(phoneNumber.contains("-") )return false;
				// 3. 전화번호에 앞 세개의 문자가 010이 아니라면 false
			if(!"010".equals(				
					""+phoneNumber.charAt(0) + 
						phoneNumber.charAt(1) +
							phoneNumber.charAt(2))				
					) return false;
			
			return true;
	}
	
/*
 	===================================================================
	 madeInvoiceNumber() 메소드는 	10000000부터 99999999까지의 난수를 생성합니다.
*/	
	// 송장번호 생성 메소드
    public int madeInvoiceNumber() {
       return (int)((Math.random() * 89999999) + 10000000);      
    }
    
/*
 	===================================================================
 	certNumber() 메소드는 1000부터 9999까지의 난수를 생성합니다.
*/
    // 인증번호 생성 메소드
 	public int certNumber() {
 		int certNumber = (int)((Math.random() * 8999) + 1000 );
 		return certNumber;
 	}
	
 	
 	/*
 	 *  비밀번호 유효성 검사 메소드
 	 */
 	public boolean certPassword(String password) {
 		
 		if(password == null)return false;
 		if(password.length() != 4)return false;
 		try {
 			Integer.parseInt(password); 	
 		}catch(NumberFormatException e) {
 			return false;
 		}
 		return true;
 	}
}
