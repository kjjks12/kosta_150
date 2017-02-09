/**
 ����� ��û�� �޾Ƽ� �� ��û�� �ش��ϴ� services�� ȣ���ϰ� 
 �� ����� �޾� ����� �ش��ϴ� ��� �̵�!!!

 ���: 1.����
	   2.�����ǰ�˻�
	   3.�𵨹�ȣ�� �ش��ϴ� �˻�
	   4.�����ϱ�

*/
public class  ElectronicsController{

	private ElectronicsService service= new ElectronicsService();

	//1.����
	public void save(String [][] initData){
		if(service.save(initData)){
		EndView.printMessage("������ �Ϸ� �Ǿ����ϴ�");
		}else{
		EndView.printMessage("������ �����Ͽ����ϴ�.");
		}
	}

	//2.�����ǰ�˻�
	public void searchAll(){
			Electronics[] elecArr=service.searchAll();
			if(elecArr==null){
			EndView.printMessage("�˻��� ���ڵ�� �����ϴ�.");
			}
			else{
			EndView.printAll(elecArr);
			}
	
	}
	//3.�𵨹�ȣ�� �ش��ϴ�������ǰ �˻�
	public void searchByModelNo(int modelNo){
		Electronics elec=service.searchByModelNo(modelNo);
		if(elec==null){
		EndView.printMessage("�˻��� ���ڵ�� �����ϴ�.");
		}
		else{
		EndView.printElec(elec);
		}
		
	}

	//4.�����ϱ�
	public void update(Electronics elec){
		if(service.update(elec)){
		EndView.printMessage("���� ���� ��������������");
		}
		else{
		EndView.printMessage("���� ���� �ФФФФФФФ�");
		}

	}

	



	
}
