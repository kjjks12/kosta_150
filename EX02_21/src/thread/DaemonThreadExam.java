package thread;

public class DaemonThreadExam {

	public static void main(String[] args) {
		
		Thread th= new Thread(){
			@Override
			public void run() {
				while(true){
					System.out.println("������ ��Ʈ��ũ �����ϴ³�");
					try{
						Thread.sleep(100);
						
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}//run
		};

		th.setDaemon(true);
		th.start();
		
		try{
			Thread.sleep(2000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("======== ���� �� ==========");
		
	}//main
	
}
