package ex0215.event.inner;

/***
 * - Inner 클래스 형태 정리 1) 인스턴스 멤버 클래스 -> 생성 2) 정적멤버 클래스 -> static 3) 로컬 (메소드 내에서
 * 선언된 ) 클래스
 */
class Test {
	int a = 10;
	static int b = 5;

	public void aa() {
	}

	public static void bb() {
	}

	/**
	 * 1)인스턴스 멤버 클래스 생성 - static 변수 ,static 메소드 선언 안됨!! 클래스 앞에 접근제한자 모두 허용 됨
	 * -non static , static 요소 모두 접근 가능!!
	 */
	protected class InstanceInner {
		int a = 100;
		// static int b=5;
		static final int b = 50;

		public void method01() {
			System.out.println(a);// 100
			System.out.println(b);// 50
			System.out.println(Test.this.a);// 10
			System.out.println(Test.b);// Test꺼 5

		}
		// public static void method02(){}
	}

	/**
	 * 2)static 멤버 클래스 - static, non static 모두 선언 가능!! - non static 메소드 안에서
	 * Outer쪽의 non-static 변수, non-static 메소드 접근 - static 메소드 안에서 inner클래스 내에
	 * non-static 접근 안됨.!! - 외부에서 Outer 객체생성 없이 바로 접근가능
	 */
	public static class StaticInner {
		int c = 20;
		static int d = 30;

		public void cc() {
			System.out.println(c);
			System.out.println(d);
			// System.out.println(a); //class가 static 이라 outer non static 접근 못해
			System.out.println(b);
			// aa(); //static method가 아니라서 접근이 안되여!!
			bb();
		}

		public static void dd() {
			// System.out.println(c);//원래 클래스에서 스태틱은 스태틱 끼리 놀아
			System.out.println(d);
			// System.out.println(a); //class가 static 이라 outer non static 접근 못해
			System.out.println(b);
			// aa(); //aa 가static method가 아니라서 접근이 안되여!!
			bb();
		}
	}

	public void methodTest() {
		/**
		 * 3)로컬 Inner클래스 - 클래스앞에 접근 제한자 , static 허용이 안됨. - 클래스 내부에 static 선언 안됨.
		 */
		String name = "정광수 ";//JDK 1.8에서 자동으로 final이 된데 우왕~!!

		class LocalClass {
			int sum = 100;

			// static int age = 30;
			public void method01() {
				System.out.println(a);// outer 쪽 접근
				System.out.println(b);// outer 쪽 접근
				System.out.println(sum);// 내자신 클래스 접근

				aa();
				bb();
				
				System.out.println(name);
				//name="이나영"; //지역변수 안 변수 
				
			}

		}
	}

}// TEst 클래스 끝

public class InnerAccessExam {

	public static void main(String[] args) {
		// new InstanceInner(); //생성 못한다

		// 외부에서 Inner클래스 생성해서 접근하기

		// 1)인스턴스 Inner 접근
		Test t = new Test(); // 아우터 클래스 먼저 생성
		Test.InstanceInner tInner = t.new InstanceInner(); // 이너 클래스 생성하기
		tInner.method01();

		// 2)static Inner 접근
		Test.StaticInner ts = new Test.StaticInner();

	}

}
