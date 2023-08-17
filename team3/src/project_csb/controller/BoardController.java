package project_csb.controller;

import java.util.ArrayList;

import project_csb.model.dao.BoardDao;
import project_csb.model.dto.BoardDto;
import project_csb.utilSet.ExtraUtil;

//게시판 컨트롤러
public class BoardController {
	// 싱글톤
	private static BoardController controller = new BoardController();
	private BoardController() {}
	public static BoardController getInstance() {return controller;}
	
	// boardWrite : 게시판 쓰기 메소드
	public boolean boardWrite(  String contentPosts, String writerPhoneNumber) {
		
		//유효성 검사
		if(ExtraUtil.getInstance().phoneNumberCheck(writerPhoneNumber) == false)
			return false;
		BoardDto boardDto = new BoardDto( contentPosts , writerPhoneNumber);
		return BoardDao.getInstance().boardWrite(boardDto);
	}
	
	// boardPrint : 글 조회 메소드
	public ArrayList<BoardDto> boardPrint() {
		return BoardDao.getInstance().boardPrint();
	}
	
}
