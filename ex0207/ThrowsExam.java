package ex0207;

public class ThrowsExam {

	public void aa(int a) throws ArithmeticException{
		System.out.println("aa()메소드가 호출됨");
		//try {
			this.bb(a);
		//} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("호출때문에 문제생겼어!!");
		//}
		System.out.println("aa()메소드완료...");
	}

	public void bb(int i) throws ArithmeticException {
		System.out.println("bb()메소드가 호출됨");

		try {
			// try{

			int result = 100 / i;
			System.out.println("나눈결과 :" + result);
			// }catch (ArithmeticException e) {
			// e.printStackTrace();
			// }
		} finally {
			System.out.println("bb()메소드완료");
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
		System.out.println("메인메소드 끝");

	}

}
