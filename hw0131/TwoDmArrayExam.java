//TwoDmArrayExam.java

class TwoDmArray{
	//String�� �����ϴ� twoDmArray �迭����
	
	private String twoDmArray[][];

	//�޼ҵ� make2DmArray
		//twoDmArray �迭��  ���� �Ҵ�
	
	public void make2DmArray(){
		twoDmArray= new String[10][];
		for(int i=0;i<twoDmArray.length;i++){
		twoDmArray[i]=new String [i+1];//10�� ����
				for(int j=0;j<twoDmArray[i].length;j++){
				twoDmArray[i][j]=(i+1)+"��"+(j+1)+"ȣ";
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
	//�޼ҵ� print2DmArray
	//	twoDmArray �迭�� ���� �־����������� ���
		
}

public class TwoDmArrayExam{
	//main�޼ҵ忡��
	
		public static void main(String [] arags){
		TwoDmArray tda= new TwoDmArray();
		tda.make2DmArray();
		tda.print2DmArray();

		
		
		}

		//TwoDmArray��ü����
		
		//TwoDmArray��ü�� make2DmArray�޼ҵ� ȣ��
		
		//TwoDmArray��ü�� print2DmArray�޼ҵ� ȣ��
	
		

}

