/**
정광수
01-25
*/
/**
1. 성적구하는 기능을 담당하는 클래스 

   1) 국어, 영어, 수학 점수를 인수받아 총점을 구하여
      총점을 리턴하는 메소드 작성
      (접근제한자 private)

   2) 총점과 과목수를 인수로받아 평균을 구하여
      평균을 리턴하는 메소드 작성 
      (접근제한자 private)

   3) 평균을 인수로 받아 등급을 구하여 등급을 리턴해주는
       메소드 작성한다(접근제한자 private)
   
   4) 이름, 국어, 영어, 수학 점수를 인수로 받아
      총점 , 평균 ,등급 을 구하여 그 결과를 화면에 출력하는
      메소드를 선언하세요.
      (접근제한자 public,
       총점과 평균 , 등급은 이미 만들어진 1) , 2) ,3) 메소드를 호출
       하여 그 결과를 통해 얻어온다)
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
	}//총점 만들기

/*
 2) 총점과 과목수를 인수로받아 평균을 구하여
      평균을 리턴하는 메소드 작성 
      (접근제한자 private)
*/
	private double makeAvg(int sum){
	this.avg=(double)(sum/3);

	return avg;
	}


/*
   3) 평균을 인수로 받아 등급을 구하여 등급을 리턴해주는
       메소드 작성한다(접근제한자 private)
  */
  
   private char makeGrade(double avg){
   char Grade;
	if(avg>=90){
	 Grade='수';
	}
	 else if(avg>=80){
	 Grade='우';
	 }
	 else if(avg>=70){
	 Grade='미';
	}
	else if(avg>=60){
	Grade='양';
	}
	 else{
	 Grade='가';
	}
	return Grade;
  }//makeGrade

/*
   4) 이름, 국어, 영어, 수학 점수를 인수로 받아
      총점 , 평균 ,등급 을 구하여 그 결과를 화면에 출력하는
      메소드를 선언하세요.
      (접근제한자 public,
       총점과 평균 , 등급은 이미 만들어진 1) , 2) ,3) 메소드를 호출
       하여 그 결과를 통해 얻어온다)

*/

	public void printGrade(String n , int k, int e, int m){
	int sum;
	double avg;
	char result;
	sum=this.makeTotal(k,e,m);
	avg=this.makeAvg(sum);
	result=this.makeGrade(avg);
 System.out.println("======성적표======");
 System.out.println("이름: "+n);
 System.out.println("국어: "+k);
 System.out.println("영어: "+e);
 System.out.println("수학: "+m);
 System.out.println("총점: "+sum);
 System.out.println("평균: "+avg);
 System.out.println("학점: "+result); 
}


 
	

}

