package io;

import java.util.Scanner;

public class ScannerExam {
	

	public ScannerExam() {
		Scanner sc =new Scanner(System.in);
		System.out.print("이름은?");
		String name= sc.nextLine();
		
		System.out.println("국어 점수 ?");
		int kor= sc.nextInt();
		System.out.println("영어점수 점수 ?");
		int eng=sc.nextInt();
		System.out.println("수학점수 점수 ?");
		int math=sc.nextInt();

		System.out.printf("이름:%s 국어:%d  영어:%d  수학:%d 총점 %d:",name,kor,eng,math,kor+eng+math);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ScannerExam();
	}

}
