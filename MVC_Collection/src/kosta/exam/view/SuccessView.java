package kosta.exam.view;

import java.util.Iterator;
import java.util.Map;

import kosta.exam.model.dto.ArchiveBoard;
import kosta.exam.model.dto.Board;
import kosta.exam.model.dto.PhotoBoard;

public class SuccessView {

	/** 모든 보드 가져와서 전부다 출력 */
	/*
	 * public static void printBoard(Map<String, Map<String, Board>> allMap) {
	 * System.out.println("1. 모든게시물 검색");
	 * 
	 * Iterator<String> allIt = allMap.keySet().iterator(); while
	 * (allIt.hasNext()) { String key = allIt.next(); Map<String,Board> map =
	 * allMap.get(key);
	 * 
	 * Iterator<String> mapIt = map.keySet().iterator(); while(mapIt.hasNext()){
	 * String key2 =mapIt.next(); System.out.println("key = "+map.get(key2));
	 * 
	 * } } }
	 */

	public static void printBoard(Map<String, Map<String, Board>> allMap) {

		Iterator<String> allIt = allMap.keySet().iterator();

		while (allIt.hasNext()) {// allMap
			
			String boardKey = allIt.next();
			System.out.println("-----"+boardKey+"Board 의 모든게시물LIST"+"-----");
			
			Map<String, Board> map = allMap.get(boardKey);// 키값 넣어서 맵 가져옴

			Iterator<String> mapIt = map.keySet().iterator();// 맵의 키들을 이터레이터로
			while (mapIt.hasNext()) {// map 돌려 photo인지

			    String key  = mapIt.next();
				Board board = map.get(key);
				System.out.println("key = " + key +"[" + board +"]");
				   
			}
		}

	}

	/** 보드 타입, 보드 받아서 출력 해당 보드 출력( ex)photo, archive) */
	public static void printBoardByKind(String kind, Map<String, Board> map) {
		System.out.println("-----"+kind+"Board 의 모든게시물LIST"+"-----");
		
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			System.out.println(map.get(it.next()));
		}

	}

	/** 보드 출력 */
	public static void printBoardByNo(Board board) {

	}

	/** 메세지 출력 */
	public static void printMessage(String str) {

	}

}
