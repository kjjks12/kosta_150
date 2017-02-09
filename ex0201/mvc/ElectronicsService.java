/**
������ǰ�� ���õ� �ֿ� ���
	1.������ ����
	2.��� ������ǰ �˻�(��ü �� ���)
	3.�𵨹�ȣ�� �ش��ϴ� ������ǰ �˻�
	4.�𵨹�ȣ�� �ش��ϴ� ������ǰ �����ϱ�(�𵨹�ȣ �޾Ƽ� ����,���� �κи� ���������ϵ���)
	�� ��� ��� �۾����� Endview.java���� �����ٰž�!!
*/
public class ElectronicsService
{

	private Electronics [] elecArr;

	//1. ������ ���� (return: treu=���� ���� false=���� ����
	public boolean save(String [][] initData){
		if(initData==null || initData.length==0)return false;

		elecArr = new Electronics[initData.length];
		for(int i=0;i< initData.length;i++){
			elecArr[i]=new Electronics(Integer.parseInt(initData[i][0]),initData[i][1],Integer.parseInt(initData[i][2]),initData[i][3]);
		}
		return true;
	}



	//2.��� ������ǰ �˻�(��ü �� ��� ��ü�迭�� �Ѱܼ� �����ž�) 
	public Electronics[] searchAll(){
	return elecArr;
	}



	//3.�𵨹�ȣ�� �ش��ϴ� ������ǰ �˻�(��ü �Ѱܼ� �����ž�)
	public Electronics searchByModelNo(int modelNo){

		for(int i=0;i<elecArr.length;i++){
			if(elecArr[i].getModelNo()==modelNo){
			return elecArr[i];
			}
		}

		return null;
	
	}




	//4.�𵨹�ȣ�� �ش��ϴ� ������ǰ �����ϱ�(�𵨹�ȣ �޾Ƽ� ����,���� �κи� ���������ϵ���)
	//return : true= �����Ϸ� ,false = ��������
	public boolean update(Electronics elec){

		
		Electronics resultElec = this.searchByModelNo(elec.getModelNo());
			
		if(resultElec != null){
		
			//resultElec.setModelName(elec.getModelName());
			resultElec.setModelPrice(elec.getModelPrice());
			resultElec.setModelDetail(elec.getModelDetail());

			return true;
		}

	return false;
	}


}
