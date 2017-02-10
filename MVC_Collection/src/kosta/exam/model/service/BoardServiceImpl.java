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

	// 멤버변수
	static Map<String, Map<String, Board>> allBoardList = new TreeMap<>();

	/** static 으로 객체 하나만 생성 */
	private static BoardServiceImpl instance = new BoardServiceImpl();

	/**
	 * 싱글톤 생성 외부에서 생성 안되!! 생성자 이니까 properties 파일을 로딩해서 데이터를 초기화 하고 Map에 저장!
	 */
	private BoardServiceImpl() {
		Map<String, Board> archiveMap = new TreeMap<>();
		Map<String, Board> photoMap = new TreeMap<>();
		// 1.archive Board 불러오기

		// 4.분리된 value에 board저장
		// 5.Board를 AMap에 저장
		// 1.~.properties 파일 로딩
		ResourceBundle rb = ResourceBundle.getBundle("resources/archiveInfo");
		// 모든 key에 해당하는 value를 찾아서 va
		Iterator<String> it = rb.keySet().iterator();

		while (it.hasNext()) {
			// 2.key와 value를 분리
			String key = it.next();
			String value = rb.getString(key);
			// System.out.println(key + "=" + value);

			// 3.value를 ,(콤마) 기준으로 분리
			String[] valueArr = value.split(",");

			ArchiveBoard arBoard = new ArchiveBoard(Integer.parseInt(valueArr[0]), valueArr[1], valueArr[2],
					valueArr[3], valueArr[4], valueArr[5], Integer.parseInt(valueArr[6]));

			// 아카이브Map 에 키가 없으면 = 없는데이터 -> 삽입
			if (!archiveMap.containsKey(key)) {
				archiveMap.put(key, arBoard);
			}
		}

		allBoardList.put("archive", archiveMap);

		// 2.
		// 1.~.properties 파일 로딩
		// 2.key와 value를 분리
		// 3.value를 ,(콤마) 기준으로 분리
		// 4.분리된 value에 board저장
		// 5.Board를 PMap에 저장
		rb = ResourceBundle.getBundle("resources/photoInfo");
		it = rb.keySet().iterator();

		while (it.hasNext()) {
			// 2.key와 value를 분리
			String key = it.next();
			String value = rb.getString(key);
			// System.out.println(key + "=" + value);

			// 3.value를 ,(콤마) 기준으로 분리
			String[] valueArr = value.split(",");

			PhotoBoard pBoard = new PhotoBoard(Integer.parseInt(valueArr[0]), valueArr[1], valueArr[2], valueArr[3],
					valueArr[4], valueArr[5]);

			// 아카이브Map 에 키가 없으면 = 없는데이터 -> 삽입
			if (!photoMap.containsKey(key)) {
				photoMap.put(key, pBoard);
			}
		}

		allBoardList.put("photo", photoMap);
		// System.out.println(allBoardList);
	}// 생성자 END

	/** 현재 객체를 생성해서 리턴하는 메소드 */
	public static BoardServiceImpl getInstance() {
		return instance;
	}

	@Override
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException {
		if (allBoardList == null || allBoardList.size() == 0) {
			throw new InexistentException("게시판에 게시물이 없습니다.");
		}

		return allBoardList;
	}

	@Override
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> map = allBoardList.get(kind);
		if (map == null) {// kind가 잘못된거면
			throw new InexistentException(kind + "유형의 게시판은 존재하지 않습니다.");
		}
		return map;

		/*
		 * if (allBoardList.containsKey(kind)) { return allBoardList.get(kind);
		 * } else { throw new InexistentException(kind + "유형의 게시판은 존재하지 않습니다.");
		 * }
		 */
	}

	@Override
	public Board getBoardByNo(String kind, int no) throws DuplicateException, InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> map = allBoardList.get(kind);// map이 나와
		if (map == null) {
			throw new InexistentException(kind + "유형이 잘못 입력되었습니다.");
		} else {
			Board board = map.get(no + "");// string으로 변환
			if (board == null) {
				throw new DuplicateException(no + "는 없는 글번호 입니다.");
			}
			return board;
		}

	}

	@Override
	public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> map = allBoardList.get(kind);
		if (map == null) {
			throw new InexistentException(kind + "유형의 게시판은 없으므로 등록실패");
		} else {
			// no의 중복을 체크
			if (map.containsKey(board.getNo() + "")) {
				throw new DuplicateException(board.getNo() + "는 중복 입니다.");
			}
			// 등록하기
			map.put(board.getNo() + "", board);
		}
	}

	@Override
	public void updateBoard(Board board, String kind) throws DuplicateException, InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> map = allBoardList.get(kind);
		if (map == null) {
			throw new InexistentException(kind + "유형의 게시판 업데이트 실패");
		} else {
			if (map.containsKey(board.getNo() + "")) {// 해당 맵에 키가 있으면
				map.put(board.getNo() + "", board);
			} else {
				throw new InexistentException(kind + "유형의 게시판 업데이트 실패");
			}
		}

	}

	public void deleteBoard(String kind, int number) throws DuplicateException, InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> map = allBoardList.get(kind);
		if(map==null){
			throw new InexistentException(kind + "유형의 게시판 삭제 실패");
		}
		else {
			if (map.containsKey(number + "")) {// 해당 맵에 키가 있으면
				map.remove(number+"");
			} else {
			}
		}
		
	}

}
