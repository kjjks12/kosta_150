package login;

public class LoginExample {
	public static void main(String[] args) {
		try {
			login("white", "12345");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			login("blue", "54321");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}// main method

	public static void login(String id, String password) throws NotExistIDException,WrongPaswordException  {
		// id�� "blue"�� �ƴ϶�� NotExistIDException �߻���Ŵ
		if (!id.equals("blue")) {
			throw  new NotExistIDException("���̵� �������� �ʽ��ϴ�");
			//throw  new RuntimeErrorException(null,"ddd");
		}

		// password�� "12345"�� �ƴ϶��WrongPaswordException �߻���Ŵ
		if (!password.equals("12345")) {
			throw  new WrongPaswordException("�н����尡 Ʋ���ϴ�");
			//throw  new NumberFormatException("daa");
		}
	}//login method

}//class
