class Puppy3{
	/*String Ÿ�� ���� ���� ����
		int Ÿ�� ���� ���� ����*/
		 String name;
		int age;

		
	
	/*�μ��� ���� �������ۼ�
		String Ÿ�� ���������� "�޸�" �Ҵ�
		"puplic Puppy3()ȣ��Ǿ����ϴ�"���
		�������� ���
	*/	
		
	public Puppy3(){
	System.out.println("public Puppy3()ȣ��Ǿ����ϴ�");
	System.out.println("�̸� = "+this.name+" ���� = "+this.age);
	}
	

	
	/*String Ÿ���� �μ� 1���� �޴� �������ۼ�
		String Ÿ�� ���������� �μ� �Ҵ�
		"puplic Puppy3()ȣ��Ǿ����ϴ�"���
		�������� ���
	*/		
		
	public Puppy3(String name){
		this.name= name;
		System.out.println("public Puppy3()ȣ��Ǿ����ϴ�");
		System.out.println("�̸� = "+this.name+" ���� = "+this.age);
	}
	
	/*String Ÿ���� �μ� 2���� �޴� �������ۼ�
		�μ�2���� �ϳ��� String���� �����
		String Ÿ���� �μ� 1���� �޴� �����ڿ��� �μ��� �ָ� ȣ��
		"puplic Puppy3()ȣ��Ǿ����ϴ�"���
	*/		
		
	public Puppy3(String name,String name2){
		this(name+name2);
	System.out.println("public Puppy3()ȣ��Ǿ����ϴ�");
	}
	
	
	/*boolean Ÿ���� �μ� 1���� �޴� �������ۼ�
		�μ��� "��"�� �ٿ� �ϳ��� String���� �����
		String Ÿ���� �μ� 1���� �޴� �����ڿ��� �μ��� �ָ� ȣ��
		"puplic Puppy3()ȣ��Ǿ����ϴ�"  ���
	*/					
	
	public Puppy3(boolean bool){
		
	this(bool+"��");
	System.out.println("public Puppy3()ȣ��Ǿ����ϴ�");
	}

	
	/*char Ÿ���� �μ� 1���� �޴� �������ۼ�
			�μ��� ���� �����ڸ� ȣ���ϰ�
			�μ��� ���� data�� intŸ�� ���������� �Ҵ�	
			"puplic Puppy3()ȣ��Ǿ����ϴ�"���
			int�� �����������
	*/			
	public Puppy3(char ch){
	this();
	this.age=ch;
	
	System.out.println("public Puppy3()ȣ��Ǿ����ϴ�");
	System.out.println(this.age);
	}	
	
	
	/*�޼ҵ� printMemberVariable
	���� ����
	���������� ���
	*/	
	
	public void printMemberVariable(){
	System.out.println("�̸� = "+this.name+" ���� = "+this.age);
	}
		

}


class ConstructorOverloadingExam{
		//���θ޼ҵ忡��
		public static void main(String [] args){
			//Puppy3 Ŭ������ �� �����ڸ� �ѹ��� �̿��� ��ü 5�� ����
			
			Puppy3 p1= new Puppy3();
			System.out.println("========2========");
			Puppy3 p2= new Puppy3("������");
			System.out.println("========3========");
			Puppy3 p3= new Puppy3("������","�ٺ�");
			System.out.println("========4========");
			Puppy3 p4= new Puppy3(false);
			System.out.println("========5========");
			Puppy3 p5= new Puppy3('A');
	
			System.out.println("================");
			System.out.println("================");
		//�� ��ü�� printMemberVariable�޼ҵ带 �ѹ��� ȣ��
		p1.printMemberVariable();
		p2.printMemberVariable();
		p3.printMemberVariable();
		p4.printMemberVariable();
		p5.printMemberVariable();
			
	}
}