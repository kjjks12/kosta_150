public class CarExample
{
	public static void main(String[] args) 
	{
		Car car= new Car();

		for( int i=1;i<=5;i++){
		int problemLocation = car.run();
	
		switch(problemLocation){
		case 1:
			System.out.println("�� ���� �ѱ� Ÿ�̾�� ��ü");
			car.frontLeftTire= new HankookTire("�տ���",15);
			break;
		case 2:
			System.out.println("�� ������ kumhoTire�� ��ü");
			car.frontRightTire= new KumhoTire("�� ������",13);
			break;
		case 3:
			System.out.println("�� ���� �ѱ� Ÿ�̾�� ��ü");
			car.backLeftTire= new HankookTire("�� ����",14);
			break;
		case 4:
			System.out.println("�� ������ kumhoTire�� ��ü");
			car.backRightTire= new KumhoTire("�� ������",17);
			break;
	
		}
	}

	System.out.println("===================");//1ȸ�� �� ��µǴ� ������ ����

	}
}
