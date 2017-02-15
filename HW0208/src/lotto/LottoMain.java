package lotto;

import java.util.Random;

public class LottoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int randomArr[] = new int[6];
		 * 
		 * for (int i = 0; i < randomArr.length; i++) { randomArr[i] =
		 * (int)(Math.random()*43) + 1; //System.out.print(randomArr[i]); }
		 */
		Lotto lt = new Lotto();
		System.out.println("========정렬전========");
		lt.print();
		lt.ascendingSort();
		System.out.println("========정렬후========");
		lt.print();

		Random r1 = new Random(6);
		Random r2 = new Random(6);

		int no1 = r1.nextInt(10);// 0~9
		int no2 = r2.nextInt(10);// 0~9
		System.out.println("no1= " + no1);
		System.out.println("no2= " + no2);

	}

}
