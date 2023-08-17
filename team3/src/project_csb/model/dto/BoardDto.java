package project_csb.model.dto;
//게시판 dto
public class BoardDto {
	//1. 필드
		private int postNumber;					//게시물번호
		private String postTitle;				//게시물제목
		private String contentPosts;			//게시물내용
		private String writerPhoneNumber;		//작성자전화번호
		private String dateCreatedDatetime;		//작성일자
	
		//2. 생성자
		//빈생성자
		public BoardDto() {}
		//글등록시사용되는 생성자(풀생성자) 
		public BoardDto(int postNumber, String contentPosts, String postTitle, String dateCreatedDatetime,
				String writerPhoneNumber) {
			super();
			this.postNumber = postNumber;
			this.contentPosts = contentPosts;
			this.postTitle = postTitle;
			this.dateCreatedDatetime = dateCreatedDatetime;
			this.writerPhoneNumber = writerPhoneNumber;
		}
		public BoardDto(String contentPosts, String postTitle, String writerPhoneNumber) {
			super();
			this.contentPosts = contentPosts;
			this.postTitle = postTitle;
			this.writerPhoneNumber = writerPhoneNumber;
		}
		
	//3. 메소드
		public int getPostNumber() {
			return postNumber;
		}
		public void setPostNumber(int postNumber) {
			this.postNumber = postNumber;
		}
		public String getPostTitle() {
			return postTitle;
		}
		public void setPostTitle(String postTitle) {
			this.postTitle = postTitle;
		}
		public String getContentPosts() {
			return contentPosts;
		}
		public void setContentPosts(String contentPosts) {
			this.contentPosts = contentPosts;
		}
		public String getWriterPhoneNumber() {
			return writerPhoneNumber;
		}
		public void setWriterPhoneNumber(String writerPhoneNumber) {
			this.writerPhoneNumber = writerPhoneNumber;
		}
		public String getDateCreatedDatetime() {
			return dateCreatedDatetime;
		}
		public void setDateCreatedDatetime(String dateCreatedDatetime) {
			this.dateCreatedDatetime = dateCreatedDatetime;
		}
		@Override
		public String toString() {
			return "BoardDto [postNumber=" + postNumber + ", postTitle=" + postTitle + ", contentPosts=" + contentPosts
					+ ", writerPhoneNumber=" + writerPhoneNumber + ", dateCreatedDatetime=" + dateCreatedDatetime + "]";
		}
		
		
		
}
