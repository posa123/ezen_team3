package team3.view;

import java.util.Scanner;

import team3.controller.Controller;

// 설계
public class MainPage {
	
	MainPage mainPage = new MainPage();	
	Scanner scanner = new Scanner(System.in);
    // 도서 등록 
	String 도서등록() {
		System.out.print("등록할 도서를 입력해주세요."); String 도서이름 = scanner.next();
		System.out.print("등록할 도서를 입력해주세요."); String 도서작가 = scanner.next();
		System.out.print("등록할 도서를 입력해주세요."); String 도서출판사 = scanner.next();
		boolean a =  Controller.getIController().도서등록( 도서이름 , 도서작가 , 도서출판사 );
		if(a) {
			System.out.println("등록했습니다");
		}else {
			System.out.println("등록에 실패했습니다");
		}
	return null;
	} 
	// 도서 삭제
	String 도서삭제() {
		System.out.println("삭제할 도서이름을 입력해주세요"); String 도서이름 = scanner.next();
		boolean a =  Controller.getIController().도서등록삭제( 도서이름 );
		if(a) {
			System.out.println("삭제했습니다");
		}else {
			System.out.println();
		}
		return null;
	}

	// 도서 대여
	String 도서대여() {
		return null;
	}
	// 도서 반납
	String 도서반납() {return null;}
	
	
} // class e
