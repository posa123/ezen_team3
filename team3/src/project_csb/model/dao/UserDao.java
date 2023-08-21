package project_csb.model.dao;

import project_csb.database.ConnectJdbc;

//사용자 dao
public class UserDao extends ConnectJdbc{
	// 싱글톤
	private static UserDao userDao = new UserDao();
	private UserDao() {}
	public static UserDao getInstance() {return userDao;}	
	
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
				//비밀번호 설정 되어 있으면
				if(rs.getString(1) != null) 
					return true;
							
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return false;
	}	
	/*
	 * 물건 찾기 메소드
	 */
	public boolean findBox( int bnumber , String bpw ) {
		try {
			boolean result = false;
			
			String sql = "select bpw from anmdtable where bnumber = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bnumber );
			rs = ps.executeQuery();
			
			if(rs.next()) {	
				
				result = bpw.equals(rs.getString(1)) ? true : false; 
				
			}
			// 물건 찾는 것이 성공했으면
			if(result == true) {
				//보관함 찾아간 일자 설정
				setVisitdate(bnumber);
				//보관함 비밀번호 초기화
				setPassword(bnumber);
				// true 반환
				return true;
			}	
		}catch(Exception e) {System.out.println(e);	}
				
		return false;
	}
	
	
	/*
	 * 보관함 내역 설정 메소드
	 */
	public void setVisitdate( int bnumber ) {
		try {
			String sql="update archistable set visitdate = now() where bnumber = ? and visitdate is null";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bnumber);
			ps.executeUpdate();		
		}catch(Exception e) {System.out.println(e);}		
	}
	
	/*
	 * 보관함 비밀번호 초기화 메소드
	 */
	public void setPassword( int bnumber ) {
		try {
			String sql="update anmdtable set bpw = null where bnumber = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bnumber );
			ps.executeUpdate();
		}catch(Exception e) {System.out.println(e);	}			
	}	
}
