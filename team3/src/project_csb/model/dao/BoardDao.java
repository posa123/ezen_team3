package project_csb.model.dao;



//게시판 dao
public class BoardDao {
	// 싱글톤
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {return dao;}	
}
