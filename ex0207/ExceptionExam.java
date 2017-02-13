package ex0207;

public class ExceptionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		try{
		String no = args[0];
		System.out.println("인수 : "+no);
		
		int converNo=Integer.parseInt(no);
		System.out.println("convertNo :"+converNo);
		
		
		int result = 100/converNo;
		System.out.println("나눈결과 : "+result);
		
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인수를 넣어주세요!!"+e);//e= 예외클래스 종류 + 예외 메시지
		}catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요"+e.getMessage());//
		}catch (Exception e) {
			System.out.println("예외발생했습니다");
			e.printStackTrace();
			//예외메세지가 가장 디테일 하게 나와!!
			//보안에서는 취약해서!! 다지워야해!!
		}
		finally {
			System.out.println("예외발생 여부 상관없이 무조건 실행된다!!");
	
		}
		System.out.println("-메인메소드 ....끝-");
	
	}

}
