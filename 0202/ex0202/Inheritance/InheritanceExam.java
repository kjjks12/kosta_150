
class Car{
		public String carname;
		public int cost;

		public Car(){
		this.carname="�׹�������";
		this.cost=100;
		}
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}

		
}
//Car�� ��ӹ޴� EfSonata, Excel, Canival 3�� Ŭ���� �ۼ�	
	//�� Ŭ������ �μ��� �����ʴ� ������ �ۼ�
	//�� Ŭ������ �������� �����ο��� carname�� cost�� ������ �� �Ҵ�
 class EfSonata extends Car{
	 /*
	 public EfSonata(){
	carname="����";
	this.cost=10000;
	}
	*/
	public EfSonata(){
	super();
	}
}

 class Excel extends Car{
	public Excel(){	
	this.carname="������Ʈ";
	this.cost=20000;
	}
}

 class Canival extends Car{
	 
	int a= 100;

	 public Canival(){
	this.carname="ī�Ϲ�";
	super.cost=30000;
	}
}


public class InheritanceExam{
	//���θ޼ҵ忡�� 
	
		//Car, EfSonata, Excel, Canival �װ��� ��ü�� ����
		// �� Ŭ�������� Car calss���ִ� printAttributes()�޼ҵ带 ȣ���Ҽ��ִ�.
	public static void main(String args[]){

	Car c= new Car();
	EfSonata ef= new EfSonata();
	Excel ex= new Excel();
	Canival ci= new Canival();

	c.printAttributes();
	ef.printAttributes();
	ex.printAttributes();
	ci.printAttributes();

	}	
	


}

