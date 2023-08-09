package project_csb.joinPhone.userPhone.model.dao;



//유저 핸드폰 dao
public class Dao {
	// 싱글톤
	private static Dao dao = new Dao();
	private Dao() {}
	public static Dao getInstance() {return dao;}	
}
