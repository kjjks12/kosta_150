/**
	5 ~ 10 사이의 난수를 발생하여 정수변수에 담는다
	발생한 난수값이 
	5이면 "jsp";
	6이면 "HTML5"
	7이면 "Spring"
	8이면 "jQuery"
	이외의 값은 "MyBatis" 를 출력한다.
*/

public class SwitchExam01{



	public static void main(String [] args){
	
	int randNum= (int)(Math.random()*6)+5;
	System.out.println(randNum);

	switch(randNum){
	case :5
		System.out.println("jsp");
		break;
	case :6
		System.out.println("HTML5");
		break;
	case :7
		System.out.println("Spring");
		break;
	case :8
		System.out.println("jQuery");
		break;
	default:
	System.out.println("MyBatis");
		}//switch

	}//main method



}//class