package project_csb.model.dao;



//유저 핸드폰 dao
public class UserPhoneDao {
	// 싱글톤
	private static UserPhoneDao dao = new UserPhoneDao();
	private UserPhoneDao() {}
	public static UserPhoneDao getInstance() {return dao;}	
	
}
