/**
������
01-25
*/
/**
1. �������ϴ� ����� ����ϴ� Ŭ���� 

   1) ����, ����, ���� ������ �μ��޾� ������ ���Ͽ�
      ������ �����ϴ� �޼ҵ� �ۼ�
      (���������� private)

   2) ������ ������� �μ��ι޾� ����� ���Ͽ�
      ����� �����ϴ� �޼ҵ� �ۼ� 
      (���������� private)

   3) ����� �μ��� �޾� ����� ���Ͽ� ����� �������ִ�
       �޼ҵ� �ۼ��Ѵ�(���������� private)
   
   4) �̸�, ����, ����, ���� ������ �μ��� �޾�
      ���� , ��� ,��� �� ���Ͽ� �� ����� ȭ�鿡 ����ϴ�
      �޼ҵ带 �����ϼ���.
      (���������� public,
       ������ ��� , ����� �̹� ������� 1) , 2) ,3) �޼ҵ带 ȣ��
       �Ͽ� �� ����� ���� ���´�)
*/

class FindGrade 
{
 int korean=0,english=0,math=0,sum=0;
 double avg=0.0;

	private int  makeTotal(int k,int e, int m){
	korean=k;
	english=e;
	math=m;
	 sum=korean+english+math;
	return sum;
	}//���� �����

/*
 2) ������ ������� �μ��ι޾� ����� ���Ͽ�
      ����� �����ϴ� �޼ҵ� �ۼ� 
      (���������� private)
*/
	private double makeAvg(int sum){
	this.avg=(double)(sum/3);

	return avg;
	}


/*
   3) ����� �μ��� �޾� ����� ���Ͽ� ����� �������ִ�
       �޼ҵ� �ۼ��Ѵ�(���������� private)
  */
  
   private char makeGrade(double avg){
   char Grade;
	if(avg>=90){
	 Grade='��';
	}
	 else if(avg>=80){
	 Grade='��';
	 }
	 else if(avg>=70){
	 Grade='��';
	}
	else if(avg>=60){
	Grade='��';
	}
	 else{
	 Grade='��';
	}
	return Grade;
  }//makeGrade

/*
   4) �̸�, ����, ����, ���� ������ �μ��� �޾�
      ���� , ��� ,��� �� ���Ͽ� �� ����� ȭ�鿡 ����ϴ�
      �޼ҵ带 �����ϼ���.
      (���������� public,
       ������ ��� , ����� �̹� ������� 1) , 2) ,3) �޼ҵ带 ȣ��
       �Ͽ� �� ����� ���� ���´�)

*/

	public void printGrade(String n , int k, int e, int m){
	int sum;
	double avg;
	char result;
	sum=this.makeTotal(k,e,m);
	avg=this.makeAvg(sum);
	result=this.makeGrade(avg);
 System.out.println("======����ǥ======");
 System.out.println("�̸�: "+n);
 System.out.println("����: "+k);
 System.out.println("����: "+e);
 System.out.println("����: "+m);
 System.out.println("����: "+sum);
 System.out.println("���: "+avg);
 System.out.println("����: "+result); 
}


 
	

}

