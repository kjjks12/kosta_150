package io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;

public class FileExam {

	public FileExam() throws IOException {

		String fileName = JOptionPane.showInputDialog("파일 이름 : ");
		System.out.println(fileName);

		File file = new File("src/io/" + fileName);

		if (file.exists()) {// 파일 이름이 존재할 경우 (파일인지 디렉토리인지는 몰라)
			if (file.isDirectory()) {// 디렉토리 일 경우
				JOptionPane.showMessageDialog(null, fileName + "폴더 정보");
				String fName[] = file.list();
				for (String name : fName) {
					System.out.println(name);
				}

			} else {// 파일 형태 일경우
				JOptionPane.showMessageDialog(null, "디렉토리가 아니여!!");
				System.out.println("파일 이름 : " + file.getName());
				System.out.println("파일 기능 : " + file.canRead());
				System.out.println("쓰기 기능 : " + file.canWrite());
				System.out.println("파일 경로 : " + file.getAbsolutePath());
				System.out.println("파일 크기 : " + file.length());
				System.out.println("마지막 수정일 : " + file.lastModified());

				long lastTime = file.lastModified();
				String dateString = new Date(lastTime).toLocaleString();
				System.out.println("바뀐 수정일 : " + dateString);
				

			}
		} else {// 파일 친게 없을 경우
			// JOptionPane.showMessageDialog(null, fileName + "을 만듭니다");
			/** 파일을 만들든 디렉토리를 만들든 둘중 하나만 해야해!! */
			// file.createNewFile();//파일 생성
			// file.mkdir();// 폴더 생성
		}
	}

	public static void main(String[] args) throws IOException {

		new FileExam();
	}

}
