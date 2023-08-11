package project_csb.database;

import java.sql.Connection;
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
			
			System.out.println("연동성공");
		}
		
		catch( Exception e) {
			System.out.println("연동 실패 사유 : " + e);
		}
	}
		
	
}

/*
view단 ----------
while(true){
System.out.println("1.배송현황 2.배송 건 수정 3. 배송 건 삭제");
if( 1 )
if ( 2 )
if( 3 )

}

controller단----------------
//
// 배송 현황(관리하기) 메소드
boxRegistration()

// 배송 건 수정 메소드
  	boxRegistUpdate()
 배송 건 삭제 메소드
 	boxRegistDelete()
 	
 	
 */


