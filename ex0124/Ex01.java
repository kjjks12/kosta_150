
//import java.util.Random;


public class Ex01{

public static void main(String [] args){
//������ ������ �����Ͽ� ������ ���� �Ҵ��Ѵ�.

//Random random= new Random();
//int randnum=random.nextInt(100);//0~99

int randnum= (int)(Math.random()*10)+1;

System.out.println("���� �� : "+randnum);
	if((randnum%2)==0){
	System.out.println("¦��");
	}
	else{
	System.out.println("Ȧ��");
	}

	}//main method
}//class