package productProject;

import java.util.ArrayList;

public class ProductService extends ArrayList<Product> {

	//private static final long serialVersionUID = 1L;

	// ������

	public ProductService() {

	}

	public ProductService(Object dataArr[][]) {
		super(dataArr.length);
		/*
		 * for (int i = 0; i < dataArr.length; i++) { Product p = new
		 * Product((String) dataArr[i][0], (String) dataArr[i][1], (Integer)
		 * dataArr[i][2], (String) dataArr[i][3]); this.add(p); }
		 */
		for (Object row[] : dataArr) {
			Product p = new Product((String) row[0], (String) row[1], (Integer) row[2], (String) row[3]);
			this.add(p);
		}

	}

	public Product findProductNo(String productNo) {
		for (Product p : this) {// ã�°� ������
			if (p.getProductNo().equals(productNo))
				return p;
		}
		return null;
	}

	public void insert(Product product) {
		Product p = this.findProductNo(product.getProductNo());
		if (p == null) {// ������ ã�Ҵµ� ������
			super.add(product);
			System.out.println("��ȣ =" + "\"" + product.getProductNo() + "\"" + "�̸�=" + "\"" + product.getProductName()
					+ "\"" + "���� ����");
		} else {
			System.out.println("���� ����!!!!!");
		}
		this.print();
	}

	
	
	public void print() {
		System.out.println("=========���===========");
		for (Product p : this) {
			System.out.println(p);
		}
	}

	
	
	public void search(String productNo) {
		Product p = findProductNo(productNo);
		if (p != null) {
			System.out.println("======ã�� ������======");
			System.out.println(p);
		} else {
			System.out.println(productNo + " �����Ͱ� �����ϴ�.");
		}

	}
	
	public void update(Product product){
		Product p = findProductNo(product.getProductNo());
		System.out.println(p);
		if(p!=null){//�����Ͱ� ������
		 p.setProductName(product.getProductName());
		 p.setProductPrice(product.getProductPrice());
		}		
		else{
			System.out.println(product.getProductNo()+"������Ʈ �Ұ� ");
		}
		
		
		this.print();
		
	}

	public void delete(String productNo) {
		Product p = findProductNo(productNo);
		if (p != null) {
			this.remove(p);
			System.out.println(productNo);
			this.print();
		} else {
			System.out.println(productNo + "�� ������� �����ϴ�");
		}
	}

}
