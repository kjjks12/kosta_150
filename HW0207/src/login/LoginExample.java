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
		// id가 "blue"가 아니라면 NotExistIDException 발생시킴
		if (!id.equals("blue")) {
			throw  new NotExistIDException("아이디가 존재하지 않습니다");
			//throw  new RuntimeErrorException(null,"ddd");
		}

		// password가 "12345"가 아니라면WrongPaswordException 발생시킴
		if (!password.equals("12345")) {
			throw  new WrongPaswordException("패스워드가 틀립니다");
			//throw  new NumberFormatException("daa");
		}
	}//login method

}//class
