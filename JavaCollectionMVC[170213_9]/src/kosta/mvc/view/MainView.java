package kosta.mvc.view;

import kosta.mvc.controller.EmpController;
import kosta.mvc.model.dto.FullTime;
import kosta.mvc.model.dto.PartTime;

public class MainView {
	public static void main(String [] args) {
	
		EmpController empcontroller = EmpController.getInstance(); 
		
	   System.out.println("\n----1. ��ü �˻��ϱ� ---------");
	   empcontroller.selectAll();
	   
	   System.out.println("*******************************");
	
	   System.out.println("\n----2-1.  Fulltime(������ ����˻�) ---------");
	   empcontroller.searchByKind("full");
	   
	   System.out.println("\n----2-2.  Fulltime(�������� ����˻�) ---------");
	   empcontroller.searchByKind("part");
	   
	   System.out.println("\n----2-3.  Fulltime( �߸��� kind) ---------");
	   empcontroller.searchByKind("test");
	
	   System.out.println("***************************************************");
	   System.out.println("\n----3-1. kind�� �����ȣ�� �ش��ϴ� ����˻�(�ִ°��) ---------");
	   empcontroller.searchByNo("part", 10);
	   
	   System.out.println("\n----3-2.  kind�� �����ȣ�� �ش��ϴ� ����˻�(�����ȣ �߸�) ---------");
	   empcontroller.searchByNo("full", 40);
	   
	   System.out.println("\n----3-3.  kind�� �����ȣ�� �ش��ϴ� ����˻�(kind�߸�) ---------");
	   empcontroller.searchByNo("test", 10);
	
	   System.out.println("***************************************************");
	   System.out.println("\n----4-1.  kind�� �ش��ϴ� ��� ��� ---------");
	   empcontroller.insert("part", new PartTime(60, "�����", 2000));
	   
	   System.out.println("\n----4-2.  kind�� �ش��ϴ� ��� ���(�����ȣ �ߺ�) ---------");
	   empcontroller.insert("part", new PartTime(10, "�����", 2000));
	   
	   System.out.println("\n----4-2.  kind�� �ش��ϴ� ��� ���(kind �߸��Ȱ��) ---------");
	   empcontroller.insert("test", new PartTime(70, "�����", 2000));

	   System.out.println("***************************************************");
	   System.out.println("\n----5-1.  �����ϱ�(��������) ---------");
	   empcontroller.update("full", new FullTime(20, null, 2500, 100));
	   
	   System.out.println("\n----5-2.  �����ϱ�(�������� - �����ȣ����) ---------");
	   empcontroller.update("full", new FullTime(80, null, 3500, 250));
	   
	   System.out.println("\n----5-3.  �����ϱ�(�������� - kind����) ---------");
	   empcontroller.update("test", new FullTime(20, null, 3500, 500));
	   
		
	   System.out.println("***************************************************");
	   System.out.println("\n----6-1.  �����ϱ�(��������) ---------");
	   empcontroller.delete("full", 20);
	   
	   System.out.println("\n----6-2.  �����ϱ�(�������� - �����ȣ ����) ---------");
	   empcontroller.delete("full", 60);
	   
	   System.out.println("\n----6-3.  �����ϱ�(�������� - kind ����) ---------");
	   empcontroller.delete("test", 20);
	     
	 
	}
	
}






