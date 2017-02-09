/**
 사용자 요청을 받아서 그 요청에 해당하는 services를 호출하고 
 그 결과를 받아 결과에 해당하는 뷰로 이동!!!

 기능: 1.저장
	   2.모든제품검색
	   3.모델번호에 해당하는 검색
	   4.수정하기

*/
public class  ElectronicsController{

	private ElectronicsService service= new ElectronicsService();

	//1.저장
	public void save(String [][] initData){
		if(service.save(initData)){
		EndView.printMessage("저장이 완료 되었습니다");
		}else{
		EndView.printMessage("저장이 실패하였습니다.");
		}
	}

	//2.모든제품검색
	public void searchAll(){
			Electronics[] elecArr=service.searchAll();
			if(elecArr==null){
			EndView.printMessage("검색된 레코드는 없습니다.");
			}
			else{
			EndView.printAll(elecArr);
			}
	
	}
	//3.모델번호에 해당하는전자제품 검색
	public void searchByModelNo(int modelNo){
		Electronics elec=service.searchByModelNo(modelNo);
		if(elec==null){
		EndView.printMessage("검색된 레코드는 없습니다.");
		}
		else{
		EndView.printElec(elec);
		}
		
	}

	//4.수정하기
	public void update(Electronics elec){
		if(service.update(elec)){
		EndView.printMessage("수정 성공 ㅎㅎㅎㅎㅎㅎㅎ");
		}
		else{
		EndView.printMessage("수정 실패 ㅠㅠㅠㅠㅠㅠㅠㅠ");
		}

	}

	



	
}
