package animalabstract;

//�߻� Ŭ���� ����
public abstract class Animal {

	public String kind;
	
	public void breathe(){
		System.out.println("���� ���ϴ� !!");
	}
	
	//�߻� �޼ҵ� ���� �Ҹ� (���� Ŭ�������� ������ �ʿ�!!)
	public abstract void sound();
	
}
