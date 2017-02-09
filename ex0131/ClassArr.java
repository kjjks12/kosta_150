public class ClassArr 
{
	String name;
	int age;
	public static void main(String[] args) 
	{
		ClassArr [] ca=new ClassArr[3];
		for(int i=0;i<ca.length;i++) 
		{
			System.out.println("Hello World!") ;
			ca[i]=new ClassArr() ;
		}

	}

}

