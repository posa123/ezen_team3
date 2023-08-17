package project_csb.model.dao;

import project_csb.database.ConnectJdbc;

//핸드폰 메인 dao
public class PhoneMainDao extends ConnectJdbc{
	// 싱글톤
	private static PhoneMainDao dao = new PhoneMainDao();
	private PhoneMainDao() {}
	public static PhoneMainDao getInstance() {return dao;}	
	
	// 기사 판단 메소드
	public boolean isRiderPhone( String phoneSession ) {
		
		try {
			String sql = "select barphone from couriertale where barphone = ?";		
			ps = conn.prepareStatement(sql);
			ps.setString(1, phoneSession);
			rs = ps.executeQuery();
			if(rs.next()) 
				return true;
			else
				return false;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
