package project_csb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// jdbc연동 클래스
public class ConnectJdbc {
	
	// 1. 필드
	// [ import java.sql ]
	public Connection conn; // DB연동 객체
	public PreparedStatement ps; // 연동된 DB 조작 객체
	public ResultSet rs;		// SQL 조작 결과를 가져오는 객체
	
	public ConnectJdbc() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectCsb","root","0000");
			System.out.println("연동성공");
		}
		
		catch( Exception e) {
			System.out.println("연동 실패 : " + e);
		}
	}
}


