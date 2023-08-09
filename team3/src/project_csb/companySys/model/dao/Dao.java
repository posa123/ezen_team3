package project_csb.companySys.model.dao;


//회사 시스템 dao
public class Dao {
	// 싱글톤
	private static Dao dao = new Dao();
	private Dao() {}
	public static Dao getInstance() {return dao;}	
}
