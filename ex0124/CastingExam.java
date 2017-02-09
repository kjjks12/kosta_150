class CastingExam{
	public static void main(String []args){
		byte b1,b2,b3; 
		int i1=7;
		System.out.println("int i1="+i1); //  casting

		b1=(byte)i1 ;//byte에 int를 담을 casting 필요
		System.out.println("byte b1="+b1);

		b2=(byte)20;
		System.out.println("byte b2="+b2);
		
	   	b3=(byte)(b2+b1); 
		System.out.println("byte b3="+b3);
		
		long lo=56897; //promotion
		System.out.println("long lo="+lo);

		int i4=(int)lo+i1; 
		System.out.println("int i4="+i4);
		
		boolean boo;
		boo=true;
		
		System.out.println("boolean boo="+boo);

		double d=4.67e-3;
		System.out.println("double d="+d);

		float f1=(float)lo;
		System.out.println("float f1="+f1);
				
		 float f2=(float)d;
	   
		System.out.println("float f2="+f2);

		char c1,c2, c3;
	
		c1='\u0067';
		System.out.println("char c1="+c1);

		 b2=(byte)c1; 
		System.out.println("byte b2="+b2);
		
		c2='가';
		System.out.println("char c2="+c2);
		
		c3=(char)(c2+1);
		System.out.println("char c3="+c3);
		
		//2의보수
		
	}

}