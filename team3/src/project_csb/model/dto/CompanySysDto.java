package project_csb.model.dto;

//회사 시스템 dto
public class CompanySysDto {
	
	// 행번호 
	private int lineNumber; 
	// 송장번호
	private int invoiceNumber;
	// 물건코드
	private int bitem;
	// 기사코드
	private int barticle;
	// 유저핸드폰번호
	private int userPhone;
	// 배송상태(기본값 true)
	private boolean DeliveryStatus;
	// 기본생성자
	public CompanySysDto() {}
	
	public CompanySysDto(int invoiceNumber, int bitem, int barticle, int userPhone) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.bitem = bitem;
		this.barticle = barticle;
		this.userPhone = userPhone;
	}
	// 풀 생성자
	public CompanySysDto(int line_number, int invoiceNumber, int bitem, int barticle, int userPhone,boolean deliveryStatus) {
		super();
		this.lineNumber = line_number;
		this.invoiceNumber = invoiceNumber;
		this.bitem = bitem;
		this.barticle = barticle;
		this.userPhone = userPhone;
		DeliveryStatus = deliveryStatus;
	}
	// 수정시 사용되는 생성자 
	public CompanySysDto(int line_number, int invoiceNumber, int bitem, int barticle, int userPhone) {
		super();
		this.lineNumber = line_number;
		this.invoiceNumber = invoiceNumber;
		this.bitem = bitem;
		this.barticle = barticle;
		this.userPhone = userPhone;
	}
	
	// getter and setter
	public int getLineNumber() {
		return lineNumber;
	}

	

	public void setLineNumber(int line_number) {
		this.lineNumber = line_number;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
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
		return "CompanySysDto [line_number=" + lineNumber + ", invoiceNumber=" + invoiceNumber + ", bitem=" + bitem
				+ ", barticle=" + barticle + ", userPhone=" + userPhone + ", DeliveryStatus=" + DeliveryStatus + "]";
	}
	
	
	
	
	
	
}
