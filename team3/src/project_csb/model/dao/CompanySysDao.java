package project_csb.model.dao;


//회사 시스템 dao
public class CompanySysDao {
	// 싱글톤
	private static CompanySysDao dao = new CompanySysDao();
	private CompanySysDao() {}
	public static CompanySysDao getInstance() {return dao;}	
}
