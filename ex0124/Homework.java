/**
   1. ����ǥ����� ���� Ŭ������ �����ϰ� ���θ޼ҵ� �ۼ��Ѵ�.
   2. ���θ޼ҵ�ȿ��� �ϴ� ��
       - ���� �̸��� ������ ������ �����Ѵ�.
       - ����,����,���� ����(�� ������ ������ �����Ѵ�. 
       - ����, ���, ������ ������ ������ �����Ѵ�.

       - ����� ����, ����, ���� ������ �����ǰ��Ͽ� ���� �����Ѵ�.
       - ����, ����, ���������� ������ ���Ͽ� ���� ������ �����Ѵ�.
       - ������ ������ ����� ���Ͽ� ��� ������ �����Ѵ�.

       - ����� 60�̻��̸� �հ�(a), �ƴϸ� ���հ�(f)

       - �̸� , ��������, ��������, ��������, ����,���, ������ ���ڰ� ����غ���.
*/


public class Homework {
 public static void main(String[] args) {

 String name = "������";
 int korean= 66;
 int english=79;
 int math=88;
 int total=0;
 double average=0.0;
 char grade;

 total = korean+ english + math;

 average = (total / 3.0);
 
 grade= (average>=60) ? 'A' : 'F';
 

 System.out.println("�̸� : "+name);
 System.out.println("���� : "+korean);
 System.out.println("���� : "+english);
 System.out.println("���� : "+math);
 System.out.println("���� : "+total);
 System.out.println("��� : "+(int)(average*100)/100.0);
 System.out.println("���� : "+grade);

 }//main method
}//class

//������