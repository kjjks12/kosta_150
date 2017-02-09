/**
학생의 정보를 저장하는 저장소
DTO(DATA Transfer Object)= VO(Values Object)

*/

public class Student 
{
	private String name; //은닉= 외부로부터 데이터 보호(사용자 마음대로 접근 안도미)
	private int age;


	public void setName(String name){
	this.name=name;
	}
	public String getName(){
	return name;
	}

	public void setAge(int age){
	this.age=age;
	}

	public int getAge(){
	return age;
	}
	
	//속성을 외부에서 접글할 수 있도록 setXxx(), getXxxx()선언이 필요 !!


}
