package homework;

import java.util.Random;

public class Services {

	public static void main(String[] args) {
		try {
			Homework1 home = new Homework1();
			Random random = new Random();

			home.setName("������");

			home.setKorean(random.nextInt(56) + 45);
			home.setEnglish(random.nextInt(56) + 45);
			home.setMath(random.nextInt(56) + 45);
			home.setTotalScore(random.nextInt(56) + 45);

			home.sumScore();
			home.makeAvg(3);

			home.setGrade(home.makeGrade());

			System.out.print("�̸�:" + home.getName() + ("  ") + "����:" + home.getKorean() + ("  ") + "����:"
					+ home.getEnglish() + ("  ") + "����:" + home.getMath() + ("  ") + "����:" + home.getTotalScore()
					+ ("  ") + "���:" + home.getAvg() + ("  ") + "����:" + home.getGrade()+" ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		finally {
			System.out.println("���α׷� ���� !");
		}

	}// ���� �޼ҵ�
}// Ŭ����

// ����
