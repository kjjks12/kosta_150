package test.exam;

public class Audio extends Elec implements ElecFunction{

	private int volumn ;

	
	//������
	public Audio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Audio(int volumn) {
		this.volumn=volumn;
	}

	public Audio(String code, int cost, int volumn) {
		super(code, cost);
		this.volumn=volumn;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println(this.toString());
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public String toString() {
		return super.toString()+"�� Audio��"+volumn+"���� ��´�";
	}
	
	
	
	

	
	
	
}
