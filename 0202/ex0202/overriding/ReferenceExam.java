class ObjectExam{
	
	private String temp;

	public ObjectExam(){   }
	public ObjectExam(String str){
	temp=str;
	}

	@Override
	public String toString(){

	return temp;
	}
}
class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="장희정"; 
			String s02="Java";
			String s03=new String("월요일");
			ObjectExam oe1=new ObjectExam();
			ObjectExam oe2=new ObjectExam("안녕");
			System.out.println(c);//a
			System.out.println(s01);//"장희정"
			System.out.println(s02);//"java"
			System.out.println(s03);//월요일
			System.out.println(oe1);//주소값
			System.out.println(oe2);//주소값
	}


}
