package project_csb.controller;

import java.util.ArrayList;

import project_csb.model.dao.BoardDao;
import project_csb.model.dto.BoardDto;

//게시판 컨트롤러
public class BoardController {
	// 싱글톤
	private static BoardController controller = new BoardController();
	private BoardController() {}
	public static BoardController getInstance() {return controller;}
	
	// boardWrite : 게시판 쓰기 메소드
	public boolean boardWrite( String postTitle, String contentPosts, String writerPhoneNumber) {
		//유효성 검사
		if(postTitle.length() == 0 || postTitle.length() > 50) { return false; }
		//Dto
		BoardDto boardDto = new BoardDto (
				postTitle, contentPosts, writerPhoneNumber
				);
		return BoardDao.getInstance().boardWrite(boardDto);
	}
	
	// boardPrint : 글 조회 메소드
	public ArrayList<BoardDto> boardPrint() {
		return BoardDao.getInstance().boardPrint();
	}
	
}
