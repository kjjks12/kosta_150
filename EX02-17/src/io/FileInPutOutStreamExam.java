package io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInPutOutStreamExam {

	FileInputStream fis = null;

	public FileInPutOutStreamExam() {
		/** 1.Byte ������ ���� �б� */
		try {
			//Ȯ���ڰ� �� txt �ƴϿ��� ������� .java�� ��!
			fis = new FileInputStream("src/io/test.txt");
			/** ���� �Ⱦ��� ��� */
			/*
			 * while(true){ int i= fis.read(); if(i==-1) break; }
			 */

			/** ���� ���� ��� �ѱ� ����!! */
			/*
			 * int i=0; while((i=fis.read())!=-1){
			 * System.out.println(i+" = "+(char)i);//���� ���� �ž� �ڵ带 �д°� }
			 */
			/** ���� ���� ��� �ѱ� �ذ�!! */
			byte bSizeArr[] = new byte[fis.available()]; //���� ��ü�� �о�ü� �ִ� byte ������ ����!
			fis.read(bSizeArr); //����Ʈ �迭�� �о� �Ծ�
			//byte �迭�� String ���� ��ȯ!!
			String data =new String(bSizeArr);// byteString ���ڿ��� ��ȯ
			System.out.println(data);
			
			System.out.println(bSizeArr+"");// �̷��� �ϸ� �ذ� ����
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new FileInPutOutStreamExam();
	}

}
