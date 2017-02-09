package homework;
//정광수 
/**
1. 성적표기능을 만들 클래스를 선언하고 메인메소드 작성한다.
2. 메인메소드안에서 하는 일
    - 본인 이름을 저장할 변수를 선언한다.
    - 국어,영어,수학 점수(를 저장할 변수를 선언한다.
    - 총점, 평균, 학점을 저장할 변수를 선언한다.
평균 = DOUBLE
학점 = CHAR형
    - 선언된 국어, 영어, 수학 변수에 45 ~ 100사이의 난수를 발생하여 각각 저장한다.
    - 국어, 영어, 수학점수을 총점을 구하여 총점 변수에 저장한다.
    - 총점을 가지고 평균을 구하여 평균 변수에 저장한다.

    - 평균이 90이상이면 수 , 80~ 89사이면 우,  70 ~ 79사이면 미
      60 ~ 69사이면 양 , 그이외의 값은 가 의 값을 학점에 저장한다.
	 => 학점을 구하는 방법은 if문과 switch문 두가지 방법모두 해본다.

    - 이름 , 국어점수, 영어점수, 수학점수, 총점,평균, 학점을 예쁘게 출력해본다.

 */

public class Homework1 {

	private String name;
	private int korean, english, math, totalScore;
	private double avg;
	private char grade;
	//변수 	
	


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
			return '수';
		}
		else if(nAvg>=80){
			return '우';
		}
		else if(nAvg>=70){
			return '미';
		}
		else if(nAvg>=60){
			return '양';
		}
		else {
			return '가';
		}

		/*
		switch((int)(nAvg/10))
		{
		case 9:
			return '수';
		case 8:
			return '우';
		case 7 :
			return '미';
		case 6:
			return '양';
		default:
			return '가';
		
		}
		
	*/	
		

		
		
	}//makeGrade 메소드
	
}//클래스 
