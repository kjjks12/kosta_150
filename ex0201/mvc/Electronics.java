/**
전자 제품에 대한 정보 저장소 DTO = VO
*/
public class Electronics{

	//속성
	private int modelNo;
	private String modelName;
	private int modelPrice;
	private String modelDetail;


	//생성자
	public Electronics(){}

	//ElectronicsServices.update()에서 사용

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
	
	return  "상품 번호 :"+modelNo +"\t"+
			"상품 이름 :"+modelName+"\t"+
			"상품 가격 :"+modelPrice +"\t"+
			"상품 설명 :"+modelDetail +"\n";
	}


}
