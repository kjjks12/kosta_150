public class FindGrade
{
	
    /**총점구하기
	*/
	private int  makeTotal(int k,int e, int m){
	  return k+e+m;
	}//총점 만들기

/*
 2) 총점과 과목수를 인수로받아 평균을 구하여
      평균을 리턴하는 메소드 작성 
      (접근제한자 private)
*/
	private double makeAvg(int sum , double subjectCount){ //총점
		return sum/subjectCount; // 275 / 3 = 91.6666;
	}


/*
   3) 평균을 인수로 받아 등급을 구하여 등급을 리턴해주는
       메소드 작성한다(접근제한자 private)
  */
  
   private char makeGrade(double avg){
   char grade='가';

	if(avg>=90){
	 grade='수';
	}
	 else if(avg>=80){
	   grade='우';
	 }
	 else if(avg>=70){
	   grade='미';
	}
	else if(avg>=60){
	  grade='양';
	}
	 

	return grade;
  }//makeGrade

/*
   4) 이름, 국어, 영어, 수학 점수를 인수로 받아
      총점 , 평균 ,등급 을 구하여 그 결과를 화면에 출력하는
      메소드를 선언하세요.
      (접근제한자 public,
       총점과 평균 , 등급은 이미 만들어진 1) , 2) ,3) 메소드를 호출
       하여 그 결과를 통해 얻어온다)

*/

  public void printGrade(String name , int kor, int eng, int math){
	int sum = this.makeTotal(kor,eng,math);
	double avg = this.makeAvg(sum , 3);
	char result = this.makeGrade(avg);

	 System.out.println("======성적표======");
	 System.out.println("이름: "+name);
	 System.out.println("국어: "+kor);
	 System.out.println("영어: "+eng);
	 System.out.println("수학: "+math);
	 System.out.println("총점: "+sum);
	 System.out.println("평균: "+(avg));
	 System.out.println("평균: "+(int)(avg*100) / 100.0);
	 System.out.println("학점: "+result); 
}


	public static void main(String []args){
	String name="";
	//int kor,eng,math,sum;
	int arrGrade[]= new int [3];


	System.out.println(args.length);
	if(args.length!=4){
		System.out.println("args 인자 부족 프로그램 종료 ");
		System.exit(999);}//인자 4개 아니면 프로그램 종료

	for(int i=0;i<args.length;i++){
		if(i==0){name=args[i];}
		else{arrGrade[i-1]=Integer.parseInt(args[i]);}
	}//for 데이터 입력


	/*
	System.out.println("내용 출력 ");
	for(int j=0;j<arrGrade.length;j++){
	System.out.println(arrGrade[j]);
	}
	*/
	FindGrade fg= new FindGrade();
	fg.printGrade(name,arrGrade[0],arrGrade[1],arrGrade[2]);

	}//main
}//class
