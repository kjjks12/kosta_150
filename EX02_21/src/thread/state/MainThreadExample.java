package thread.state;

public class MainThreadExample {
	

	public static void main(String[] args) {
		Calculator calculator =new Calculator();
		
		User1 user1 = new User1(); //User1스레드 생성
		user1.setCalculate(calculator);
		user1.start();
	
		
		User2 user2 = new User2(); //User1스레드 생성
		user2.setCalculator(calculator);
		user2.start();
		
	}
}
