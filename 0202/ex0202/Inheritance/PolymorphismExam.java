class CarCenter{
	public void engineer(Car cd){

		System.out.println("cd="+cd);
		
		//�θ�Ÿ�� �����δ� �ڽĺκ��� ���� �Ҽ� ����.
		//System.out.println("cd.a="+cd.a);

		//�θ�Ÿ�� ������ �ڽ�Ÿ������ ��ȯ�Ͽ� ���ٰ����ϵ��� �Ѵ�.
		//ObjecetDownCasting

		//Canival cn = (Canival)cd;
		/*
		System.out.println("cn="+ cn);
		System.out.println("cn.a="+cn.a);
		*/


		//ī�Ϲ߷� car���� ��ȯ�� �ɼ� ������
		if(cd instanceof Canival){
			Canival cn = (Canival)cd;
			System.out.println("cn="+ cn);
			System.out.println("cn.a="+cn.a);
		
		}
		else{
			System.out.println("Object Downcasting �� �ȵ�!!!");
		}


		System.out.print(cd.carname+" �����Ϸ�!\t");
		System.out.println("û�����"+cd.cost+" ��");
		
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
