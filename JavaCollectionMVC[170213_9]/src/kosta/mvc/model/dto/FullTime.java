package kosta.mvc.model.dto;

public class FullTime extends Employee {

private int salary;
private int bounus;

public FullTime() {
	super();
	// TODO Auto-generated constructor stub
}
public FullTime(int empNo, String empName, int salary, int bounus) {
	super(empNo, empName);
	this.salary = salary;
	this.bounus = bounus;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public int getBounus() {
	return bounus;
}
public void setBounus(int bounus) {
	this.bounus = bounus;
}
@Override
public String toString() {
	return super.toString()+" 월급  = " + salary + " 보너스  = " + bounus ;
}





	
	
}
