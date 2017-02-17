package io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;

public class FileExam {

	public FileExam() throws IOException {

		String fileName = JOptionPane.showInputDialog("���� �̸� : ");
		System.out.println(fileName);

		File file = new File("src/io/" + fileName);

		if (file.exists()) {// ���� �̸��� ������ ��� (�������� ���丮������ ����)
			if (file.isDirectory()) {// ���丮 �� ���
				JOptionPane.showMessageDialog(null, fileName + "���� ����");
				String fName[] = file.list();
				for (String name : fName) {
					System.out.println(name);
				}

			} else {// ���� ���� �ϰ��
				JOptionPane.showMessageDialog(null, "���丮�� �ƴϿ�!!");
				System.out.println("���� �̸� : " + file.getName());
				System.out.println("���� ��� : " + file.canRead());
				System.out.println("���� ��� : " + file.canWrite());
				System.out.println("���� ��� : " + file.getAbsolutePath());
				System.out.println("���� ũ�� : " + file.length());
				System.out.println("������ ������ : " + file.lastModified());

				long lastTime = file.lastModified();
				String dateString = new Date(lastTime).toLocaleString();
				System.out.println("�ٲ� ������ : " + dateString);
				

			}
		} else {// ���� ģ�� ���� ���
			// JOptionPane.showMessageDialog(null, fileName + "�� ����ϴ�");
			/** ������ ����� ���丮�� ����� ���� �ϳ��� �ؾ���!! */
			// file.createNewFile();//���� ����
			// file.mkdir();// ���� ����
		}
	}

	public static void main(String[] args) throws IOException {

		new FileExam();
	}

}
