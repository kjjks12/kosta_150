//에러나는부분을 주석처리하고 이유를 써보세요!
class Car{} 
class EfSonata extends Car{}
class Excel extends Car{}
class Canival extends Car{}
class People{}

public class InstanceofExam{
	public static void main(String args []){
		
		Car car = new Car();
		EfSonata ef = new EfSonata();
		Excel ex = new Excel();
		Canival ca = new Canival();
		People p = new People();		
		
		if(car instanceof Car){
			System.out.println("car instanceof Car is true");
		}else{
			System.out.println("car instanceof Car is false");
		}
		
		if(car instanceof EfSonata){//car가 eFSonata 타입이 될수 있어??/
			System.out.println("car instanceof EfSonata is true");
		}else{
			System.out.println("car instanceof EfSonata is false");
		}
		
		if(ef instanceof Car){ //ef소나타가 car타입이 될 수 있어??
			System.out.println("ef instanceof Car is true");
		}else{
			System.out.println("ef instanceof Car is false");
		}
		
		if(ex instanceof Car){//엑셀런트가 car타입이 될 수 있어??
			System.out.println("ex instanceof Car is true");
		}else{
			System.out.println("ex instanceof Car is false");
		}
		
		if(ca instanceof Car){
			System.out.println("ca instanceof Car is true");
		}else{
			System.out.println("ca instanceof Car is false");
		}
		/*
		상속 관계가 선행조건 이어야해

		if(p instanceof Car){
			System.out.println("p instanceof Car is true");
		} 
		
		*/
	}
}	
