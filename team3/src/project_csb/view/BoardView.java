package project_csb.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import project_csb.controller.BoardController;
import project_csb.model.dto.BoardDto;
import project_csb.utilSet.ExtraUtil;
import project_csb.utilSet.MainInterface;

//게시판 view
public class BoardView implements MainInterface{
	// 싱글톤
	private static BoardView boardView = new BoardView();
	private BoardView() {}
	public static BoardView getInstance() {return boardView;}	
	
	
	@Override
	// 게시판 뷰 실행 메소드
	public void OutPutFront() {
		while(true) {
			try {
				System.out.println("============== 건의사항 게시판 =============== ");
				System.out.print("1.글쓰기 2.글조회 3.뒤로가기 선택>> ");
				
				int ch = ExtraUtil.getInstance().getScInstance().nextInt();
				
				switch(ch) {
				case 1 :
					boardWrite();
					break;
				case 2:
					boardPrint(); 
					break;
				case 3:
					return;
				}		
			}
			
			catch(InputMismatchException e) {System.out.println("잘못 입력하셨습니다.");}
			catch (Exception e) {
				System.out.println("경고)잘못된 입력입니다. "+ e);
				ExtraUtil.getInstance().setScInstance(new Scanner(System.in));
				
			}	
		}
		
	}
	
	// 게시판 쓰기 메소드
	public void boardWrite() throws InputMismatchException{
		System.out.println(" \n\n================== 게시판 글쓰기 ==================== ");
		ExtraUtil.getInstance().getScInstance().nextLine();
		System.out.print("내용을 입력해주세요. > "); 			String contentPosts =  ExtraUtil.getInstance().getScInstance().nextLine();
		System.out.println("전화번호 > ");					String writerPhoneNumber =  ExtraUtil.getInstance().getScInstance().nextLine();
		
		boolean result = 
				BoardController.getInstance().boardWrite( contentPosts, writerPhoneNumber);
		if(result) {System.out.println("안내) 글쓰기 등록 ");}
		else {System.out.println("안내) 글쓰기 실패 : 제목 1~50 사로 필수 입력");}
	}
	
	//글 조회 메소드 (모든 게시물 조회)
	public void boardPrint() {
		System.out.println("\n\n =================== 게시판 글조회 ====================== ");
		ArrayList<BoardDto> result = BoardController.getInstance().boardPrint();
		System.out.printf("%-10s %-13s %-15s %-10s \n","게시글 번호","글 제목","글 내용","날짜");
		System.out.println("=====================================================");
		for(int i = 0; i<result.size(); i++) {
			BoardDto dto = result.get(i);	// i번째의 객체를 호출
			System.out.printf("%-12d %-12s %-13s %-10s \n",
					dto.getPostNumber(), dto.getPostTitle(), dto.getContentPosts(), dto.getDateCreatedDatetime());
		}
	}
	
}
