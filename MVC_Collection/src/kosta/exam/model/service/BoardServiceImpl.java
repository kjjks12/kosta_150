/**
 * 
 */
package kosta.exam.model.service;

import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import kosta.exam.model.dto.ArchiveBoard;
import kosta.exam.model.dto.Board;
import kosta.exam.model.dto.PhotoBoard;
import kosta.exam.model.util.DuplicateException;
import kosta.exam.model.util.InexistentException;

/**
 * 
 */
public class BoardServiceImpl implements BoardService {

	// �������
	static Map<String, Map<String, Board>> allBoardList = new TreeMap<>();

	/** static ���� ��ü �ϳ��� ���� */
	private static BoardServiceImpl instance = new BoardServiceImpl();

	/**
	 * �̱��� ���� �ܺο��� ���� �ȵ�!! ������ �̴ϱ� properties ������ �ε��ؼ� �����͸� �ʱ�ȭ �ϰ� Map�� ����!
	 */
	private BoardServiceImpl() {
		Map<String, Board> archiveMap = new TreeMap<>();
		Map<String, Board> photoMap = new TreeMap<>();
		// 1.archive Board �ҷ�����

		// 4.�и��� value�� board����
		// 5.Board�� AMap�� ����
		// 1.~.properties ���� �ε�
		ResourceBundle rb = ResourceBundle.getBundle("resources/archiveInfo");
		// ��� key�� �ش��ϴ� value�� ã�Ƽ� va
		Iterator<String> it = rb.keySet().iterator();

		while (it.hasNext()) {
			// 2.key�� value�� �и�
			String key = it.next();
			String value = rb.getString(key);
			// System.out.println(key + "=" + value);

			// 3.value�� ,(�޸�) �������� �и�
			String[] valueArr = value.split(",");

			ArchiveBoard arBoard = new ArchiveBoard(Integer.parseInt(valueArr[0]), valueArr[1], valueArr[2],
					valueArr[3], valueArr[4], valueArr[5], Integer.parseInt(valueArr[6]));

			// ��ī�̺�Map �� Ű�� ������ = ���µ����� -> ����
			if (!archiveMap.containsKey(key)) {
				archiveMap.put(key, arBoard);
			}
		}

		allBoardList.put("archive", archiveMap);

		// 2.
		// 1.~.properties ���� �ε�
		// 2.key�� value�� �и�
		// 3.value�� ,(�޸�) �������� �и�
		// 4.�и��� value�� board����
		// 5.Board�� PMap�� ����
		rb = ResourceBundle.getBundle("resources/photoInfo");
		it = rb.keySet().iterator();

		while (it.hasNext()) {
			// 2.key�� value�� �и�
			String key = it.next();
			String value = rb.getString(key);
			// System.out.println(key + "=" + value);

			// 3.value�� ,(�޸�) �������� �и�
			String[] valueArr = value.split(",");

			PhotoBoard pBoard = new PhotoBoard(Integer.parseInt(valueArr[0]), valueArr[1], valueArr[2], valueArr[3],
					valueArr[4], valueArr[5]);

			// ��ī�̺�Map �� Ű�� ������ = ���µ����� -> ����
			if (!photoMap.containsKey(key)) {
				photoMap.put(key, pBoard);
			}
		}

		allBoardList.put("photo", photoMap);
		// System.out.println(allBoardList);
	}// ������ END

	/** ���� ��ü�� �����ؼ� �����ϴ� �޼ҵ� */
	public static BoardServiceImpl getInstance() {
		return instance;
	}

	@Override
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException {
		if (allBoardList == null || allBoardList.size() == 0) {
			throw new InexistentException("�Խ��ǿ� �Խù��� �����ϴ�.");
		}

		return allBoardList;
	}

	@Override
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> map = allBoardList.get(kind);
		if (map == null) {// kind�� �߸��ȰŸ�
			throw new InexistentException(kind + "������ �Խ����� �������� �ʽ��ϴ�.");
		}
		return map;

		/*
		 * if (allBoardList.containsKey(kind)) { return allBoardList.get(kind);
		 * } else { throw new InexistentException(kind + "������ �Խ����� �������� �ʽ��ϴ�.");
		 * }
		 */
	}

	@Override
	public Board getBoardByNo(String kind, int no) throws DuplicateException, InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> map = allBoardList.get(kind);// map�� ����
		if (map == null) {
			throw new InexistentException(kind + "������ �߸� �ԷµǾ����ϴ�.");
		} else {
			Board board = map.get(no + "");// string���� ��ȯ
			if (board == null) {
				throw new DuplicateException(no + "�� ���� �۹�ȣ �Դϴ�.");
			}
			return board;
		}

	}

	@Override
	public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> map = allBoardList.get(kind);
		if (map == null) {
			throw new InexistentException(kind + "������ �Խ����� �����Ƿ� ��Ͻ���");
		} else {
			// no�� �ߺ��� üũ
			if (map.containsKey(board.getNo() + "")) {
				throw new DuplicateException(board.getNo() + "�� �ߺ� �Դϴ�.");
			}
			// ����ϱ�
			map.put(board.getNo() + "", board);
		}
	}

	@Override
	public void updateBoard(Board board, String kind) throws DuplicateException, InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> map = allBoardList.get(kind);
		if (map == null) {
			throw new InexistentException(kind + "������ �Խ��� ������Ʈ ����");
		} else {
			if (map.containsKey(board.getNo() + "")) {// �ش� �ʿ� Ű�� ������
				map.put(board.getNo() + "", board);
			} else {
				throw new InexistentException(kind + "������ �Խ��� ������Ʈ ����");
			}
		}

	}

	public void deleteBoard(String kind, int number) throws DuplicateException, InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> map = allBoardList.get(kind);
		if(map==null){
			throw new InexistentException(kind + "������ �Խ��� ���� ����");
		}
		else {
			if (map.containsKey(number + "")) {// �ش� �ʿ� Ű�� ������
				map.remove(number+"");
			} else {
			}
		}
		
	}

}
