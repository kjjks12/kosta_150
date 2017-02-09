class Parent{
	/*
	Parent(){
	System.out.println(1);
	}
	*/

	Parent(int i){
	System.out.println(2);
	}
	Parent(String i){
	System.out.println(3);
	}
	
}

class Child extends Parent
{
	Child(){
	super(3);
	System.out.println(4);
	}
	Child(int i){
	this(true);
	System.out.println(5);
	}
	Child(boolean b){
	super("안녕");
	System.out.println(6);
	}
}


class InheritanceConstructor
{
	public static void main(String[] args) 
	{
		Child c= new Child();
		//Child c2= new Child(4);
		//Child c3= new Child(false);

		/*
		결론 : 자식 생성될때 부모의 기본생성자 호출된다.
		자식 생성자 구현부 첫줄에 super()가 생략 되어 있다
		자식이 인수있는 생성자를 호출하더라도 부모의 기본생성자가 필요하다
		*/

		//만약 1,23, 이 없으면??
		/*
		생성자 하나도 작성 하지 않으면 기본 생성자 삽입되므로 오류 없어
		*/

		//만약 2,3 만 있으면??
		/*
		자식생성자 구현부에서 부모의디폴트 생성자 부르므로 오류!!

		*/

	}
}
