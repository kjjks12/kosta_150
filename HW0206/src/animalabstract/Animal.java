package animalabstract;

//추상 클래스 선언
public abstract class Animal {

	public String kind;
	
	public void breathe(){
		System.out.println("숨을 쉽니다 !!");
	}
	
	//추상 메소드 동물 소리 (하위 클래스에서 재정의 필요!!)
	public abstract void sound();
	
}
