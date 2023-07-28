package team3.controller;

import team3.model.dao.BookDao;
import team3.model.dto.BookDto;

public class Controller {
	// { 0 , 노르웨이숲 , 2 ,  , null}
			
	private static Controller control = new Controller();
	
	private Controller() { }
		//생성자는 외부에서 호출 못하게 private으로 지정 (빈생성자)
	
	public static Controller getIController() {return control;}
	
	boolean 도서등록( String 책이름 , String 작가 , String 출판사) {
		BookDto BookDto = new BookDto( 책이름 , 작가 , 출판사 );
		for(int i=0; i < BookDao.BookList.length; i++) {
			if(BookDao.BookList[i]==null) {
				BookDao.BookList[i] = BookDto; 
				System.out.println("도서 등록 했습니다.");
				 return true;
			}//if e
		}//for e
		return false;
	}//boolean 도서등록 e
	
	boolean 도서등록삭제(String 책이름) {
		for(int i=0; i<BookDao.BookList.length; i++) {
			if(BookDao.BookList[i] != null &&
					BookDao.BookList[i].get책이름().equals(책이름))
				BookDao.BookList[i] = null;
				System.out.println("삭제 완료 했습니다.");
				return true;
		}//for e
		
		return false;
	}//boolean 도서등록삭제 e

	boolean 도서대여(String 책이름) {
		for(int i=0; i<BookDao.BookList.length; i++) {
			if(BookDao.BookList[i] != null &&
					BookDao.BookList[i].get책이름().equals(책이름))
				
				
				return true;
		}
		return false;
	}
	
}//class e

