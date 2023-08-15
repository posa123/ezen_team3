package project_csb.model.dto;


// 유저핸드폰 dto
public class UserPhoneDto{
	
	// 함번호
	private int bnumber;
	// 비밀번호 
	private String bpw;
	// 수신일
	private String dateRecipt;
	
	
	// 기본생성자 
	public UserPhoneDto() {}
	

	// 풀생성자 
	public UserPhoneDto(int bnumber, String bpw , String dateRecipt) {
		super();
		this.bnumber = bnumber;
		this.bpw = bpw;
		this.dateRecipt = dateRecipt;
	}

	public String getDateRecipt() {
		return dateRecipt;
	}


	public void setDateRecipt(String dateRecipt) {
		this.dateRecipt = dateRecipt;
	}


	// getter and setter
	public int getBnumber() {
		return bnumber;
	}

	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}

	public String getBpw() {
		return bpw;
	}

	public void setBpw(String bpw) {
		this.bpw = bpw;
	}

	// toString 생성
	@Override
	public String toString() {
		return "UserPhoneDto [bnumber=" + bnumber + ", bpw=" + bpw + "]";
	}
	
	
	
	
}
