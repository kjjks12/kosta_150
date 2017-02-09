
class Car{
		public String carname;
		public int cost;

		public Car(){
		this.carname="네발자전거";
		this.cost=100;
		}
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}

		
}
//Car를 상속받는 EfSonata, Excel, Canival 3개 클래스 작성	
	//각 클래스에 인수를 받지않는 생성자 작성
	//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
 class EfSonata extends Car{
	 /*
	 public EfSonata(){
	carname="똥차";
	this.cost=10000;
	}
	*/
	public EfSonata(){
	super();
	}
}

 class Excel extends Car{
	public Excel(){	
	this.carname="엑셀런트";
	this.cost=20000;
	}
}

 class Canival extends Car{
	 
	int a= 100;

	 public Canival(){
	this.carname="카니발";
	super.cost=30000;
	}
}


public class InheritanceExam{
	//메인메소드에서 
	
		//Car, EfSonata, Excel, Canival 네개의 객체를 생성
		// 각 클래스에서 Car calss에있는 printAttributes()메소드를 호출할수있다.
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

