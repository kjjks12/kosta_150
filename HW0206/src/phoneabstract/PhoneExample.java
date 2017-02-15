package phoneabstract;

public class PhoneExample {

	public static void main(String args[]){
		
		//SmartPhone phone = new Phone();
		//Phone이 추상클래스라서 생성하지 못해요!! 상속받아서사용 해야해요!!
		
		SmartPhone smartPhone= new SmartPhone("홍길동");
		
		smartPhone.turnOn(); //phone 메소드 전원켜기!!
		smartPhone.turnOff();
		
		
		
	}
	
}
