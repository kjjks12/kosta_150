/**
전자제품에 관련된 주요 기능
	1.데이터 저장
	2.모든 전자제품 검색(전체 다 출력)
	3.모델번호에 해당하는 전자제품 검색
	4.모델번호에 해당하는 전자제품 수정하기(모델번호 받아서 가격,설명 부분만 수정가능하도록)
	단 모든 결과 작업등은 Endview.java에서 보여줄거야!!
*/
public class ElectronicsService
{

	private Electronics [] elecArr;

	//1. 데이터 저장 (return: treu=저장 성공 false=저장 실패
	public boolean save(String [][] initData){
		if(initData==null || initData.length==0)return false;

		elecArr = new Electronics[initData.length];
		for(int i=0;i< initData.length;i++){
			elecArr[i]=new Electronics(Integer.parseInt(initData[i][0]),initData[i][1],Integer.parseInt(initData[i][2]),initData[i][3]);
		}
		return true;
	}



	//2.모든 전자제품 검색(전체 다 출력 객체배열을 넘겨서 받을거야) 
	public Electronics[] searchAll(){
	return elecArr;
	}



	//3.모델번호에 해당하는 전자제품 검색(객체 넘겨서 받을거야)
	public Electronics searchByModelNo(int modelNo){

		for(int i=0;i<elecArr.length;i++){
			if(elecArr[i].getModelNo()==modelNo){
			return elecArr[i];
			}
		}

		return null;
	
	}




	//4.모델번호에 해당하는 전자제품 수정하기(모델번호 받아서 가격,설명 부분만 수정가능하도록)
	//return : true= 수정완료 ,false = 수정실패
	public boolean update(Electronics elec){

		
		Electronics resultElec = this.searchByModelNo(elec.getModelNo());
			
		if(resultElec != null){
		
			//resultElec.setModelName(elec.getModelName());
			resultElec.setModelPrice(elec.getModelPrice());
			resultElec.setModelDetail(elec.getModelDetail());

			return true;
		}

	return false;
	}


}
