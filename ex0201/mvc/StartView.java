public class  StartView
{

	public static void main(String[] args) {
	//초기치 데이터 준비!!
	String [][]initData={
		{"10","세탁기","11111","통돌이 세탁기"},
		{"20","냉장고","22222","컴프레셔 10년 보증"},
		{"30","에어컨","33333","전기효율 5등급 에어컨"},
		{"40","선풍기","44444","잘만돌면 되죠ㅎㅎ"},
		{"50","전자렌지","55555","레인지는 아무거나"},
		{"60","컴퓨터","66666","컴퓨터는 역시 조립컴"},
		{"70","TV","77777","백색가전은 역시 LG"}
	};

	ElectronicsController controller= new ElectronicsController();
	
		//1.저장
		System.out.println("1.저장 성공-----------");
		controller.save(initData);

		System.out.println("1.저장 실패-----------");
		//controller.save(null);
		//2.전체검색
		controller.searchAll();
		
		
		//3.조건검색()
		System.out.println("3.모델번호 검색(있는 경우)-----------");
		controller.searchByModelNo(30);
		System.out.println("3.모델번호 검색(없는 경우)-----------");
		controller.searchByModelNo(80);
		
		//4.수정
		System.out.println("4.수정하기 성공-----------");
		controller.update(new Electronics(20,50000,"멍청아"));


		controller.searchAll();
		System.out.println("4.수정하기 실패-----------");
		controller.update(new Electronics(80,50000,"변경이 될까"));
		controller.searchAll();

	}
}
