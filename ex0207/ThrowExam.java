package ex0207;

/**
 * @author Administrator
 *
 */
public class ThrowExam {

	public void aa(int age) {
		try {
			if (age <= 19) {
				// ���� �߻� ��Ų��
				 throw new NumberFormatException("18�� ���ϴ� �ȵǿ�!!!");
			} else {
				System.out.println("a");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			//System.out.println("���� : " + );
		}

	}

	public static void main(String[] args) {

		new ThrowExam().aa(15);
		System.out.println("���� ��!!!");
	}

}
