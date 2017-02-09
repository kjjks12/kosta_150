class CarCenter{
	public void engineer(Car cd){

		System.out.println("cd="+cd);
		
		//부모타입 변수로는 자식부분을 접근 할수 없다.
		//System.out.println("cd.a="+cd.a);

		//부모타입 변수를 자식타입으로 변환하여 접근가능하도록 한다.
		//ObjecetDownCasting

		//Canival cn = (Canival)cd;
		/*
		System.out.println("cn="+ cn);
		System.out.println("cn.a="+cn.a);
		*/


		//카니발로 car형이 변환이 될수 있으면
		if(cd instanceof Canival){
			Canival cn = (Canival)cd;
			System.out.println("cn="+ cn);
			System.out.println("cn.a="+cn.a);
		
		}
		else{
			System.out.println("Object Downcasting 이 안되!!!");
		}


		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
	}
}

public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		EfSonata ef=new EfSonata();
		Canival ca=new Canival();
		Excel ex=new Excel();

		Car car= new Car();
		
		cc.engineer(car);//
		cc.engineer(ef);//
		cc.engineer(ca);//
		cc.engineer(ex);//
		
		/*
		System.out.println("ca="+ca);
		System.out.println("ca.a="+ca.a);
		cc.engineer(ca);
		*/
	
	}
}
