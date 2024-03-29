package project_csb.model.dao;

import java.util.ArrayList;

import project_csb.database.ConnectJdbc;
import project_csb.model.dto.BoardDto;

//게시판 dao
public class BoardDao extends ConnectJdbc{
	// 싱글톤
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {return dao;}	
	
	//boardWrite : 게시판 쓰기 메소드
	public boolean boardWrite( BoardDto boardDto) {
		try {
			String sql = "insert into bulletinBoard (contentPosts ,  writerPhoneNumber) values( ? , ?)";
			ps = conn.prepareStatement(sql);	
			ps.setString(1,boardDto.getContentPosts());
			ps.setString(2,boardDto.getWriterPhoneNumber());			
			int row = ps.executeUpdate();
			if(row==1) return true;
			
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	//boardPrint : 글 조회 메소드
	public ArrayList<BoardDto> boardPrint() {
		ArrayList<BoardDto> dtoList = new ArrayList<>();
		try {
			String sql="select postNumber ,contentPosts,dateCreatedDatetime from bulletinBoard ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), rs.getString(2), rs.getString(3) 
						);
				dtoList.add(dto);
			}
		}catch (Exception e) {System.out.println(e);}
		return dtoList;
	}
}
