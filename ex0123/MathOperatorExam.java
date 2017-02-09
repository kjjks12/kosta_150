class MathOperatorExam{
	public static void main(String []args){
		int i=5;
		int j=2;
		System.out.println("i+j="+i+j); //52!! 더블 + int
		System.out.println("i-j="+(i-j));//3
		System.out.println("i*j="+(i*j));//10
		System.out.println("i/j="+(i/j));//2
		System.out.println("i%j="+(i%j));//1

		System.out.println("i="+i);//5
		
		int k=i++;
		System.out.println("k="+k);//5
		System.out.println("i="+i);//6
		
		int p=++i;
		System.out.println("p="+p);//7
		System.out.println("i="+i);//7

		int x=19 + 4 * 3 / 2 - 10 * 2 + 4;//9

		System.out.println("19+4*3/2-10*2+4="+x);


	//삼항 연산자
	// 조건식 ? 참인경우 문장 : 거짓인 문장

	String  big,small,result;
	big="크다"; 
	small="작다";
	
	result= x>10 ? big : small;
	System.out.println("결과 "+result);
	
	

	}	
}