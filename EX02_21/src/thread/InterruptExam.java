package thread;



public class InterruptExam {

	public static void main(String[] args) {

		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("�ȳ��ϼ���...");
						Thread.sleep(100);// 0.1�ʴ��
						//if(Thread.interrupted())break;
					}
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		});
		// �͸��� ������

		/*******************************************************/
		th.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 2�� ���

		th.interrupt();

		System.out.println("================���θ޼ҵ� �� ================");
	}// main

}
