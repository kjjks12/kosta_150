package thread.method;

public class WorkObject {

	
	public synchronized void methodA(){
		System.out.println("������A �� �޽��A �۾� ����");
		notify();
		
		
		try{
			wait();
		}catch (InterruptedException e) {
		}
	}

	
	public synchronized void methodB(){
		System.out.println("������B �� �޽��B �۾� ����");
		notify();
		
		try{
			wait();
		}catch (InterruptedException e) {
		}
	}
	
}
