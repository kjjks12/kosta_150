package productProject;

import java.util.ArrayList;

public class ProductService extends ArrayList<Product> {

	//private static final long serialVersionUID = 1L;

	// 생성자

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
		for (Product p : this) {// 찾는게 있으면
			if (p.getProductNo().equals(productNo))
				return p;
		}
		return null;
	}

	public void insert(Product product) {
		Product p = this.findProductNo(product.getProductNo());
		if (p == null) {// 데이터 찾았는데 없으면
			super.add(product);
			System.out.println("번호 =" + "\"" + product.getProductNo() + "\"" + "이름=" + "\"" + product.getProductName()
					+ "\"" + "삽입 성공");
		} else {
			System.out.println("삽입 실패!!!!!");
		}
		this.print();
	}

	
	
	public void print() {
		System.out.println("=========출력===========");
		for (Product p : this) {
			System.out.println(p);
		}
	}

	
	
	public void search(String productNo) {
		Product p = findProductNo(productNo);
		if (p != null) {
			System.out.println("======찾은 데이터======");
			System.out.println(p);
		} else {
			System.out.println(productNo + " 데이터가 없습니다.");
		}

	}
	
	public void update(Product product){
		Product p = findProductNo(product.getProductNo());
		System.out.println(p);
		if(p!=null){//데이터가 있으면
		 p.setProductName(product.getProductName());
		 p.setProductPrice(product.getProductPrice());
		}		
		else{
			System.out.println(product.getProductNo()+"업데이트 불가 ");
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
			System.out.println(productNo + "는 지울수가 없습니다");
		}
	}

}
