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
			String s01="������"; 
			String s02="Java";
			String s03=new String("������");
			ObjectExam oe1=new ObjectExam();
			ObjectExam oe2=new ObjectExam("�ȳ�");
			System.out.println(c);//a
			System.out.println(s01);//"������"
			System.out.println(s02);//"java"
			System.out.println(s03);//������
			System.out.println(oe1);//�ּҰ�
			System.out.println(oe2);//�ּҰ�
	}


}
