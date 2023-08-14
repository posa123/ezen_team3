package project_csb.model.dto;
// 유저핸드폰 dto
public class UserPhoneDto {
	
	// 함번호
	private int bnumber;
	// 비밀번호 
	private int bpw;
	
	// 기본생성자 
	public UserPhoneDto() {}
	
	// 풀생성자 
	public UserPhoneDto(int bnumber, int bpw) {
		super();
		this.bnumber = bnumber;
		this.bpw = bpw;
	}

	// getter and setter
	public int getBnumber() {
		return bnumber;
	}

	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}

	public int getBpw() {
		return bpw;
	}

	public void setBpw(int bpw) {
		this.bpw = bpw;
	}

	// toString 생성
	@Override
	public String toString() {
		return "UserPhoneDto [bnumber=" + bnumber + ", bpw=" + bpw + "]";
	}
	
	
	
	
}
