public class Ex03{

	private String yoil;
	
	public void setYoil(String yoil){
		this.yoil=yoil;
	}
	public String getyoil(){
		return yoil;
	}

	public static void main(String []args){
	//���ڰ� 10, 20 ,30,100 �������� ���ڰ� �߻�(10�� ����θ�)
	int num=((int)(Math.random()*10)+1)*10;
	System.out.println(num);

	Ex03 ex= new Ex03();



	switch(num/10){
		case 1:
			ex.setYoil("�Ͽ���");
			break;
		case 2:
			ex.setYoil("������");
			break;
		case 3:
			ex.setYoil("ȭ����");
			break;
		case 4:
			ex.setYoil("������");
			break;
		case 5:
			ex.setYoil("�����");
			break;
		case 6:
			ex.setYoil("�ݿ���");
			break;
		default:
			ex.setYoil("�����");
			

		}//switch
	System.out.println(ex);
	}//main method


	@Override
	public String toString(){
	return "���� = "+yoil;
	}
}//class