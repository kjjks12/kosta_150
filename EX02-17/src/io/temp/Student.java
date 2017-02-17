package io.temp;

public class Student extends Person {

	private int korean;
	private int english;
	private int math;
	private int studentNumber;
	private String grade;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(String id, String pwd, String name, String address, String phoneNumber,
					int korean, int english, int math, int studentNumber, String grade) {
		super(id, pwd, name, address, phoneNumber);
		this.korean=korean;
		this.english=english;
		this.math=math;
		this.studentNumber=studentNumber;
		
		// TODO Auto-generated constructor stub
	}


	public int getKorean() {
		return korean;
	}


	public void setKorean(int korean) {
		this.korean = korean;
	}


	public int getEnglish() {
		return english;
	}


	public void setEnglish(int english) {
		this.english = english;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getStudentNumber() {
		return studentNumber;
	}


	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	
	
	
}
