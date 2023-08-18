package project_csb.model.dto;
//기사 dto
public class RiderDto {

	// 보관함번호 
	private int bnumber;
	
	// 비밀번호
	private String bpw;
	
	// 보관함 카테고리/설정  
	private String bsituation;
	
	// 기본생성자
	public RiderDto() {}

	// 풀생성자 
	public RiderDto(int bnumber, String bpw, String bsituation) {
		super();
		this.bnumber = bnumber;
		this.bpw = bpw;
		this.bsituation = bsituation;
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

	public String getBsituation() {
		return bsituation;
	}

	public void setBsituation(String bsituation) {
		this.bsituation = bsituation;
	}

	
	// toString 생성자 
	@Override
	public String toString() {
		return "RiderDto [bnumber=" + bnumber + ", bpw=" + bpw + ", bsituation=" + bsituation + "]";
	}
	
	
	
	
	
	
	
	
	
}
