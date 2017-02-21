package thread.priority;

public class PriorityExample {

	public static void main(String[] args) {

		for(int i=0;i<=10;i++){
			Thread thread = new CalcThread("thread"+i);//쓰레드 이름
			
			if(i!=10){
				thread.setPriority(Thread.MIN_PRIORITY);
			}else{
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			thread.start();
		}//for
	
		
	}//main

}
