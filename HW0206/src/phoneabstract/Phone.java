package phoneabstract;

public abstract class Phone {
	//�ʵ�
	public String owner;
	
	//������
	public Phone(){}//����Ʈ �����ڵ� �ִ°� ����!!
	
	public Phone( String owner){
		this.owner= owner;
	}
	
	//�޼ҵ�
	
	public void turnOn(){
		System.out.println("�� ������ ŵ�ϴ�");
	}
	public void turnOff(){
		System.out.println("�� ������ ���ϴ�");
	}	
	
}
