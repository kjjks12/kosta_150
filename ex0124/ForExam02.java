/**
1~100 ������ ���ڸ� 10�� 10���� ���( ���� �ݺ���)
�������� ��� (���� �ݺ���)
*/

public class ForExam02{

	public static void main(String [] args){

	for(int i=0;i<10;i++){
		for(int j=0;j<10;j++){ 
		System.out.print((i*10)+(j+1)+" ");
		}//inner-for
		System.out.println("");
	 }//outer-for


	for(int i=0 ; i < 9 ; ++i ){//��
	    for(int j=0 ; j < 8 ; ++j){//��
		System.out.print((j+2)+"*"+(i+1)+"="+(j+2)*(i+1) +"\t");
		 } //inner-for
		System.out.println("");
	 }//outer-for

	}//main
}//class