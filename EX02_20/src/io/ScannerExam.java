package io;

import java.util.Scanner;

public class ScannerExam {
	

	public ScannerExam() {
		Scanner sc =new Scanner(System.in);
		System.out.print("�̸���?");
		String name= sc.nextLine();
		
		System.out.println("���� ���� ?");
		int kor= sc.nextInt();
		System.out.println("�������� ���� ?");
		int eng=sc.nextInt();
		System.out.println("�������� ���� ?");
		int math=sc.nextInt();

		System.out.printf("�̸�:%s ����:%d  ����:%d  ����:%d ���� %d:",name,kor,eng,math,kor+eng+math);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ScannerExam();
	}

}
