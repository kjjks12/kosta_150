/**
 紫遂切 推短聖 閤焼辞 益 推短拭 背雁馬澗 services研 硲窒馬壱 
 益 衣引研 閤焼 衣引拭 背雁馬澗 坂稽 戚疑!!!

 奄管: 1.煽舌
	   2.乞窮薦念伊事
	   3.乞季腰硲拭 背雁馬澗 伊事
	   4.呪舛馬奄

*/
public class  ElectronicsController{

	private ElectronicsService service= new ElectronicsService();

	//1.煽舌
	public void save(String [][] initData){
		if(service.save(initData)){
		EndView.printMessage("煽舌戚 刃戟 鞠醸柔艦陥");
		}else{
		EndView.printMessage("煽舌戚 叔鳶馬心柔艦陥.");
		}
	}

	//2.乞窮薦念伊事
	public void searchAll(){
			Electronics[] elecArr=service.searchAll();
			if(elecArr==null){
			EndView.printMessage("伊事吉 傾坪球澗 蒸柔艦陥.");
			}
			else{
			EndView.printAll(elecArr);
			}
	
	}
	//3.乞季腰硲拭 背雁馬澗穿切薦念 伊事
	public void searchByModelNo(int modelNo){
		Electronics elec=service.searchByModelNo(modelNo);
		if(elec==null){
		EndView.printMessage("伊事吉 傾坪球澗 蒸柔艦陥.");
		}
		else{
		EndView.printElec(elec);
		}
		
	}

	//4.呪舛馬奄
	public void update(Electronics elec){
		if(service.update(elec)){
		EndView.printMessage("呪舛 失因 ぞぞぞぞぞぞぞ");
		}
		else{
		EndView.printMessage("呪舛 叔鳶 ばばばばばばばば");
		}

	}

	



	
}
