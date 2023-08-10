package project_csb.model.dao;


// 기사 dao
public class RiderDao {
	// 싱글톤
	private static RiderDao dao = new RiderDao();
	private RiderDao() {}
	public static RiderDao getInstance() {return dao;}	
}
