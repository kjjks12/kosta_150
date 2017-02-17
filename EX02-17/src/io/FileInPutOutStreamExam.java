package io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInPutOutStreamExam {

	FileInputStream fis = null;

	public FileInPutOutStreamExam() {
		/** 1.Byte 단위로 파일 읽기 */
		try {
			//확장자가 꼭 txt 아니여두 상관없어 .java도 돼!
			fis = new FileInputStream("src/io/test.txt");
			/** 별루 안쓰는 방법 */
			/*
			 * while(true){ int i= fis.read(); if(i==-1) break; }
			 */

			/** 많이 쓰는 방법 한글 문제!! */
			/*
			 * int i=0; while((i=fis.read())!=-1){
			 * System.out.println(i+" = "+(char)i);//숫자 나올 거야 코드를 읽는거 }
			 */
			/** 많이 쓰는 방법 한글 해결!! */
			byte bSizeArr[] = new byte[fis.available()]; //파일 객체가 읽어올수 있는 byte 개수를 리턴!
			fis.read(bSizeArr); //바이트 배열로 읽어 왔어
			//byte 배열을 String 으로 변환!!
			String data =new String(bSizeArr);// byteString 문자열로 변환
			System.out.println(data);
			
			System.out.println(bSizeArr+"");// 이렇게 하면 해결 ㄴㄴ
			
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
