class Super{
	int a=10;
	int b=5;
	public void aa(){
	System.out.println("1번");
	}
	public void bb(){
		System.out.println("2번");
	}
}

class Sub extends Super
{
 int a=20;
 int c=50;
	public void aa(){
		System.out.println("3번");
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
	//System.out.println(super.c);//컴파일 에러
	System.out.println("===================");
	*/

	}
	public void cc(){
		System.out.println("4번");
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
	System.out.println("5번");
	
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
		Super s2=new Sub();//부모 부분만 접근 가능
		System.out.println(s2.a);//10
		System.out.println (s2.b);
		//System.out.println(s2.c); //자식 부분이므로 접근 안됨

		System.out.println("====================");
		s2.aa();//!!!!!!!!중요  => 재정의된 메써드는 부모타입 변수라도 반드시 자식부분 호출
		s2.bb();
		//s2.dd();//자식 부분이므로 dd접근 불가능


		//부모타입 변수 S2로 자식부분 접근안되므로 ObjectDownCasting 필요함
		Sub s3= (Sub)s2;
		System.out.println(s3.c); //이제 접근되!!
		s3.dd();

		System.out.println("s2주소값 : "+s2);
		System.out.println("s3주소값 : "+s3);


	}
}
