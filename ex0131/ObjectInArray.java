//ObjectInArray.java

class ObjectOne{
	public int a;

		@Override
		public String toString(){
		
		return "�� ="+a;
		
		}
}

public class ObjectInArray{
	//���� �޼ҵ忡�� 
	
		//ObjectOne Ÿ���� 5�� ���� �����ϴ� �迭�� �����ϰ�
		 
		//5���� ObjectOne��ü�� �����ϼ���.
		//�� ��ü�� �����ִ� �������� ���
		//�� ��ü�� �ּҰ� ���
			
		//������ ObjectOne��ü�� ���� �ٸ� a�� ���� ������ a�� ���� �����ϼ���.			
		//�� ObjectOne ��ü�� a�� ����ϼ���

		public static void printAll(ObjectOne oo[]){
			for(int i=0;i<oo.length;i++){
			System.out.println("ObjectOne["+i+"] \t�� ="+oo[i].a+"\t�ּ� ="+oo[i]);
			}
		}


		public static void main(String[] args){
		
		ObjectOne [] oo= new ObjectOne[5];
		for(int i=0;i<oo.length;i++){
		oo[i]=new ObjectOne();
		}

		printAll(oo);

		for(int i=0;i<oo.length;i++){
		oo[i].a=(int)(Math.random()*100)+1;
		}
		System.out.println("--------------------------------------------------");
		printAll(oo);


		System.out.println(o)o;

		}//main method



}
