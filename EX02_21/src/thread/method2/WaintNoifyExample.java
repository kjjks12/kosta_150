package thread.method2;

public class WaintNoifyExample {

	public static void main(String[] args) {

		DataBox dataBox =new DataBox();
		
		ProducerThread pth= new ProducerThread(dataBox);
		ConsumerThread cth= new ConsumerThread(dataBox);
		
		pth.start();
		cth.start();
		
		
	}

}
