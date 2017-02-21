package thread;

public class ThreadExam {

	public static void main(String[] args) {

		NumberThread th = new NumberThread("쓰레드");
		th.start();

		AlphaThread ath = new AlphaThread();
		Thread th3 = new Thread(ath, "세번째 스레드");
		th3.start();
		
		/** 그냥 메소드 호출 하는거야 쓰레드 실행 아니야!!*/
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
		System.out.println("======메인 종료=======");
		System.out.println("총합 :"+th.sum);

	}
}

/**
 * 1~100까지 출력하는 스레드
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
 * 2. A ~ Z 까지 출력하는 스레드
 */

class AlphaThread implements Runnable {

	@Override
	public void run() {
		Thread th = Thread.currentThread();// 현재스레드 가져오기

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
