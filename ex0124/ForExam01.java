/**
1. 1~100 ���� ����� ���ٷ� �Ѵ�.
2. A ~ Z ���� ����Ѵ�.
3. 1~100 ���� ���̿��� 10�� ��� �� ��� �Ѵ� (10 ,0, 30 ,...100)
4. 1~10 ������ ���� ���Ѵ�.(���� ����Ѵ�)
5. 1~100 ������ 7�� ����� �Ųٷ� ����Ѵ�.
*/


public class ForExam01{



	public static void main(String args[]){

	int sum=0;
	for(int i=0;i<100;i++){
		System.out.print(i+1+" ");
		}
	System.out.println("");
/*
	for(char j=65 ; j<91;j++){
	System.out.print (j+" ");
	}
	System.out.println("");
*/
	for(char j='A';j<='Z';j++){
	System.out.print (j+" ");
	}

	for( int k=0; k<10;k++){
	System.out.print((k+1)*10+" ");
	}
	System.out.println("");

	for(int l=0;l<10;l++){
	sum+=(l+1);
	}	
	System.out.println(sum);


	for(int m=100;m>0;m--){
	if(m%7==0){System.out.print(m+" ");}
	}

	}//main method

}//class