package project_csb.joinPhone.phoneMain.model.dao;


//핸드폰 메인 dao
public class Dao {
	// 싱글톤
	private static Dao dao = new Dao();
	private Dao() {}
	public static Dao getInstance() {return dao;}	
}
