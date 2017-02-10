package kosta.exam.model.service;

import java.util.Map;

import kosta.exam.model.dto.Board;
import kosta.exam.model.util.DuplicateException;
import kosta.exam.model.util.InexistentException;

/** 모든 게시물의 공통 기능 */
public interface BoardService {

	/** 1.모든 게시물 검색하기 */
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException;

	/** 2.게시물 유형(kind)에 해당하는 목록 가져오기 */
	// 매개변수 kind= 자료실인지 , 포토를 보여달라구 하는지!!
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException;

	/** 3.kind 유형중에 글번호에 해당하는 게시물 검색 */
	// ex)아카이브 중에 10번만 보여줘, or 포토보드에 있는 20번만 보여줘
	// kind= 포토인지, 자료보드인지 no= 글번호
	public Board getBoardByNo(String kind, int no) throws DuplicateException, InexistentException;

	/**
	 * 4.게시물 등록 (등록할때 글번호 중복여부 판단, kind 존재여부 판단) kind 존재 여부 판단-
	 * InexistentException 글번호 중복여부 판단 - DuplicateException
	 */
	public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException;

	/** 5. 게시물 수정 */
	public void updateBoard(Board board, String kind) throws DuplicateException, InexistentException;

	/** 6. 게시물 삭제 */
	public void deleteBoard(String kind, int number) throws DuplicateException, InexistentException;

}
