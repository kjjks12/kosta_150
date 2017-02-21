package thread;



public class InterruptExam {

	public static void main(String[] args) {

		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("안녕하세요...");
						Thread.sleep(100);// 0.1초대기
						//if(Thread.interrupted())break;
					}
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		});
		// 익명의 쓰레드

		/*******************************************************/
		th.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 2초 대기

		th.interrupt();

		System.out.println("================메인메소드 끝 ================");
	}// main

}
