/**
	5 ~ 10 ������ ������ �߻��Ͽ� ���������� ��´�
	�߻��� �������� 
	5�̸� "jsp";
	6�̸� "HTML5"
	7�̸� "Spring"
	8�̸� "jQuery"
	�̿��� ���� "MyBatis" �� ����Ѵ�.
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