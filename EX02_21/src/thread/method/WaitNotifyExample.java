package thread.method;

public class WaitNotifyExample {
	
	public static void main(String[] args) {
		WorkObject sharedObject= new WorkObject();
		
		Thread threadA = new ThreadA(sharedObject);
		Thread threadB = new ThreadB(sharedObject);
		
		threadA.start();
		threadB.start();
	}

}
