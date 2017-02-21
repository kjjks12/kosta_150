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
		System.out.println("�������尡 ���� ������ : " + returnValue);

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
		System.out.println("������ �����尡 ������ ������"+data);
		notify();

	}

}
