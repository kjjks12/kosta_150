/**
�л��� ������ �����ϴ� �����
DTO(DATA Transfer Object)= VO(Values Object)

*/

public class Student 
{
	private String name; //����= �ܺηκ��� ������ ��ȣ(����� ������� ���� �ȵ���)
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
	
	//�Ӽ��� �ܺο��� ������ �� �ֵ��� setXxx(), getXxxx()������ �ʿ� !!


}
