/**
상품에 대한 정보를 5개 저장해서
    그 결과를 출력한다.
   조건 : 상품의 정보는 
          (상품명-String, 가격-int, 설명-String)

        Product.java 만든다.(private으로 field선언)
        setXxx(), getXxx()를 통해서 filed접근!!!

       ProductArrayExam.java
        - 메인 메소드를 만들고...
          Product타입의 배열을 5개 생성하여
          정보를 넣고 출력해본다.

    ----출력 결과 ---
    상품명 : 새우까 , 가격 : 3000 , 설명 : 짜다.
    상품명 : 허니 , 가격 : 2000 , 설명 : 짜다.
    상품명 : 감자깡 , 가격 : 1000 , 설명 : 짜다.
    상품명 : 고구마깡 , 가격 : 2300 , 설명 : 짜다.
    상품명 : 짱구 , 가격 : 4000 , 설명 : 짜다.
...
+ ProductArrayExam.java
조건: 전역변수에 product 타입 배열 5개 선언
전역변수 배열방에 데이터를 추가하는 메소드 작성
(인수로 초기치 데이터 2차원 배열로 받는다.)

+ Product 객체를 생성해서 데이터를 설정하고 리턴하는 메소드를 작성 (private 메소드로 작성)
+배열방에 있는 5개의 상품정보를 아래와 같이 출력
+실행할때 인수로 상품명을 받아서 상품명에 해당하는 상품정보를 출력. 
만약! 상품명이 없으면 정보가 없습니다 출력/ 있으면 상품명,가격,설명 출력

**메인메소드에서 초기치 데이터를 2차원 뱅열로 선언!**
*/
public class ProductArrayExam 
{
	Product p[];

	private void init(String initData[][]){	
		p= new Product[initData.length];//배열 그릇 만든거야
		
		for(int i=0;i<initData.length;i++){//행의 길이
		p[i]= create(initData[i]);
		}
	
	}//init method


	private Product create(String col[]){
		Product temp = new Product();
		temp.setProductName(col[0]);
		temp.setPrice(Integer.parseInt(col[1]));
		temp.setExplanation(col[2]);
		return temp;
		}//create method


	public void print(){	
		for(int i=0;i<p.length;i++){
		System.out.println("상품명 : "+p[i].getProuductName()+"\t\t"+"가격 : "+p[i].getPrice()+"\t\t"+"설명 :"+p[i].getExplanation());
		}
	}

	private boolean findData(String pName){
	boolean flag=false;
	
		for(int i=0;i<p.length;i++){
				if( p[i].getProuductName().equals(pName) ){
					System.out.println("=============================찾은 데이터=================================");
				System.out.println("상품명 : "+p[i].getProuductName()+"\t\t"+"가격 : "+p[i].getPrice()+"\t\t"+"설명 :"+p[i].getExplanation());
				flag=true;
				}
		}
	
	return flag;
	}


	public static void main(String[] args) 
	{
	String initData[][]={
		{"새우깡","3000","짜다"},
		{"허니","2000","짜다"},
		{"감자깡","1000","짜다"},
		{"고구마깡","2300","짜다"},
		{"짱구","4000","짜다"}
	};
	System.out.println("args ="+args.length);
	ProductArrayExam pae= new ProductArrayExam();

	pae.init(initData);
	pae.print();
	
	if(args.length!=0 && !pae.findData(args[0])){
	System.out.println("정보가 없습니다");
	}




	}//main
}//class
