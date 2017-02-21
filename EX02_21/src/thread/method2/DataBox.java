package thread.method2;

public class DataBox {
	private String data;

	public synchronized String getData() {
		if (this.data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
			}

		}
		String returnValue = data;
		System.out.println("고객쓰레드가 읽은 데이터 : " + returnValue);

		data = null;
		notify();

		return returnValue;
	}

	public synchronized void setData(String data) {
		if (this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		this.data=data;
		System.out.println("생산자 쓰레드가 생성한 데이터"+data);
		notify();

	}

}
