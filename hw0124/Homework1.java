package homework;
//������ 
/**
1. ����ǥ����� ���� Ŭ������ �����ϰ� ���θ޼ҵ� �ۼ��Ѵ�.
2. ���θ޼ҵ�ȿ��� �ϴ� ��
    - ���� �̸��� ������ ������ �����Ѵ�.
    - ����,����,���� ����(�� ������ ������ �����Ѵ�.
    - ����, ���, ������ ������ ������ �����Ѵ�.
��� = DOUBLE
���� = CHAR��
    - ����� ����, ����, ���� ������ 45 ~ 100������ ������ �߻��Ͽ� ���� �����Ѵ�.
    - ����, ����, ���������� ������ ���Ͽ� ���� ������ �����Ѵ�.
    - ������ ������ ����� ���Ͽ� ��� ������ �����Ѵ�.

    - ����� 90�̻��̸� �� , 80~ 89���̸� ��,  70 ~ 79���̸� ��
      60 ~ 69���̸� �� , ���̿��� ���� �� �� ���� ������ �����Ѵ�.
	 => ������ ���ϴ� ����� if���� switch�� �ΰ��� ������ �غ���.

    - �̸� , ��������, ��������, ��������, ����,���, ������ ���ڰ� ����غ���.

 */

public class Homework1 {

	private String name;
	private int korean, english, math, totalScore;
	private double avg;
	private char grade;
	//���� 	
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	public void sumScore(){
		
		this.totalScore=this.korean+this.english+this.math;
	}
	
	public void makeAvg(int count ){
		this.avg=(this.totalScore/count);
	}
	
	public char makeGrade(){
	
		int nAvg=(int)this.avg;
		
		if(nAvg>=90){
			return '��';
		}
		else if(nAvg>=80){
			return '��';
		}
		else if(nAvg>=70){
			return '��';
		}
		else if(nAvg>=60){
			return '��';
		}
		else {
			return '��';
		}

		/*
		switch((int)(nAvg/10))
		{
		case 9:
			return '��';
		case 8:
			return '��';
		case 7 :
			return '��';
		case 6:
			return '��';
		default:
			return '��';
		
		}
		
	*/	
		

		
		
	}//makeGrade �޼ҵ�
	
}//Ŭ���� 
