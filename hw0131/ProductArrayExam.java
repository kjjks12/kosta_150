/**
��ǰ�� ���� ������ 5�� �����ؼ�
    �� ����� ����Ѵ�.
   ���� : ��ǰ�� ������ 
          (��ǰ��-String, ����-int, ����-String)

        Product.java �����.(private���� field����)
        setXxx(), getXxx()�� ���ؼ� filed����!!!

       ProductArrayExam.java
        - ���� �޼ҵ带 �����...
          ProductŸ���� �迭�� 5�� �����Ͽ�
          ������ �ְ� ����غ���.

    ----��� ��� ---
    ��ǰ�� : ����� , ���� : 3000 , ���� : ¥��.
    ��ǰ�� : ��� , ���� : 2000 , ���� : ¥��.
    ��ǰ�� : ���ڱ� , ���� : 1000 , ���� : ¥��.
    ��ǰ�� : ������ , ���� : 2300 , ���� : ¥��.
    ��ǰ�� : ¯�� , ���� : 4000 , ���� : ¥��.
...
+ ProductArrayExam.java
����: ���������� product Ÿ�� �迭 5�� ����
�������� �迭�濡 �����͸� �߰��ϴ� �޼ҵ� �ۼ�
(�μ��� �ʱ�ġ ������ 2���� �迭�� �޴´�.)

+ Product ��ü�� �����ؼ� �����͸� �����ϰ� �����ϴ� �޼ҵ带 �ۼ� (private �޼ҵ�� �ۼ�)
+�迭�濡 �ִ� 5���� ��ǰ������ �Ʒ��� ���� ���
+�����Ҷ� �μ��� ��ǰ���� �޾Ƽ� ��ǰ�� �ش��ϴ� ��ǰ������ ���. 
����! ��ǰ���� ������ ������ �����ϴ� ���/ ������ ��ǰ��,����,���� ���

**���θ޼ҵ忡�� �ʱ�ġ �����͸� 2���� �𿭷� ����!**
*/
public class ProductArrayExam 
{
	Product p[];

	private void init(String initData[][]){	
		p= new Product[initData.length];//�迭 �׸� ����ž�
		
		for(int i=0;i<initData.length;i++){//���� ����
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
		System.out.println("��ǰ�� : "+p[i].getProuductName()+"\t\t"+"���� : "+p[i].getPrice()+"\t\t"+"���� :"+p[i].getExplanation());
		}
	}

	private boolean findData(String pName){
	boolean flag=false;
	
		for(int i=0;i<p.length;i++){
				if( p[i].getProuductName().equals(pName) ){
					System.out.println("=============================ã�� ������=================================");
				System.out.println("��ǰ�� : "+p[i].getProuductName()+"\t\t"+"���� : "+p[i].getPrice()+"\t\t"+"���� :"+p[i].getExplanation());
				flag=true;
				}
		}
	
	return flag;
	}


	public static void main(String[] args) 
	{
	String initData[][]={
		{"�����","3000","¥��"},
		{"���","2000","¥��"},
		{"���ڱ�","1000","¥��"},
		{"������","2300","¥��"},
		{"¯��","4000","¥��"}
	};
	System.out.println("args ="+args.length);
	ProductArrayExam pae= new ProductArrayExam();

	pae.init(initData);
	pae.print();
	
	if(args.length!=0 && !pae.findData(args[0])){
	System.out.println("������ �����ϴ�");
	}




	}//main
}//class
