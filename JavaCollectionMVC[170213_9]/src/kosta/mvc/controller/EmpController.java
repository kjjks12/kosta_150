package kosta.mvc.controller;

import kosta.mvc.model.dto.Employee;
import kosta.mvc.model.exception.ErrorInfoException;
import kosta.mvc.model.service.EmpServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class EmpController {

	private static EmpServiceImpl empService = new EmpServiceImpl();

	private static EmpController empController;

	public static EmpController getInstance() {
		

		return empController;
	}

	private EmpController() {
		// TODO Auto-generated constructor stub
	}

	static {
		try {
			empController = new EmpController();
		} catch (Exception e) {
			throw new RuntimeException("싱글톤 객체 생성 오류");
		}
		/**
		 * static 초기화블럭을 이용하면 클래스가 로딩 될 때 최초 한번 실행하게 된다.
		 * 특히나 초기화블럭을 이용하면 logic을 담을 수 있기 때문에 복잡한 초기변수 셋팅이나 위와 같이 에러처리를 위한 구문을 담을 수 있다. 
		 * 인스턴스가 사용되는 시점에 생성되는 것은 아니다.
		 */
	}

	public void selectAll() {
		try {
			SuccessView.printAll(empService.selectAll());
		} catch (ErrorInfoException e) {
			FailView.errorMEssage(e.getMessage());
		}
	}

	public void searchByKind(String kind) {
		try {
			SuccessView.printBoardByKind(kind, empService.searchByKind(kind));
		} catch (ErrorInfoException e) {
			// TODO: handle exception
			FailView.errorMEssage(e.getMessage());
		}

	}

	public void searchByNo(String kind, int no) {
		try {
			Employee emp = empService.searchByNo(kind, no);
			SuccessView.printBoardByNo(emp);
		} catch (ErrorInfoException e) {
			// TODO: handle exception
			FailView.errorMEssage(e.getMessage());
		}

	}

	public void insert(String kind, Employee emp) {
		try {
			empService.insert(kind, emp);
			SuccessView.printBoardByNo(emp);
		} catch (ErrorInfoException e) {
			// TODO: handle exception
			FailView.errorMEssage(e.getMessage());
		}
	}

	public void update(String kind, Employee emp) {
		try {
			empService.update(kind, emp);
			SuccessView.printMessage("수정하기 성공");
		} catch (ErrorInfoException e) {
			// TODO: handle exception
			FailView.errorMEssage(e.getMessage());
		}
	}

	public void delete(String kind, int no) {
		try {
			empService.delete(kind, no);
			SuccessView.printMessage("삭제 성공");
		} catch (ErrorInfoException e) {
			// TODO: handle exception
			FailView.errorMEssage(e.getMessage());
		}
	}
}
