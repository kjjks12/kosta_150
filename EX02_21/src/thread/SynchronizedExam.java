package thread;

public class SynchronizedExam {

	final static boolean WITHDRAW = false;
	final static boolean DEPOSITE = true;

	public static void main(String[] args) {
		Bank bank = new Bank();
		new CustomerThread("소비자", WITHDRAW, bank).start();
		new CustomerThread("생산자", DEPOSITE, bank).start();
	}

}

/**
 * 공유 객체 = 은행
 */
class Bank {

	final boolean WITHDRAW = false;
	final boolean DEPOSITE = true;

	int balance; // 잔액

	/**
	 * 생산자와 소비자가 저금 or 인출이 가능한 메소드
	 * 
	 * @param :
	 *            name :는 생산자 , 소비자 state:는 true 이면 저금 false 이면 인출
	 */

	public synchronized void balanceChange(String name, boolean state) {

		if (DEPOSITE) {// 예금
			// synchronized (this) {// 공유객체가 들어와야한데
			if (balance == 1) {
				try {
					wait();// 현재 스레드 대기상태
					System.out.println("소비자 대기중입니다");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // 현재 쓰레드 대기상태

				System.out.print(name + "=======> 현재 잔액 :" + balance + ",");
				balance++;
				// }
			}
			System.out.println(name + "=======> 증가후  :" + balance);
		} else if (WITHDRAW) {// 인출
			// synchronized (this) {
			if (balance == 0) {
				try {
					wait();
					System.out.println("소비자 대기중입니다");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(name + "=======> 현재 잔액 :" + balance + ",");
				balance--;
				System.out.println(name + "=======> 증가후  :" + balance);
				// }
			}
		}//else if
		notifyAll();
	}

}

/** =================================================================================== */
class CustomerThread extends Thread {
	Bank bank;
	String name;
	boolean state;

	public CustomerThread(String name, boolean state, Bank bank) {
		super(name);
		this.bank = bank;
		this.name = name;
		this.state = state;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			bank.balanceChange(name, state);
		}
		System.out.println(getName() + "====> 종료됨....");

	}
}
