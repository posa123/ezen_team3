package project_csb.csb.user.model.dao;

//사용자 dao
public class Dao {
	// 싱글톤
	private static Dao dao = new Dao();
	private Dao() {}
	public static Dao getInstance() {return dao;}	
}
