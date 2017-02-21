package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectSerializableReadExam {

	public ObjectSerializableReadExam(){
		//저장되어 있는 객체를 역 직렬화 해서 읽기
		
		ObjectInputStream ois=null;
		try{
		ois = new ObjectInputStream(new FileInputStream("src/io/save.txt")) ;
		Student s1= (Student)ois.readObject();
		Student s2= (Student)ois.readObject();
		List<Student> list= (List<Student>)ois.readObject();
		
		System.out.println("s1 :"+s1);
		System.out.println("s2 :"+s2);
		System.out.println("list :"+list);
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
			if(ois!=null)ois.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ObjectSerializableReadExam();
	}

}
