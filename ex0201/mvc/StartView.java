public class  StartView
{

	public static void main(String[] args) {
	//�ʱ�ġ ������ �غ�!!
	String [][]initData={
		{"10","��Ź��","11111","�뵹�� ��Ź��"},
		{"20","�����","22222","�������� 10�� ����"},
		{"30","������","33333","����ȿ�� 5��� ������"},
		{"40","��ǳ��","44444","�߸����� ���Ҥ���"},
		{"50","���ڷ���","55555","�������� �ƹ��ų�"},
		{"60","��ǻ��","66666","��ǻ�ʹ� ���� ������"},
		{"70","TV","77777","��������� ���� LG"}
	};

	ElectronicsController controller= new ElectronicsController();
	
		//1.����
		System.out.println("1.���� ����-----------");
		controller.save(initData);

		System.out.println("1.���� ����-----------");
		//controller.save(null);
		//2.��ü�˻�
		controller.searchAll();
		
		
		//3.���ǰ˻�()
		System.out.println("3.�𵨹�ȣ �˻�(�ִ� ���)-----------");
		controller.searchByModelNo(30);
		System.out.println("3.�𵨹�ȣ �˻�(���� ���)-----------");
		controller.searchByModelNo(80);
		
		//4.����
		System.out.println("4.�����ϱ� ����-----------");
		controller.update(new Electronics(20,50000,"��û��"));


		controller.searchAll();
		System.out.println("4.�����ϱ� ����-----------");
		controller.update(new Electronics(80,50000,"������ �ɱ�"));
		controller.searchAll();

	}
}
