package project_csb.csb;

import project_csb.newInterface.MainInterface;

// 무인택배함 메인 페이지
public class CsbMainView implements MainInterface{
	// 싱글톤
	private static CsbMainView csbMainPage = new CsbMainView();
	private CsbMainView() {}
	public static CsbMainView getInstance() {return csbMainPage;}
	
	
	@Override
	public void OutPutFront() {
		while(true) {
		      System.out.println("=========메인 페이지==========");
		      System.out.print("1.물품등록 2.물품찾기 3.불편접수게시판");
		      
		}
	}
	
}
