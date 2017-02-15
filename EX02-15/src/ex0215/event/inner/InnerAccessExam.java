package ex0215.event.inner;

/***
 * - Inner Ŭ���� ���� ���� 1) �ν��Ͻ� ��� Ŭ���� -> ���� 2) ������� Ŭ���� -> static 3) ���� (�޼ҵ� ������
 * ����� ) Ŭ����
 */
class Test {
	int a = 10;
	static int b = 5;

	public void aa() {
	}

	public static void bb() {
	}

	/**
	 * 1)�ν��Ͻ� ��� Ŭ���� ���� - static ���� ,static �޼ҵ� ���� �ȵ�!! Ŭ���� �տ� ���������� ��� ��� ��
	 * -non static , static ��� ��� ���� ����!!
	 */
	protected class InstanceInner {
		int a = 100;
		// static int b=5;
		static final int b = 50;

		public void method01() {
			System.out.println(a);// 100
			System.out.println(b);// 50
			System.out.println(Test.this.a);// 10
			System.out.println(Test.b);// Test�� 5

		}
		// public static void method02(){}
	}

	/**
	 * 2)static ��� Ŭ���� - static, non static ��� ���� ����!! - non static �޼ҵ� �ȿ���
	 * Outer���� non-static ����, non-static �޼ҵ� ���� - static �޼ҵ� �ȿ��� innerŬ���� ����
	 * non-static ���� �ȵ�.!! - �ܺο��� Outer ��ü���� ���� �ٷ� ���ٰ���
	 */
	public static class StaticInner {
		int c = 20;
		static int d = 30;

		public void cc() {
			System.out.println(c);
			System.out.println(d);
			// System.out.println(a); //class�� static �̶� outer non static ���� ����
			System.out.println(b);
			// aa(); //static method�� �ƴ϶� ������ �ȵǿ�!!
			bb();
		}

		public static void dd() {
			// System.out.println(c);//���� Ŭ�������� ����ƽ�� ����ƽ ���� ���
			System.out.println(d);
			// System.out.println(a); //class�� static �̶� outer non static ���� ����
			System.out.println(b);
			// aa(); //aa ��static method�� �ƴ϶� ������ �ȵǿ�!!
			bb();
		}
	}

	public void methodTest() {
		/**
		 * 3)���� InnerŬ���� - Ŭ�����տ� ���� ������ , static ����� �ȵ�. - Ŭ���� ���ο� static ���� �ȵ�.
		 */
		String name = "������ ";//JDK 1.8���� �ڵ����� final�� �ȵ� ���~!!

		class LocalClass {
			int sum = 100;

			// static int age = 30;
			public void method01() {
				System.out.println(a);// outer �� ����
				System.out.println(b);// outer �� ����
				System.out.println(sum);// ���ڽ� Ŭ���� ����

				aa();
				bb();
				
				System.out.println(name);
				//name="�̳���"; //�������� �� ���� 
				
			}

		}
	}

}// TEst Ŭ���� ��

public class InnerAccessExam {

	public static void main(String[] args) {
		// new InstanceInner(); //���� ���Ѵ�

		// �ܺο��� InnerŬ���� �����ؼ� �����ϱ�

		// 1)�ν��Ͻ� Inner ����
		Test t = new Test(); // �ƿ��� Ŭ���� ���� ����
		Test.InstanceInner tInner = t.new InstanceInner(); // �̳� Ŭ���� �����ϱ�
		tInner.method01();

		// 2)static Inner ����
		Test.StaticInner ts = new Test.StaticInner();

	}

}
