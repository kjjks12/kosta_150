package model;


/*
 * txt파일에서 받아와서  Student 객체에 저장후
 * arrayList에 저장
 */
public class Student{
	//속성
	private String name;
	private int age;
	
	//생성자
	public Student() {}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//getter,setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return name + " | " + age ;
	}
	
	
	
	
}
