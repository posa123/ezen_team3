package project_csb.model.dto;
//기사 핸드폰 dto
public class RiderPhoneDto {

	// 배송번호
	private int lineNumber;
	// 송장번호 
	private String incoiceNumber;
	// 물건코드 
	private int bitem;
	// 기사코드
	private int barticle;
	// 고객 전화번호 
	private String userPhone;
	// 배송 상태 
	private boolean DeliveryStatus;
	
	// 기본생성자 
	public RiderPhoneDto() {}

	

	public RiderPhoneDto(int lineNumber, String incoiceNumber, int bitem, int barticle, String userPhone,
			boolean deliveryStatus) {
		super();
		this.lineNumber = lineNumber;
		this.incoiceNumber = incoiceNumber;
		this.bitem = bitem;
		this.barticle = barticle;
		this.userPhone = userPhone;
		DeliveryStatus = deliveryStatus;
	}



	// getter and setter
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getIncoiceNumber() {
		return incoiceNumber;
	}

	public void setIncoiceNumber(String incoiceNumber) {
		this.incoiceNumber = incoiceNumber;
	}

	public int getBitem() {
		return bitem;
	}

	public void setBitem(int bitem) {
		this.bitem = bitem;
	}

	public int getBarticle() {
		return barticle;
	}

	public void setBarticle(int barticle) {
		this.barticle = barticle;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public boolean isDeliveryStatus() {
		return DeliveryStatus;
	}

	public void setDeliveryStatus(boolean deliveryStatus) {
		DeliveryStatus = deliveryStatus;
	}

	// to string 
	@Override
	public String toString() {
		return "RiderPhoneDto [lineNumber=" + lineNumber + ", incoiceNumber=" + incoiceNumber + ", bitem=" + bitem
				+ ", barticle=" + barticle + ", userPhone=" + userPhone + ", DeliveryStatus=" + DeliveryStatus + "]";
	} 
	
	
}
