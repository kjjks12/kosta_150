package kosta.mvc.model.service;

import java.util.Map;

import kosta.mvc.model.dto.Employee;
import kosta.mvc.model.exception.ErrorInfoException;

public interface EmpService {

	public Map<String,Map<String,Employee>> selectAll()throws ErrorInfoException;
	public Map<String,Employee> searchByKind (String kind )throws ErrorInfoException;
	public Employee searchByNo(String kind, int no)throws ErrorInfoException;
	public void insert(String kind, Employee emp)throws ErrorInfoException;
	public void update(String kind, Employee emp)throws ErrorInfoException;
	public void delete(String kind, int no)throws ErrorInfoException;
	
	
	
	
}
