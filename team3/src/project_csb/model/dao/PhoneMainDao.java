package project_csb.model.dao;


//핸드폰 메인 dao
public class PhoneMainDao {
	// 싱글톤
	private static PhoneMainDao dao = new PhoneMainDao();
	private PhoneMainDao() {}
	public static PhoneMainDao getInstance() {return dao;}	
}
