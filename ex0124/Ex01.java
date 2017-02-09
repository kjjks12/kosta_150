
//import java.util.Random;


public class Ex01{

public static void main(String [] args){
//정수형 변수를 선언하여 임의의 값을 할당한다.

//Random random= new Random();
//int randnum=random.nextInt(100);//0~99

int randnum= (int)(Math.random()*10)+1;

System.out.println("랜덤 수 : "+randnum);
	if((randnum%2)==0){
	System.out.println("짝수");
	}
	else{
	System.out.println("홀수");
	}

	}//main method
}//class