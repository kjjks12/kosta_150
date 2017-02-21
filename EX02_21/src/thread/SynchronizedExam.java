package thread;

public class SynchronizedExam {

	final static boolean WITHDRAW = false;
	final static boolean DEPOSITE = true;

	public static void main(String[] args) {
		Bank bank = new Bank();
		new CustomerThread("�Һ���", WITHDRAW, bank).start();
		new CustomerThread("������", DEPOSITE, bank).start();
	}

}

/**
 * ���� ��ü = ����
 */
class Bank {

	final boolean WITHDRAW = false;
	final boolean DEPOSITE = true;

	int balance; // �ܾ�

	/**
	 * �����ڿ� �Һ��ڰ� ���� or ������ ������ �޼ҵ�
	 * 
	 * @param :
	 *            name :�� ������ , �Һ��� state:�� true �̸� ���� false �̸� ����
	 */

	public synchronized void balanceChange(String name, boolean state) {

		if (DEPOSITE) {// ����
			// synchronized (this) {// ������ü�� ���;��ѵ�
			if (balance == 1) {
				try {
					wait();// ���� ������ ������
					System.out.println("�Һ��� ������Դϴ�");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // ���� ������ ������

				System.out.print(name + "=======> ���� �ܾ� :" + balance + ",");
				balance++;
				// }
			}
			System.out.println(name + "=======> ������  :" + balance);
		} else if (WITHDRAW) {// ����
			// synchronized (this) {
			if (balance == 0) {
				try {
					wait();
					System.out.println("�Һ��� ������Դϴ�");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(name + "=======> ���� �ܾ� :" + balance + ",");
				balance--;
				System.out.println(name + "=======> ������  :" + balance);
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
		System.out.println(getName() + "====> �����....");

	}
}
