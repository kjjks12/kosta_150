class BooleanOPeratorExam{

	//main �޼ҵ� ����
	public static void main(String args[]){
		boolean  t=true ;//t��� ������ true �Ҵ�
		boolean f=false;//f��� ������ false �Ҵ�
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

	}//���� �޼ҵ� ��

	public static boolean test(){
		//���� �޼ҵ尡 static �̷� �׷�����
	System.out.println("�޼ҵ� ȣ���!!!");
	return false;
	
	}


}