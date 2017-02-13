package kosta.mvc.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import kosta.mvc.model.dto.Employee;

public class SuccessView {

	public static void printAll(Map<String, Map<String,Employee>> allMap){
		Iterator<String> allMapkeys=allMap.keySet().iterator();
		while(allMapkeys.hasNext()){
			String mapkey=allMapkeys.next();
			System.out.println("========"+mapkey+"직원"+"========");
			
			Map<String,Employee> map = allMap.get(mapkey);
			Iterator<String> keys = map.keySet().iterator();
			while(keys.hasNext()){
				String key = keys.next();
				System.out.println(map.get(key));
			}
		}
	}
	
	public static void printBoardByKind(String kind, Map<String,Employee> map){
	
		System.out.println("========"+kind+"직원"+"========");
		Iterator<String> mapkeys=map.keySet().iterator();
		while(mapkeys.hasNext()){
			String key= mapkeys.next();
			System.out.println(map.get(key));
		}
		
	}
	
	public static void printBoardByNo(Employee emp){
		System.out.println(emp);
	}
	
	public static void printMessage(String message){
		System.out.println(message);
		
	}
	
	
}
