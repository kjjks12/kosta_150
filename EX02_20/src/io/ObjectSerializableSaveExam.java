package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectSerializableSaveExam implements Serializable {

	ObjectOutputStream oos;

	public ObjectSerializableSaveExam() {
		try {
		
			oos = new ObjectOutputStream(new FileOutputStream("src/io/save.txt"));
			oos.writeObject(new Student("장희정", 18));
			oos.writeObject(new Student("이나영", 20));

			List<Student> list = new ArrayList<>();
			list.add(new Student("배용준", 40));
			list.add(new Student("원빈", 27));

			/** 리스트 직렬화 */
			oos.writeObject(list);
			
			System.out.println("저장 완료 !!");
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		new ObjectSerializableSaveExam();

	}

}
