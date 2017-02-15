package animalabstract;

public class AnimalExample {

	
		public static void main(String args[]){
			Dog dog = new Dog();
			Cat cat = new Cat();
			
			
			dog.sound();
			cat.sound();
			
			System.out.println("------");
			
			//���� �ڵ� Ÿ�� ��ȯ �ϱ� ����
			Animal animal =null;
			
			//�θ�Ŭ������ dog���� (��ü ������ ������)
			animal = new Dog();
			animal.sound(); //�ڽ� Ŭ������ �����ǵ� �޼ҵ� ȣ��
			
			animal = new Cat();
			animal.sound();
			
			System.out.println("---�޼ҵ��� ������---");
			
			//�޼ҵ��� ������(�Ű�����)
			animalSound(new Dog());
			animalSound(new Cat());
		}//main method
	
		
		public static void animalSound(Animal animal){
			animal.sound();
		}
}
