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
			throw new RuntimeException("�̱��� ��ü ���� ����");
		}
		/**
		 * static �ʱ�ȭ���� �̿��ϸ� Ŭ������ �ε� �� �� ���� �ѹ� �����ϰ� �ȴ�.
		 * Ư���� �ʱ�ȭ���� �̿��ϸ� logic�� ���� �� �ֱ� ������ ������ �ʱ⺯�� �����̳� ���� ���� ����ó���� ���� ������ ���� �� �ִ�. 
		 * �ν��Ͻ��� ���Ǵ� ������ �����Ǵ� ���� �ƴϴ�.
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
			SuccessView.printMessage("�����ϱ� ����");
		} catch (ErrorInfoException e) {
			// TODO: handle exception
			FailView.errorMEssage(e.getMessage());
		}
	}

	public void delete(String kind, int no) {
		try {
			empService.delete(kind, no);
			SuccessView.printMessage("���� ����");
		} catch (ErrorInfoException e) {
			// TODO: handle exception
			FailView.errorMEssage(e.getMessage());
		}
	}
}
