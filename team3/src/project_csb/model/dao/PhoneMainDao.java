package project_csb.model.dao;

import project_csb.database.ConnectJdbc;

//핸드폰 메인 dao
public class PhoneMainDao extends ConnectJdbc{
	// 싱글톤
	private static PhoneMainDao dao = new PhoneMainDao();
	private PhoneMainDao() {}
	public static PhoneMainDao getInstance() {return dao;}	
	
	// 기사 판단 메소드
	public boolean isRiderPhone( String phoneSession ) {
		
		return false;
	}
}
