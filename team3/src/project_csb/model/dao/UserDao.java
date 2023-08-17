package project_csb.model.dao;

import project_csb.database.ConnectJdbc;

//사용자 dao
public class UserDao extends ConnectJdbc{
	// 싱글톤
	private static UserDao dao = new UserDao();
	private UserDao() {}
	public static UserDao getInstance() {return dao;}	
	
	/*
	 * 보관함 체크 메소드
	 */
	public boolean checkLocker( int bnumber ) {
		try {
			String sql = "select bpw from anmdtable where bnumber = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bnumber);
			rs = ps.executeQuery();
			if(rs.next()) {
				
				if(rs.getString(1) == null) 
					return false;
							
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return true;
	}	
	/*
	 * 물건 찾기 메소드
	 */
	public boolean findBox( int bnumber , String bpw ) {
		try {
			String sql = "select bpw from anmdtable where bnumber = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bnumber );
			rs = ps.executeQuery();
			if(rs.next()) {				
				return bpw.equals(rs.getString(1)) ? true : false; 
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	/*
	 * 보관함 내역 설정 메소드
	 */
	
	
	/*
	 * 보관함 비밀번호 초기화 메소드
	 */
	
}
