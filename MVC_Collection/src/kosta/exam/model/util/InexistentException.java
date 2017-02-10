package kosta.exam.model.util;
/**
 * 사용자 정의 Exception
 *	 (글번호에 해당하는 게시물 존제 유무 체크)
 * =>검색한 결과가 없을 경우 예외처리
 */
public class InexistentException extends Exception {

	private static final long serialVersionUID = 1L;

	public InexistentException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InexistentException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
	
	/**
	 * 게시판 유형이 없는 경우
	 * test유형의 게시판은 존재하지 않습니다
	 * 
	 * 게시물이 없는 경우(글번호 오류)
	 * arcive유형의 게시판에 50번호의 게시물은 없습니다
	 */
}
