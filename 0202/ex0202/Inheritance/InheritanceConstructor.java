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
	super("�ȳ�");
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
		��� : �ڽ� �����ɶ� �θ��� �⺻������ ȣ��ȴ�.
		�ڽ� ������ ������ ù�ٿ� super()�� ���� �Ǿ� �ִ�
		�ڽ��� �μ��ִ� �����ڸ� ȣ���ϴ��� �θ��� �⺻�����ڰ� �ʿ��ϴ�
		*/

		//���� 1,23, �� ������??
		/*
		������ �ϳ��� �ۼ� ���� ������ �⺻ ������ ���ԵǹǷ� ���� ����
		*/

		//���� 2,3 �� ������??
		/*
		�ڽĻ����� �����ο��� �θ��ǵ���Ʈ ������ �θ��Ƿ� ����!!

		*/

	}
}
