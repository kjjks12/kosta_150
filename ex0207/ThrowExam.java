package ex0207;

/**
 * @author Administrator
 *
 */
public class ThrowExam {

	public void aa(int age) {
		try {
			if (age <= 19) {
				// 예외 발생 시킨다
				 throw new NumberFormatException("18세 이하는 안되요!!!");
			} else {
				System.out.println("a");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			//System.out.println("오류 : " + );
		}

	}

	public static void main(String[] args) {

		new ThrowExam().aa(15);
		System.out.println("메인 끝!!!");
	}

}
