package ex0207;

public class ThrowsExam {

	public void aa(int a) throws ArithmeticException{
		System.out.println("aa()�޼ҵ尡 ȣ���");
		//try {
			this.bb(a);
		//} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("ȣ�⶧���� ���������!!");
		//}
		System.out.println("aa()�޼ҵ�Ϸ�...");
	}

	public void bb(int i) throws ArithmeticException {
		System.out.println("bb()�޼ҵ尡 ȣ���");

		try {
			// try{

			int result = 100 / i;
			System.out.println("������� :" + result);
			// }catch (ArithmeticException e) {
			// e.printStackTrace();
			// }
		} finally {
			System.out.println("bb()�޼ҵ�Ϸ�");
		}

	}

	public static void main(String[] args) {

		ThrowsExam te = new ThrowsExam();
		// te.aa(5);
		try {
		te.aa(0);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println("���θ޼ҵ� ��");

	}

}
