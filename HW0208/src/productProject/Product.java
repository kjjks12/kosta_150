package productProject;


/**
 *  3.ArrayList를 생성해서
   상품의 정보를 5개 저장하고 출력해본다.

   - 상품의 정보는 (상품번호 : String, 상품이름 : String, 
                    상품가격 : int  , 상품설명 : String)  

   주요기능 : 1)추가(초기 5개 데이터 추가)
              2)전체출력
              3)상품번호에 해당하는 상품정보
                 (이름, 가격 수정한다)
              4)상품번호에 해당하는 상품 삭제
              5)상품번호에 해당하는 상품 검색

 */
public class Product {

	private String productNo;
	private String productName;
	private int productPrice;
	private String productExplain;

	/**
	 * 생성자
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productNo, String productName, int productPrice, String productExplain) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productExplain = productExplain;
	}
	
	//Getter Setter	
	
	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductExplain() {
		return productExplain;
	}

	public void setProductExplain(String productExplain) {
		this.productExplain = productExplain;
	}

	@Override
	public String toString() {
		return "상품 번호 =" + productNo+"\t" + "이름 =" + productName +"\t"+ 
				"가격 =" + productPrice+"\t"+ "상품설명 =" + productExplain ;
	}

	

	
}
