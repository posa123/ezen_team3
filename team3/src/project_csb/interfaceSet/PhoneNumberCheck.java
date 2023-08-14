package project_csb.interfaceSet;

public class PhoneNumberCheck {
	private static PhoneNumberCheck phoneNumberCheck = new PhoneNumberCheck();
	private PhoneNumberCheck() {}
	public static PhoneNumberCheck getInstance() {return phoneNumberCheck;}
	
	
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
	
}
