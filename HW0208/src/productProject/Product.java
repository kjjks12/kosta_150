package productProject;


/**
 *  3.ArrayList�� �����ؼ�
   ��ǰ�� ������ 5�� �����ϰ� ����غ���.

   - ��ǰ�� ������ (��ǰ��ȣ : String, ��ǰ�̸� : String, 
                    ��ǰ���� : int  , ��ǰ���� : String)  

   �ֿ��� : 1)�߰�(�ʱ� 5�� ������ �߰�)
              2)��ü���
              3)��ǰ��ȣ�� �ش��ϴ� ��ǰ����
                 (�̸�, ���� �����Ѵ�)
              4)��ǰ��ȣ�� �ش��ϴ� ��ǰ ����
              5)��ǰ��ȣ�� �ش��ϴ� ��ǰ �˻�

 */
public class Product {

	private String productNo;
	private String productName;
	private int productPrice;
	private String productExplain;

	/**
	 * ������
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
		return "��ǰ ��ȣ =" + productNo+"\t" + "�̸� =" + productName +"\t"+ 
				"���� =" + productPrice+"\t"+ "��ǰ���� =" + productExplain ;
	}

	

	
}
