class Super{
	int a=10;
	int b=5;
	public void aa(){
	System.out.println("1��");
	}
	public void bb(){
		System.out.println("2��");
	}
}

class Sub extends Super
{
 int a=20;
 int c=50;
	public void aa(){
		System.out.println("3��");
		/*
	System.out.println(a);//20
	System.out.println(this.a);//20
	System.out.println(super.a);//10
	System.out.println("===================");
	
	System.out.println(b);//5
	System.out.println(this.b);//5
	System.out.println(super.b);//5
	System.out.println("===================");
	
	System.out.println(c);//50
	System.out.println(this.c);//50
	//System.out.println(super.c);//������ ����
	System.out.println("===================");
	*/

	}
	public void cc(){
		System.out.println("4��");
	aa();
	this.aa();
	super.aa();

	System.out.println("===================");
	bb();
	this.bb();
	super.bb();

	System.out.println("===================");
	
	dd();
	this.dd();
	//super.dd();

	System.out.println("===================");
	}


	public void dd(){
	System.out.println("5��");
	
	}

}


class SuperKeywordExam 
{
	public static void main(String[] args) 
	{
		//new Sub().aa();
		//new Sub().cc();
		
		Sub s1= new Sub();
		System.out.println(s1.a);
		System.out.println (s1.b);
		System.out.println(s1.c);
		s1.aa();
		s1.bb();
		s1.dd();

		System.out.println("====================");
		Super s2=new Sub();//�θ� �κи� ���� ����
		System.out.println(s2.a);//10
		System.out.println (s2.b);
		//System.out.println(s2.c); //�ڽ� �κ��̹Ƿ� ���� �ȵ�

		System.out.println("====================");
		s2.aa();//!!!!!!!!�߿�  => �����ǵ� �޽��� �θ�Ÿ�� ������ �ݵ�� �ڽĺκ� ȣ��
		s2.bb();
		//s2.dd();//�ڽ� �κ��̹Ƿ� dd���� �Ұ���


		//�θ�Ÿ�� ���� S2�� �ڽĺκ� ���پȵǹǷ� ObjectDownCasting �ʿ���
		Sub s3= (Sub)s2;
		System.out.println(s3.c); //���� ���ٵ�!!
		s3.dd();

		System.out.println("s2�ּҰ� : "+s2);
		System.out.println("s3�ּҰ� : "+s3);


	}
}
