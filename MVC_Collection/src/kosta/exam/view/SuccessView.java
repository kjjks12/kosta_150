package kosta.exam.view;

import java.util.Iterator;
import java.util.Map;

import kosta.exam.model.dto.ArchiveBoard;
import kosta.exam.model.dto.Board;
import kosta.exam.model.dto.PhotoBoard;

public class SuccessView {

	/** ��� ���� �����ͼ� ���δ� ��� */
	/*
	 * public static void printBoard(Map<String, Map<String, Board>> allMap) {
	 * System.out.println("1. ���Խù� �˻�");
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
			System.out.println("-----"+boardKey+"Board �� ���Խù�LIST"+"-----");
			
			Map<String, Board> map = allMap.get(boardKey);// Ű�� �־ �� ������

			Iterator<String> mapIt = map.keySet().iterator();// ���� Ű���� ���ͷ����ͷ�
			while (mapIt.hasNext()) {// map ���� photo����

			    String key  = mapIt.next();
				Board board = map.get(key);
				System.out.println("key = " + key +"[" + board +"]");
				   
			}
		}

	}

	/** ���� Ÿ��, ���� �޾Ƽ� ��� �ش� ���� ���( ex)photo, archive) */
	public static void printBoardByKind(String kind, Map<String, Board> map) {
		System.out.println("-----"+kind+"Board �� ���Խù�LIST"+"-----");
		
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			System.out.println(map.get(it.next()));
		}

	}

	/** ���� ��� */
	public static void printBoardByNo(Board board) {

	}

	/** �޼��� ��� */
	public static void printMessage(String str) {

	}

}
