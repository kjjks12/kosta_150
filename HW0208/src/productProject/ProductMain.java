package productProject;

public class ProductMain {

	public static void main(String args[]){
		
		Object[][] data= {
				{"1","전자레인지",1000,"전자레인지는 역시 LG"},
				{"2","세탁기",2000,"서울 특별시 창동"},
				{"3","텔레비젼",3000,"백색가전은 LG"},
				{"4","RX480",4000,"그래픽은 역시 NVIDIA"},
				{"5","GTX970",5000,"97따리 "}
		};
		
		ProductService service= new ProductService(data);
		service.print();
		service.insert(new Product("6","핸드폰",6000,"갤럭시 폭8"));
		service.insert(new Product("3","텔레비젼",6000,"삼성이 더 좋아!!"));
		service.search("2");
		service.search("10");//없는데이터
		service.update(new Product("3","핸드폰",6000,"갤럭시 폭8"));
		service.update(new Product("9","카톡",9000,"갤럭시 폭8"));
		service.delete("3");
		service.delete("7");//없는 데이터
	}



}
