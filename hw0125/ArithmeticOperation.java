/**
������
01-25
*/
/**
1. �ΰ��� ������ �����ȣ(+, -,*,/,%)�� ���� �޾Ƽ� 
���޵� �����ȣ�� ���� �μ��� �����Ͽ� 
 ����� ����ϴ� �޼ҵ�� 
�̸޼ҵ带ȣ���ϴ� ���θ޼ҵ带 �����غ�����.

(����, 
 �����ȣ�� (+, -,*,/,%) �̿��� ���� ������ 
�����޽��� ����Ѵ�.
��Ģ������ �ϴ� �޼ҵ��  
���θ޼ҵ尡 �ִ� Ŭ������ �ٸ��� �����Ѵ�)

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
	System.out.println("�����Դϴ�.");
	}
	return result;
   }//calcFunc method

	public void printAll(int num1, int num2, String oper){
		double result=this.calcFunc(num1,num2,oper);
		System.out.println("��� :"+result);
	}

}//class
