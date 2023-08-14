package project_csb.model.dao;


import java.lang.reflect.Array;
import java.util.ArrayList;

import project_csb.database.ConnectJdbc;
import project_csb.model.dto.UserPhoneDto;

//유저 핸드폰 dao
public class UserPhoneDao extends ConnectJdbc {
	// 싱글톤
	private static UserPhoneDao dao = new UserPhoneDao();
	private UserPhoneDao() {}
	public static UserPhoneDao getInstance() {return dao;}	
	
	public ArrayList<Integer> invoiceNumber(String phoneSession){
		// 배열선언하는이유는 유저가 전화번호를 입력했을때 배송상태/송장번호가 여러개 일수있기때문에 그갯수만큼 넣는다 
			// 배열선언을 해주지않으면 여러개의 배송정보를 부를수가없다.
		ArrayList<Integer> invoicelist = new ArrayList<>(); 
		try {
			// SQL작성한다
				// 송장번호를 보기위해 , 배송상태를 확인하기위해 유저핸드폰번호를 입력한다.
			String sql = "select InvoiceNumber from Delivery_status where Customer_phone_numbe = ? ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {	
				// 배열안에 넣는다
				invoicelist.add(rs.getInt(1));
				
			}// w e	
		}catch (Exception e) {System.out.println(e);}
		return invoicelist;
	}
	
}
