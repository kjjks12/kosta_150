public class TwoDemensionArr 
{
	int [][] intArr;
	//intArr[0]=new int [3];

	public void save(){
		//intArr= new int[3][4];
		intArr = new int[3][];
		//System.out.println(intArr);//배열 주소값
		//System.out.println(intArr[0]);//0행 (1차원 배열)
		
		//intArr[0]= new int[3];//1행은 3열
		//System.out.println(intArr[0]);//0행 (1차원 배열)
		//System.out.println(intArr[0][0]);

		//각행의 길이를 생성하는 작업이 필요
		intArr[0]= new int[5];
		intArr[1]= new int[] {1,3,5};
		intArr[2]= new int[]{10,20,30,40};
	
	}
	public void print(){

	for(int i=0 ; i< intArr.length;i++){
		for(int j=0;j<intArr[i].length;j++){
		System.out.print(intArr[i][j]+"\t");
		}
	System.out.println();
	}

		System.out.println("===========ForEach============");
		for(int Arr[]:intArr){
			for(int num:Arr){
			System.out.print(num+"\t");
			}//inner for
			System.out.println();
		}//outer for

	}//print method


	
	public static void main(String[] args) 
	{
		TwoDemensionArr tda= new TwoDemensionArr();

		tda.save();
		tda.print();

/*
		for(int i=0;i<tda.intArr.length;i++){
		System.out.println(tda.intArr[i]);
		}
*/	
	}
}
