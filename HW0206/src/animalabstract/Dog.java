package animalabstract;

public class Dog extends Animal {

	//기본생성자 이용 초기화
	public Dog() {
		this.kind="포유류";
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}
	
	
	

}
