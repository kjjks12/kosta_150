package thread.priority;

public class CalcThread extends Thread {

	public CalcThread(String name) {
		setName(name); // 스레드의 이름 변경
	}

	@Override
	public void run() {
		for (int i = 0; i < 2000000000; i++) {
		}
		System.out.println(getName());
	}
}
