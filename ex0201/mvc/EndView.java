/*
사용자 요청에 대한 결과 View
여기에선 System.out.print
*/
public class  EndView
{

	//1.모든 정보 출력
	public static void printAll(Electronics [] elecArr){

		for(Electronics elec:elecArr){
		System.out.print(elec);
		}

	}

	//2.모델번호에 해당하는 전자제품 출력
	public static void printElec(Electronics elec){
		System.out.print(elec);
	}

	//3. 저장,수정,삭제,삽입 등의 결과 메시지 출력!

	public static void printMessage(String message){
	System.out.println(message);
	}


}
