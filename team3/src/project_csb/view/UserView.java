package project_csb.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import project_csb.controller.UserController;
import project_csb.utilSet.ExtraUtil;
import project_csb.utilSet.MainInterface;

// 사용자 view
public class UserView implements MainInterface{
	// 싱글톤
	private static UserView userView = new UserView();
	private UserView() {}
	public static UserView getInstance() {return userView;}	
	
	
	@Override
	public void OutPutFront() {
		try {
			System.out.println("============== 물건 찾기 ================");
			
			System.out.print("찾아가실 물건이 위치한 보관함 번호를 입력해주세요 [1-20]: "); int bnumber = ExtraUtil.getInstance().getScInstance().nextInt();
			
				// 보관함 유효성 검사
				if(UserController.getInstance().checkLocker( bnumber ) == false) {
					System.out.println("보관함이 비어있습니다.");
					return;
				}
			
			System.out.print("보관함의 비밀번호를 입력해주세요."); String bpw = ExtraUtil.getInstance().getScInstance().next();
				
				// 비밀번호 유효성 검사
				if(ExtraUtil.getInstance().passwordCheck(bpw) == false) {
					System.out.println("잘못 입력하셨습니다.");
					return;
				}
			
			// 물건 찾기 메소드
			if(UserController.getInstance().findBox(bnumber, bpw) == true) 
				System.out.println("물품을 가져가주세요.\n이용해 주셔서 감사합니다.");					
			else 
				System.out.println("잘못된 비밀번호입니다.");
					
					
		}catch(InputMismatchException e) {
			System.out.println("잘못 입력하셨습니다"); 
			ExtraUtil.getInstance().setScInstance(new Scanner(System.in));
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}	
}
