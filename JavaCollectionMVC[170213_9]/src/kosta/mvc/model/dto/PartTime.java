package kosta.mvc.model.dto;

public class PartTime extends Employee {
private int timePay;

public PartTime() {
	super();
	// TODO Auto-generated constructor stub
}

public PartTime(int empNo, String empName, int timePay) {
	super(empNo, empName);
	this.timePay = timePay;
}

public int getTimePay() {
	return timePay;
}

public void setTimePay(int timePay) {
	this.timePay = timePay;
}

@Override
public String toString() {
	return super.toString()+" ½Ã±Þ   = " + timePay;
}





}
