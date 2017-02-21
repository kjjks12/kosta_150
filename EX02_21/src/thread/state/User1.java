package thread.state;

public class User1 extends Thread{
	private Calculator calculate;

	public Calculator getCalculate() {
		return calculate;
	}

	public void setCalculate(Calculator calculate) {
		this.setName("À¯Àú 1");
		this.calculate = calculate;
	}
	
	
	@Override
	public void run() {
		calculate.setMemory(100);
	}

}
