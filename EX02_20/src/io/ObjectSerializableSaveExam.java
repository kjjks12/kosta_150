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
			oos.writeObject(new Student("������", 18));
			oos.writeObject(new Student("�̳���", 20));

			List<Student> list = new ArrayList<>();
			list.add(new Student("�����", 40));
			list.add(new Student("����", 27));

			/** ����Ʈ ����ȭ */
			oos.writeObject(list);
			
			System.out.println("���� �Ϸ� !!");
	
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
