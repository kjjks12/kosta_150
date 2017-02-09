/**
���� ��ǰ�� ���� ���� ����� DTO = VO
*/
public class Electronics{

	//�Ӽ�
	private int modelNo;
	private String modelName;
	private int modelPrice;
	private String modelDetail;


	//������
	public Electronics(){}

	//ElectronicsServices.update()���� ���

	public Electronics(int modelNo,int modelPrice,String modelDetail){
		this.modelNo=modelNo;
		this.modelPrice=modelPrice;
		this.modelDetail=modelDetail;
	}
	
	public Electronics(int modelNo,String modelName,
						int modelPrice,String modelDetail){

		this(modelNo,modelPrice,modelDetail);
		this.modelName=modelName;
	
	}


	//getter setter
	public void setModelNo(int modelNo){
	this.modelNo=modelNo;
	}	
	public void setModelName(String modelName){
	this.modelName=modelName;
	}	
	public void setModelPrice(int modelPrice){
	this.modelPrice=modelPrice;
	}	
	public void setModelDetail(String modelDetail){
	this.modelDetail=modelDetail;
	}	

	public int getModelNo(){return modelNo;}
	public String getModelName(){return modelName;}
	public int getModelPrice(){return modelPrice;}
	public String getModelDetail(){return modelDetail;}

	@Override
	public String toString(){
	
	return  "��ǰ ��ȣ :"+modelNo +"\t"+
			"��ǰ �̸� :"+modelName+"\t"+
			"��ǰ ���� :"+modelPrice +"\t"+
			"��ǰ ���� :"+modelDetail +"\n";
	}


}
