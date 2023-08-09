package project_csb.csb.rider.model.dao;


// 기사 dao
public class Dao {
	// 싱글톤
	private static Dao dao = new Dao();
	private Dao() {}
	public static Dao getInstance() {return dao;}	
}
