class MultiArray{

	int [][]matrix= new int [8][9];


//정수형 2차원 배열 8*9
	
//메소드이름 :array99
	
	//for loop 를 사용하여 
	//배열에 곱한 (구구단)결과저장
	//배열에 결과를 꺼내출력

	public void array99(){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
			matrix[i][j]=(i+2)*(j+1);
			}
		}
	}//array99 메써드

		
	public void print(){
		for(int row[]:matrix){
			for(int col:row){
			System.out.print(col+"\t");
			}
		System.out.println("");
		}
	}//print 메써드
	

}//MultiArray 클래스


public class MemoryApart{
//main메소드에서 
//MultiArray객체의 array99메소드호출

		public static void main(String [] args){
		
		MultiArray ma = new MultiArray();
		ma.array99();
		ma.print();
		}
		


	
}

