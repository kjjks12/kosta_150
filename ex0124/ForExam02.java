/**
1~100 사이의 숫자를 10행 10열로 출력( 이중 반복문)
구구단을 출력 (이중 반복문)
*/

public class ForExam02{

	public static void main(String [] args){

	for(int i=0;i<10;i++){
		for(int j=0;j<10;j++){ 
		System.out.print((i*10)+(j+1)+" ");
		}//inner-for
		System.out.println("");
	 }//outer-for


	for(int i=0 ; i < 9 ; ++i ){//행
	    for(int j=0 ; j < 8 ; ++j){//열
		System.out.print((j+2)+"*"+(i+1)+"="+(j+2)*(i+1) +"\t");
		 } //inner-for
		System.out.println("");
	 }//outer-for

	}//main
}//class