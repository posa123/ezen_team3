package team3.model.dto;

public class BookDto {
	// 1. 필드
	private String 책이름;
	private String 작가;
	private String 출판사;
	private boolean 대출여부;
	// 2. 생성자
	public BookDto(String 책이름, String 작가, String 출판사 ) {
		super();
		this.책이름 = 책이름;
		this.작가 = 작가;
		this.출판사 = 출판사;
		this.대출여부 = true;
	}
	public BookDto() {
		// TODO Auto-generated constructor stub
	}
		// 3. 메소드
	public String get책이름() {
		return 책이름;
	}
	public void set책이름(String 책이름) {
		this.책이름 = 책이름;
	}
	public String get작가() {
		return 작가;
	}
	public void set작가(String 작가) {
		this.작가 = 작가;
	}
	public String get출판사() {
		return 출판사;
	}
	public void set출판사(String 출판사) {
		this.출판사 = 출판사;
	}
	public boolean is대출여부() {
		return 대출여부;
	}
	public void set대출여부(boolean 대출여부) {
		this.대출여부 = 대출여부;
	}
	@Override
	public String toString() {
		return "BookDto [책이름=" + 책이름 + ", 작가=" + 작가 + ", 출판사=" + 출판사 + ", 대출여부=" + 대출여부 + "]";
	}
	

		
	}

