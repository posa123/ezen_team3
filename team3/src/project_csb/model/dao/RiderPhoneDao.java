package project_csb.model.dao;



//기사 핸드폰 dao
public class RiderPhoneDao {
	// 싱글톤
	private static RiderPhoneDao dao = new RiderPhoneDao();
	private RiderPhoneDao() {}
	public static RiderPhoneDao getInstance() {return dao;}	
}
