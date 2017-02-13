package kosta.mvc.model.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import kosta.mvc.model.dto.Employee;
import kosta.mvc.model.dto.FullTime;
import kosta.mvc.model.dto.PartTime;
import kosta.mvc.model.exception.ErrorInfoException;

public class EmpServiceImpl implements EmpService {

	private Map<String, Map<String, Employee>> allMap = new HashMap<>();

	public EmpServiceImpl() {
		Map<String, Employee> fullMap = new HashMap<>();
		Map<String, Employee> partMap = new HashMap<>();

		ResourceBundle rb = ResourceBundle.getBundle("resources/fullTime");

		Iterator<String> keys = rb.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next();
			String value = rb.getString(key);
			String valueArr[] = value.split(",");

			for (int i = 0; i < valueArr.length; i++) {
				FullTime fullTime = new FullTime(Integer.parseInt(valueArr[0]), valueArr[1],
						Integer.parseInt(valueArr[2]), Integer.parseInt(valueArr[3]));
				fullMap.put(key, fullTime);
			}
		}
		// 박상욱 integer.parseInt("박상욱");
		System.out.println(fullMap);

		if (!allMap.containsKey("full")) {
			allMap.put("full", fullMap);
		}

		/***********************/
		rb = ResourceBundle.getBundle("resources/partTime");
		keys = rb.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next();
			String value = rb.getString(key);
			String valueArr[] = value.split(",");

			for (int i = 0; i < valueArr.length; i++) {
				PartTime partTime = new PartTime(Integer.parseInt(valueArr[0]), valueArr[1],
						Integer.parseInt(valueArr[2]));
				partMap.put(key, partTime);
			}
		}
		if (!allMap.containsKey("part")) {
			allMap.put("part", partMap);
		}

	}// 생성자 끝

	@Override
	public Map<String, Map<String, Employee>> selectAll() throws ErrorInfoException {
		// TODO Auto-generated method stub

		if (allMap == null) {
			throw new ErrorInfoException("selectAll ()오 류");
		} else {
			return allMap;
		}
	}

	@Override
	public Map<String, Employee> searchByKind(String kind) throws ErrorInfoException {
		// TODO Auto-generated method stub
		if (allMap.containsKey(kind) == false) {
			throw new ErrorInfoException("searchByKind ()오 류");
		} else {
			return allMap.get(kind);
		}
	}

	@Override
	public Employee searchByNo(String kind, int no) throws ErrorInfoException {
		// TODO Auto-generated method stub
		Map<String, Employee> map = allMap.get(kind);
		if (map == null) {
			throw new ErrorInfoException("searchByNo + kind오 류");
		}
		Employee employee = map.get(no + "");
		if (employee == null) {
			throw new ErrorInfoException("searchByNo + no오 류");
		}
		return employee;
		/*
		 * if(map.containsKey(no+"")==true){ return map.get(no+""); }
		 * 
		 * if (allMap.containsKey(kind) == false) {
		 * 
		 * }
		 * 
		 * else { Map<String, Employee> map = allMap.get(kind); if
		 * (map.containsKey(no + "")) { return map.get(no + ""); } else { throw
		 * new ErrorInfoException("searchByNo + no오 류"); } }
		 */
	}

	@Override
	public void insert(String kind, Employee emp) throws ErrorInfoException {
		// TODO Auto-generated method stub

		if (!allMap.containsKey(kind)) {
			throw new ErrorInfoException("insert + kind 오 류");
		} else {
			Map<String, Employee> map = allMap.get(kind);
			if (map.containsKey(emp.getEmpNo() + "")) {
				throw new ErrorInfoException("insert + key 오 류");
			} else {
				map.put(emp.getEmpNo() + "", emp);
			}
		}

	}

	@Override
	public void update(String kind, Employee emp) throws ErrorInfoException {
		// TODO Auto-generated method stub

		Map<String, Employee> map = allMap.get(kind);
		if (map == null) {
			throw new ErrorInfoException("update + kind 오 류");
		} else {
			if (map.containsKey(emp.getEmpNo() + "")) {// 업데이트 할거 있으면
				Employee tmpEmp = map.get(emp.getEmpNo() + "");
				tmpEmp = emp;
			} else {
				throw new ErrorInfoException("update + No 오 류");
			}
		}
	}

	@Override
	public void delete(String kind, int no) throws ErrorInfoException {
		// TODO Auto-generated method stub

		Map<String, Employee> map = allMap.get(kind);
		if (map == null) {
			throw new ErrorInfoException("delete + kind 오 류");
		} else {
			if (map.remove(no + "") != null) {

			} else {
				throw new ErrorInfoException("delete + 삭제데이터 없음");
			}
		}

	}

}
