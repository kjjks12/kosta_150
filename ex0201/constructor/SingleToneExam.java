/*
싱글톤 객체 100개를 만들어도 1개로 쓰겠다
딱1개만 생성하고 공유하여 사용하겠다
*/
class Test
{
/*
Eager initialization
*/
	//생성자
	private static Test instance= new Test();

	public static Test getInstance(){
	return instance;
	}
}

public static Test(){

}



public class SingleToneExam 
{
	public	static void main(String args[]){
	Test t1= Test.getInstance();
	Test t2= Test.getInstance();

	System.out.println("t1 :"+t1);
	System.out.println("t2 : "+t2);

	}

}
