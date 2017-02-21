package io;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *객체를 파일에 저장하기 위해서는 반드시
 * Serializable 를 구현해야 한다.
 */

public class Student implements Serializable {
	private String name;
	private int age;
	
	
/** 생성자 */
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


/** Getter Setter*/
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
		return  name + " | " + age ;
	}


}
