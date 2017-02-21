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

		// 키보드 입력
		try {
			// 키보드 입력준비

			// byte단위 읽기 -> 문자단위 읽기로 변환
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			fos = new FileOutputStream("src/io/result.txt");
			osw = new OutputStreamWriter(fos);
			while (true) {
				System.out.print("입력 :");
				String data = br.readLine();
				if (data.equals("quit"))
					break;

				osw.write(data + "\n");
				System.out.println("입력내용 :" + data);
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
