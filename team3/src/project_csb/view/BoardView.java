package project_csb.view;

import java.util.ArrayList;
import java.util.Scanner;

import project_csb.controller.BoardController;
import project_csb.model.dto.BoardDto;
import project_csb.utilSet.MainInterface;

//게시판 view
public class BoardView implements MainInterface{
	// 싱글톤
	private static BoardView boardView = new BoardView();
	private BoardView() {}
	public static BoardView getInstance() {return boardView;}	
	
	private Scanner sc = new Scanner(System.in);
	
	@Override
	// 게시판 뷰 실행 메소드
	public void OutPutFront() {
		
		System.out.println(" ====== 게시판 뷰 실행 ======= ");
		System.out.print("1.글쓰기 2.글조회 선택 : ");
		try {
			int ch = sc.nextInt();
			if( ch == 1) { boardWrite(); }
			if( ch == 2) { boardPrint(); }
		}catch (Exception e) {
			System.out.println("경고)잘못된 입력입니다. ");
			sc = new Scanner(System.in);
			
		}
	}
	
	// 게시판 쓰기 메소드
	public void boardWrite() {
		System.out.println(" ====== 게시판 글쓰기 ======= ");
		sc.nextLine();
		System.out.print("제목 > "); 			String postTitle = sc.nextLine();
		System.out.print("내용 > "); 			String contentPosts = sc.nextLine();
		System.out.println("전화번호 > ");		String writerPhoneNumber = sc.nextLine();
		
		boolean result = 
				BoardController.getInstance().boardWrite(postTitle, contentPosts, writerPhoneNumber);
		if(result) {System.out.println("안내) 글쓰기 등록 ");}
		else {System.out.println("안내) 글쓰기 실패 : 제목 1~50 사로 필수 입력");}
	}
	
	//글 조회 메소드 (모든 게시물 조회)
	public void boardPrint() {
		System.out.println(" ====== 게시판 글조회 ======= ");
		ArrayList<BoardDto> result = BoardController.getInstance().boardPrint();
		System.out.printf("%-10s %-10s %-10s %-10s %-10s \n","no","title","content","phoneNumber","date");
		for(int i = 0; i<result.size(); i++) {
			BoardDto dto = result.get(i);	// i번째의 객체를 호출
			System.out.printf("%-10s %-10s %-10s %-10s %-10s \n",
					dto.getPostNumber(), dto.getPostTitle(), dto.getContentPosts(), dto.getWriterPhoneNumber(), dto.getDateCreatedDatetime());
		}
	}
	
}
