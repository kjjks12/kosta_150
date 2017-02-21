package thread.method;

public class WorkObject {

	
	public synchronized void methodA(){
		System.out.println("쓰레드A 의 메써드A 작업 실행");
		notify();
		
		
		try{
			wait();
		}catch (InterruptedException e) {
		}
	}

	
	public synchronized void methodB(){
		System.out.println("쓰레드B 의 메써드B 작업 실행");
		notify();
		
		try{
			wait();
		}catch (InterruptedException e) {
		}
	}
	
}
