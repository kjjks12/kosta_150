package productProject;

public class ProductMain {

	public static void main(String args[]){
		
		Object[][] data= {
				{"1","���ڷ�����",1000,"���ڷ������� ���� LG"},
				{"2","��Ź��",2000,"���� Ư���� â��"},
				{"3","�ڷ�����",3000,"��������� LG"},
				{"4","RX480",4000,"�׷����� ���� NVIDIA"},
				{"5","GTX970",5000,"97���� "}
		};
		
		ProductService service= new ProductService(data);
		service.print();
		service.insert(new Product("6","�ڵ���",6000,"������ ��8"));
		service.insert(new Product("3","�ڷ�����",6000,"�Ｚ�� �� ����!!"));
		service.search("2");
		service.search("10");//���µ�����
		service.update(new Product("3","�ڵ���",6000,"������ ��8"));
		service.update(new Product("9","ī��",9000,"������ ��8"));
		service.delete("3");
		service.delete("7");//���� ������
	}



}
