package model;


/*
 * txt���Ͽ��� �޾ƿͼ�  Student ��ü�� ������
 * arrayList�� ����
 */
public class Student{
	//�Ӽ�
	private String name;
	private int age;
	
	//������
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
