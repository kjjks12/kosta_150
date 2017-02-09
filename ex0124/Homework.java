/**
   1. 성적표기능을 만들 클래스를 선언하고 메인메소드 작성한다.
   2. 메인메소드안에서 하는 일
       - 본인 이름을 저장할 변수를 선언한다.
       - 국어,영어,수학 점수(를 저장할 변수를 선언한다. 
       - 총점, 평균, 학점을 저장할 변수를 선언한다.

       - 선언된 국어, 영어, 수학 변수에 임의의값하여 각각 저장한다.
       - 국어, 영어, 수학점수을 총점을 구하여 총점 변수에 저장한다.
       - 총점을 가지고 평균을 구하여 평균 변수에 저장한다.

       - 평균이 60이상이면 합격(a), 아니면 불합격(f)

       - 이름 , 국어점수, 영어점수, 수학점수, 총점,평균, 학점을 예쁘게 출력해본다.
*/


public class Homework {
 public static void main(String[] args) {

 String name = "정광수";
 int korean= 66;
 int english=79;
 int math=88;
 int total=0;
 double average=0.0;
 char grade;

 total = korean+ english + math;

 average = (total / 3.0);
 
 grade= (average>=60) ? 'A' : 'F';
 

 System.out.println("이름 : "+name);
 System.out.println("국어 : "+korean);
 System.out.println("영어 : "+english);
 System.out.println("수학 : "+math);
 System.out.println("총점 : "+total);
 System.out.println("평균 : "+(int)(average*100)/100.0);
 System.out.println("학점 : "+grade);

 }//main method
}//class

//정광수