package kosta.exam.controller;

import java.util.Map;

import kosta.exam.model.dto.Board;
import kosta.exam.model.service.BoardService;
import kosta.exam.model.service.BoardServiceImpl;
import kosta.exam.model.util.DuplicateException;
import kosta.exam.model.util.InexistentException;
import kosta.exam.view.FailView;
import kosta.exam.view.SuccessView;

public class BoardController {

	private static BoardService boardService = BoardServiceImpl.getInstance();

	/** 모든 게시물 목록 검색하기 */
	public static void getAllBoard() {
		try {
			Map<String, Map<String, Board>> allMap = boardService.getBoardList();
			SuccessView.printBoard(allMap);
		} catch (Exception e) {
			FailView.errMessage(e.getMessage());
		}
	}

	public static void getBoardByKind(String kind) {
		try {
			Map<String, Board> board = boardService.getBoardByKind(kind);
			SuccessView.printBoardByKind(kind, board);
		} catch (Exception e) {
			FailView.errMessage(e.getMessage());
		}

	}

	public static void getBoardByno(String kind, int no) {
		try {
			Board board = boardService.getBoardByNo(kind, no);
			SuccessView.printBoardByNo(board);
		} catch (InexistentException | DuplicateException e) {
			FailView.errMessage(e.getMessage());
		}
	}

	public static void insertBoard(String kind, Board board) {
		try {
			boardService.insertBoard(kind, board);

		} catch (Exception e) {
			FailView.errMessage(e.getMessage());
		}

	}

	public static void deleteBoard(String kind, int no) {
		try {
			boardService.deleteBoard(kind, no);
		} catch (Exception e) {
			FailView.errMessage(e.getMessage());
		}
		
	}
	
	public static void updateBoard(Board board,String kind){
		try {
			boardService.updateBoard(board, kind);
		} catch (Exception e) {
			FailView.errMessage(e.getMessage());
		}
	}
	
	/*
	 * public static void getAllBoard(){} public static void getAllBoard(){}
	 * public static void getAllBoard(){}
	 */

}
