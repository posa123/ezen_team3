package project_csb.model.dao;

//사용자 dao
public class UserDao {
	// 싱글톤
	private static UserDao dao = new UserDao();
	private UserDao() {}
	public static UserDao getInstance() {return dao;}	
}
