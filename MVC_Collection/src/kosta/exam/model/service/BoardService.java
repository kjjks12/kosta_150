package kosta.exam.model.service;

import java.util.Map;

import kosta.exam.model.dto.Board;
import kosta.exam.model.util.DuplicateException;
import kosta.exam.model.util.InexistentException;

/** ��� �Խù��� ���� ��� */
public interface BoardService {

	/** 1.��� �Խù� �˻��ϱ� */
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException;

	/** 2.�Խù� ����(kind)�� �ش��ϴ� ��� �������� */
	// �Ű����� kind= �ڷ������ , ���並 �����޶� �ϴ���!!
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException;

	/** 3.kind �����߿� �۹�ȣ�� �ش��ϴ� �Խù� �˻� */
	// ex)��ī�̺� �߿� 10���� ������, or ���亸�忡 �ִ� 20���� ������
	// kind= ��������, �ڷẸ������ no= �۹�ȣ
	public Board getBoardByNo(String kind, int no) throws DuplicateException, InexistentException;

	/**
	 * 4.�Խù� ��� (����Ҷ� �۹�ȣ �ߺ����� �Ǵ�, kind ���翩�� �Ǵ�) kind ���� ���� �Ǵ�-
	 * InexistentException �۹�ȣ �ߺ����� �Ǵ� - DuplicateException
	 */
	public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException;

	/** 5. �Խù� ���� */
	public void updateBoard(Board board, String kind) throws DuplicateException, InexistentException;

	/** 6. �Խù� ���� */
	public void deleteBoard(String kind, int number) throws DuplicateException, InexistentException;

}
