package project_csb.view;

import java.util.Scanner;

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
			if( ch == 2) {}
		}catch (Exception e) {
			System.out.println("경고)잘못된 입력입니다. ");
			sc = new Scanner(System.in);
			
		}
	}
	// 게시판 쓰기 메소드
	public void boardWrite() {
		System.out.println(" ====== 게시판 글쓰기 ======= ");
		sc.nextLine();
		System.out.print("제목 > "); 		String title = sc.nextLine();
		System.out.print("내용 > "); 		String content = sc.nextLine();
		
	}
}
