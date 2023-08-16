package project_csb.model.dao;



//게시판 dao
public class BoardDao {
	// 싱글톤
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {return dao;}	
	
	//boardWrite : 게시판 쓰기 메소드
	public boolean boardWrite( BoardDao boardDao) {
		try {
			String sql="";
			ps = conn.prepareStatement(spl);
			
			ps.setString(1,boardDto.getpostTitle());
			ps.setString(2,boardDto.getcontentPosts());
			ps.setString(3,boardDto.getwriterPhoneNumber());
			
			int row = ps.executeUpdate();
			if(row==1) return true;
			
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	//boardPrint : 글 조회 메소드
	public ArraryList<BoardDto> boardPrint() {
		ArraryList<BoardDto> list = new ArrayList<>();
		try {
			String sql="";
			ps = conn.preparStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));
				list.add(dto);
			}
		}catch (Exception e) {}
		return list;
	}
}
