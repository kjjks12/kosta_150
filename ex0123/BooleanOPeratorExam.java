class BooleanOPeratorExam{

	//main 메소드 시작
	public static void main(String args[]){
		boolean  t=true ;//t라는 변수에 true 할당
		boolean f=false;//f라는 변수에 false 할당
		System.out.println("true&false="+(t&f));//false
		System.out.println("true&true="+(t&t));//true
		System.out.println("false&false="+(f&f));//false
		System.out.println();
	
		System.out.println("true|false="+(t|f));//true
		System.out.println("true|true="+(t|t));//true
		System.out.println("false|false="+(f|f));//false
		System.out.println();

		System.out.println("true^false="+(t^f));//true
		System.out.println("true^true="+(t^t));//false
		System.out.println("true^false="+(t^f));//true
		System.out.println("true^true="+(t^t));//false
		System.out.println();

		System.out.println("true&&false="+(t&&f));//false
		System.out.println("true&&true="+(t&&t));//true
		System.out.println("true&&false="+(t&&f));//false
		System.out.println("false&&false="+(f&&f));//false
		System.out.println();

		System.out.println("true||false="+(t||f));//true
		System.out.println("true||true="+(t||t));//true
		System.out.println("false||false="+(f||f));//false
		System.out.println();

		int i=5; int j=3;
		System.out.println("int i="+i+"\tint j="+j);// 5 3 
		System.out.println("i>=j==>>"+(i>=j));//5>=3  true
		System.out.println("i>j=>>"+(i>j));//5>3 true
		System.out.println("i<=j=>>"+(i<=j));//5<=3 false
		System.out.println("i<j=>>"+(i<j));//5<3   false
		System.out.println("i==j=>>"+(i==j));//5=3   false
		System.out.println("i!=j=>>"+(i != j));//5 !=3   true

		System.out.println("======== OR =========");
		System.out.println(true | test()); //true;
		System.out.println("--------------------");
		System.out.println(true || test()); //true;

	System.out.println("======== AND =========");
		System.out.println(true & test()); //false;
		System.out.println("--------------------");
		System.out.println(true && test()); //false;

	}//메인 메소드 끝

	public static boolean test(){
		//메인 메소드가 static 이래 그런데여
	System.out.println("메소드 호출됨!!!");
	return false;
	
	}


}