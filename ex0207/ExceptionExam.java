package ex0207;

public class ExceptionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		try{
		String no = args[0];
		System.out.println("�μ� : "+no);
		
		int converNo=Integer.parseInt(no);
		System.out.println("convertNo :"+converNo);
		
		
		int result = 100/converNo;
		System.out.println("������� : "+result);
		
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�μ��� �־��ּ���!!"+e);//e= ����Ŭ���� ���� + ���� �޽���
		}catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���"+e.getMessage());//
		}catch (Exception e) {
			System.out.println("���ܹ߻��߽��ϴ�");
			e.printStackTrace();
			//���ܸ޼����� ���� ������ �ϰ� ����!!
			//���ȿ����� ����ؼ�!! ����������!!
		}
		finally {
			System.out.println("���ܹ߻� ���� ������� ������ ����ȴ�!!");
	
		}
		System.out.println("-���θ޼ҵ� ....��-");
	
	}

}
