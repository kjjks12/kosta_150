public class FindGrade
{
	
    /**�������ϱ�
	*/
	private int  makeTotal(int k,int e, int m){
	  return k+e+m;
	}//���� �����

/*
 2) ������ ������� �μ��ι޾� ����� ���Ͽ�
      ����� �����ϴ� �޼ҵ� �ۼ� 
      (���������� private)
*/
	private double makeAvg(int sum , double subjectCount){ //����
		return sum/subjectCount; // 275 / 3 = 91.6666;
	}


/*
   3) ����� �μ��� �޾� ����� ���Ͽ� ����� �������ִ�
       �޼ҵ� �ۼ��Ѵ�(���������� private)
  */
  
   private char makeGrade(double avg){
   char grade='��';

	if(avg>=90){
	 grade='��';
	}
	 else if(avg>=80){
	   grade='��';
	 }
	 else if(avg>=70){
	   grade='��';
	}
	else if(avg>=60){
	  grade='��';
	}
	 

	return grade;
  }//makeGrade

/*
   4) �̸�, ����, ����, ���� ������ �μ��� �޾�
      ���� , ��� ,��� �� ���Ͽ� �� ����� ȭ�鿡 ����ϴ�
      �޼ҵ带 �����ϼ���.
      (���������� public,
       ������ ��� , ����� �̹� ������� 1) , 2) ,3) �޼ҵ带 ȣ��
       �Ͽ� �� ����� ���� ���´�)

*/

  public void printGrade(String name , int kor, int eng, int math){
	int sum = this.makeTotal(kor,eng,math);
	double avg = this.makeAvg(sum , 3);
	char result = this.makeGrade(avg);

	 System.out.println("======����ǥ======");
	 System.out.println("�̸�: "+name);
	 System.out.println("����: "+kor);
	 System.out.println("����: "+eng);
	 System.out.println("����: "+math);
	 System.out.println("����: "+sum);
	 System.out.println("���: "+(avg));
	 System.out.println("���: "+(int)(avg*100) / 100.0);
	 System.out.println("����: "+result); 
}


	public static void main(String []args){
	String name="";
	//int kor,eng,math,sum;
	int arrGrade[]= new int [3];


	System.out.println(args.length);
	if(args.length!=4){
		System.out.println("args ���� ���� ���α׷� ���� ");
		System.exit(999);}//���� 4�� �ƴϸ� ���α׷� ����

	for(int i=0;i<args.length;i++){
		if(i==0){name=args[i];}
		else{arrGrade[i-1]=Integer.parseInt(args[i]);}
	}//for ������ �Է�


	/*
	System.out.println("���� ��� ");
	for(int j=0;j<arrGrade.length;j++){
	System.out.println(arrGrade[j]);
	}
	*/
	FindGrade fg= new FindGrade();
	fg.printGrade(name,arrGrade[0],arrGrade[1],arrGrade[2]);

	}//main
}//class
