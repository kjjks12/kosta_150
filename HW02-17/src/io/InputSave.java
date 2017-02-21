package io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputSave {

	FileOutputStream fos = null;
	OutputStreamWriter osw = null;

	public InputSave() {

		// Ű���� �Է�
		try {
			// Ű���� �Է��غ�

			// byte���� �б� -> ���ڴ��� �б�� ��ȯ
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			fos = new FileOutputStream("src/io/result.txt");
			osw = new OutputStreamWriter(fos);
			while (true) {
				System.out.print("�Է� :");
				String data = br.readLine();
				if (data.equals("quit"))
					break;

				osw.write(data + "\n");
				System.out.println("�Է³��� :" + data);
			}

		} catch (Exception e) {

		} finally {
			try {
				osw.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		new InputSave();

	}

}
