package project_csb.csb;

import project_csb.interfaceSet.AddScInt;
import project_csb.interfaceSet.MainInterface;
import project_csb.interfaceSet.ViewList;

// 무인택배함 메인 페이지
public class CsbMainView implements AddScInt{
	// 싱글톤
	private static CsbMainView csbMainPage = new CsbMainView();
	private CsbMainView() {}
	public static CsbMainView getInstance() {return csbMainPage;}
	// 
	private MainInterface mainFront;
	
	@Override
	public void OutPutFront() {
		while(true) {
		      System.out.println("\n\n======= 환영합니다.==========");
		      System.out.print("1.물품등록 2.물품찾기 3.불편접수게시판 4.뒤로가기");
				int ch = scannerValue() + 2;
				// 4입력시 return
				if(ch == 6) return;
				
				mainFront = ViewList.getInstance().arr.get(ch);
							
				mainFront.OutPutFront();
		}
	}
	
}
