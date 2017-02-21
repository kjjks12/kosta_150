package thread;

public class ThreadExam {

	public static void main(String[] args) {

		NumberThread th = new NumberThread("������");
		th.start();

		AlphaThread ath = new AlphaThread();
		Thread th3 = new Thread(ath, "����° ������");
		th3.start();
		
		/** �׳� �޼ҵ� ȣ�� �ϴ°ž� ������ ���� �ƴϾ�!!*/
		/*
		th.run();
		th3.run();
		*/
		try{
		th.join();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("======���� ����=======");
		System.out.println("���� :"+th.sum);

	}
}

/**
 * 1~100���� ����ϴ� ������
 */
class NumberThread extends Thread {
	int sum;
	
	public NumberThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i <= 100; i++) {
				System.out.println(i + super.getName() + "=>" + i);
				sleep(500);
				sum+=i;
			}
			System.out.println(super.getName() + "End...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

/**
 * 2. A ~ Z ���� ����ϴ� ������
 */

class AlphaThread implements Runnable {

	@Override
	public void run() {
		Thread th = Thread.currentThread();// ���罺���� ��������

		try {
			for (char ch = 'A'; ch <= 'z'; ch++) {
				System.out.println(th.getName() + "=>" + ch);
				Thread.sleep(500);
			}
			System.out.println(th.getName() + "=>End ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// run

}
