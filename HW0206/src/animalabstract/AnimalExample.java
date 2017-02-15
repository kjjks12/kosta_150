package animalabstract;

public class AnimalExample {

	
		public static void main(String args[]){
			Dog dog = new Dog();
			Cat cat = new Cat();
			
			
			dog.sound();
			cat.sound();
			
			System.out.println("------");
			
			//변수 자동 타입 변환 하기 위해
			Animal animal =null;
			
			//부모클래스에 dog대입 (객체 생성시 다형성)
			animal = new Dog();
			animal.sound(); //자식 클랫에서 재정의된 메소드 호출
			
			animal = new Cat();
			animal.sound();
			
			System.out.println("---메소드의 다형성---");
			
			//메소드의 다형성(매개변수)
			animalSound(new Dog());
			animalSound(new Cat());
		}//main method
	
		
		public static void animalSound(Animal animal){
			animal.sound();
		}
}
