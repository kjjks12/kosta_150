package homework;

import java.util.Random;

public class Services {

	public static void main(String[] args) {
		try {
			Homework1 home = new Homework1();
			Random random = new Random();

			home.setName("정광수");

			home.setKorean(random.nextInt(56) + 45);
			home.setEnglish(random.nextInt(56) + 45);
			home.setMath(random.nextInt(56) + 45);
			home.setTotalScore(random.nextInt(56) + 45);

			home.sumScore();
			home.makeAvg(3);

			home.setGrade(home.makeGrade());

			System.out.print("이름:" + home.getName() + ("  ") + "국어:" + home.getKorean() + ("  ") + "영어:"
					+ home.getEnglish() + ("  ") + "수학:" + home.getMath() + ("  ") + "총점:" + home.getTotalScore()
					+ ("  ") + "평균:" + home.getAvg() + ("  ") + "학점:" + home.getGrade()+" ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		finally {
			System.out.println("프로그램 종료 !");
		}

	}// 메인 메소드
}// 클래스

// 정광
