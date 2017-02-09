/**
정광수
01-25
*/
/**
1. 두개의 정수와 연산기호(+, -,*,/,%)를 전달 받아서 
전달된 연산기호에 따라 두수를 연산하여 
 결과를 출력하는 메소드와 
이메소드를호출하는 메인메소드를 정의해보세요.

(조건, 
 연산기호가 (+, -,*,/,%) 이외의 값이 들어오면 
오류메시지 출력한다.
사칙연산을 하는 메소드와  
메인메소드가 있는 클래스는 다르게 선언한다)

*/

public class  ArithmeticOperation
{
	int num1=0,num2=0;
	String oper=null;
	double result=0.0;	
	
	private double calcFunc(int num1, int num2,String oper){
	double result=0.0;
	if(oper.equals("+")){
	result=(double)(num1+num2);
	}
	else if(oper.equals("-")){
	result=(double)(num1-num2);
	}
	else if(oper.equals("*")){
	result=(double)(num1*num2);
	}
	else if(oper.equals("/")){
	result=(double)(num1/num2);
	}
	else if(oper.equals("%")){
	result=(double)(num1%num2);
	}
	else{
	System.out.println("에러입니다.");
	}
	return result;
   }//calcFunc method

	public void printAll(int num1, int num2, String oper){
		double result=this.calcFunc(num1,num2,oper);
		System.out.println("결과 :"+result);
	}

}//class
