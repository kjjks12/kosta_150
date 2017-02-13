package kosta.mvc.view;

import kosta.mvc.controller.EmpController;
import kosta.mvc.model.dto.FullTime;
import kosta.mvc.model.dto.PartTime;

public class MainView {
	public static void main(String [] args) {
	
		EmpController empcontroller = EmpController.getInstance(); 
		
	   System.out.println("\n----1. 전체 검색하기 ---------");
	   empcontroller.selectAll();
	   
	   System.out.println("*******************************");
	
	   System.out.println("\n----2-1.  Fulltime(정규직 사원검색) ---------");
	   empcontroller.searchByKind("full");
	   
	   System.out.println("\n----2-2.  Fulltime(비정규직 사원검색) ---------");
	   empcontroller.searchByKind("part");
	   
	   System.out.println("\n----2-3.  Fulltime( 잘못된 kind) ---------");
	   empcontroller.searchByKind("test");
	
	   System.out.println("***************************************************");
	   System.out.println("\n----3-1. kind와 사원번호에 해당하는 사원검색(있는경우) ---------");
	   empcontroller.searchByNo("part", 10);
	   
	   System.out.println("\n----3-2.  kind와 사원번호에 해당하는 사원검색(사원번호 잘못) ---------");
	   empcontroller.searchByNo("full", 40);
	   
	   System.out.println("\n----3-3.  kind와 사원번호에 해당하는 사원검색(kind잘못) ---------");
	   empcontroller.searchByNo("test", 10);
	
	   System.out.println("***************************************************");
	   System.out.println("\n----4-1.  kind에 해당하는 사원 등록 ---------");
	   empcontroller.insert("part", new PartTime(60, "삼순이", 2000));
	   
	   System.out.println("\n----4-2.  kind에 해당하는 사원 등록(사원번호 중복) ---------");
	   empcontroller.insert("part", new PartTime(10, "삼식이", 2000));
	   
	   System.out.println("\n----4-2.  kind에 해당하는 사원 등록(kind 잘못된경우) ---------");
	   empcontroller.insert("test", new PartTime(70, "삼식이", 2000));

	   System.out.println("***************************************************");
	   System.out.println("\n----5-1.  수정하기(성공성공) ---------");
	   empcontroller.update("full", new FullTime(20, null, 2500, 100));
	   
	   System.out.println("\n----5-2.  수정하기(수정실패 - 사원번호오류) ---------");
	   empcontroller.update("full", new FullTime(80, null, 3500, 250));
	   
	   System.out.println("\n----5-3.  수정하기(수정실패 - kind실패) ---------");
	   empcontroller.update("test", new FullTime(20, null, 3500, 500));
	   
		
	   System.out.println("***************************************************");
	   System.out.println("\n----6-1.  삭제하기(삭제성공) ---------");
	   empcontroller.delete("full", 20);
	   
	   System.out.println("\n----6-2.  삭제하기(삭제실패 - 사원번호 오류) ---------");
	   empcontroller.delete("full", 60);
	   
	   System.out.println("\n----6-3.  삭제하기(삭제실패 - kind 오류) ---------");
	   empcontroller.delete("test", 20);
	     
	 
	}
	
}






