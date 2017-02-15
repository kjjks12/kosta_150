package test.exam;

public class Elec {
	
	private String code;
	private int cost;
	

	//»ý¼ºÀÚ
	public Elec(){
		
	}
	
	public Elec(String code, int cost) {
		this.code = code;
		this.cost = cost;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return code;
	}
	
	
	
	
	
	

}
