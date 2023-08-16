package project_csb.model.dao;


import java.util.ArrayList;
import project_csb.database.ConnectJdbc;

//유저 핸드폰 dao
public class UserPhoneDao extends ConnectJdbc {
	// 싱글톤
	private static UserPhoneDao dao = new UserPhoneDao();
	private UserPhoneDao() {}
	public static UserPhoneDao getInstance() {return dao;}	
	
	public ArrayList<Integer> invoiceNumber(String phoneSession){
		// 배열선언하는이유는 유저가 전화번호를 입력했을때 배송상태/송장번호가 여러개 일수있기때문에 그갯수만큼 넣는다 
			// 배열선언을 해주지않으면 여러개의 배송정보를 부를수가없다.
		ArrayList<Integer> invoiceList = new ArrayList<>(); 
		try {
			// SQL작성한다
				// 송장번호를 보기위해 , 배송상태를 확인하기위해 유저핸드폰번호를 입력한다.
			String sql = "select InvoiceNumber from Delivery_status where Customer_phone_numbe = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, phoneSession);
			rs = ps.executeQuery();
			// 레코드값이 몇개인지 모르기 때문에 while문 사용
			while(rs.next()) {	
				// 배열안에 넣는다
				invoiceList.add(rs.getInt(1));			
			}// w e	
		}catch (Exception e) {System.out.println(e);}
		//배열 반환
		return invoiceList;
	}
	
	// 배송상태확인/출력
	public int deliveryStatus(int invoiceNumber) {
		
		try {
			// 1. sql작성
			String sql = "select delivery_status from Delivery_status where InvoiceNumber = ?";
			
			ps = conn.prepareStatement(sql);
			// ? 를 채울값을 넣어야된다 
			ps.setInt(1, invoiceNumber);
			rs = ps.executeQuery();
			// true = 1  false = 2  Error = 0 
			// 먀냐게 반환값이 true면 배송완료  반환값이 false면 배송중 반환값이 Error면 실패 
			// delivery_status 는 배달중 배달완료 이기때문에 getBoolean 타입이들어간다 
			
			if(rs.next()) {
				
				if(rs.getBoolean(1) == true) 
					return 1;
				else
					return 2;
				
			}											
		}catch (Exception e) {System.out.println(e);}	
		return 0;
	}	
}// class e










