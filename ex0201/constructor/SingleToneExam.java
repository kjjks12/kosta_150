/*
�̱��� ��ü 100���� ���� 1���� ���ڴ�
��1���� �����ϰ� �����Ͽ� ����ϰڴ�
*/
class Test
{
/*
Eager initialization
*/
	//������
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
