//TwoDmArrayExam.java

class TwoDmArray{
	//String을 저장하는 twoDmArray 배열선언
	
	private String twoDmArray[][];

	//메소드 make2DmArray
		//twoDmArray 배열에  값을 할당
	
	public void make2DmArray(){
		twoDmArray= new String[10][];
		for(int i=0;i<twoDmArray.length;i++){
		twoDmArray[i]=new String [i+1];//10열 생성
				for(int j=0;j<twoDmArray[i].length;j++){
				twoDmArray[i][j]=(i+1)+"동"+(j+1)+"호";
				}//inner for
		}//outer for
	}
	
	
	public void print2DmArray(){
	/*
	for(int i=0;i<twoDmArray.length;i++){
		for(int j=0; j<twoDmArray[i].length;j++){
		System.out.print(twoDmArray[i][j]+"\t");
		}
		System.out.println("");
	}

		System.out.println("=====================================================================");


		for(int i=0; i<twoDmArray.length; i++){
	         for(int j=i; j<twoDmArray.length; j++){
	            System.out.print(twoDmArray[j][i]+"\t");
	         }
	         System.out.println();

	         for(int j=0; j<i+1; j++){
	            System.out.print("\t"+"\t");
	         }

	      }
	*/
		  System.out.println("=======================================================================");
		  for(int i=0;i<twoDmArray.length;i++){
			  int j;
			  for(j=0;j<i;j++)
				  System.out.print("\t \t");
			  for(;j<twoDmArray.length;j++)
				  System.out.print(twoDmArray[j][i] + "\t");
			  System.out.println();
		  }




		
	
	}
	//메소드 print2DmArray
	//	twoDmArray 배열의 값을 주어진형식으로 출력
		
}

public class TwoDmArrayExam{
	//main메소드에서
	
		public static void main(String [] arags){
		TwoDmArray tda= new TwoDmArray();
		tda.make2DmArray();
		tda.print2DmArray();

		
		
		}

		//TwoDmArray객체생성
		
		//TwoDmArray객체의 make2DmArray메소드 호출
		
		//TwoDmArray객체의 print2DmArray메소드 호출
	
		

}

