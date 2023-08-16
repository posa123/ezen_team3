package project_csb.controller;

import project_csb.model.dao.UserDao;

// 사용자 컨트롤러
public class UserController {
	// 싱글톤
	private static UserController controller = new UserController();
	private UserController() {}
	public static UserController getInstance() {return controller;}
	
	/*
	 * 보관함 비밀번호체크 메소드
	 */
	public boolean checkLocker( int bnumber ) {
		return UserDao.getInstance().checkLocker(bnumber);
	}
	
	/*
	 *  물건 찾기 메소드
	 */
	public boolean findBox( int bnumber , String bpw) {
		return UserDao.getInstance().findBox(bnumber, bpw);
	}
	
	
	
}
