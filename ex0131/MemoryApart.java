class MultiArray{

	int [][]matrix= new int [8][9];


//������ 2���� �迭 8*9
	
//�޼ҵ��̸� :array99
	
	//for loop �� ����Ͽ� 
	//�迭�� ���� (������)�������
	//�迭�� ����� �������

	public void array99(){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
			matrix[i][j]=(i+2)*(j+1);
			}
		}
	}//array99 �޽��

		
	public void print(){
		for(int row[]:matrix){
			for(int col:row){
			System.out.print(col+"\t");
			}
		System.out.println("");
		}
	}//print �޽��
	

}//MultiArray Ŭ����


public class MemoryApart{
//main�޼ҵ忡�� 
//MultiArray��ü�� array99�޼ҵ�ȣ��

		public static void main(String [] args){
		
		MultiArray ma = new MultiArray();
		ma.array99();
		ma.print();
		}
		


	
}

