package linechat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {

	public ClientExam() {
		/** 127.0.0.1 �� �ڽ��� ���� ȣ��Ʈ���� */
		try {
			Socket sk = new Socket("127.0.0.1", 8000);
			// ��������� �ϸ� sever.accept���� �ڵ� ����

			//������ ������ ������ �б�
			BufferedReader br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String serverMessage=br.readLine();
			System.out.println("������ ���� ���� : "+serverMessage);

			
			//������ ������ ������
			PrintWriter pw=new PrintWriter(sk.getOutputStream(), true);
			pw.println("���� ��õ���ּ���");
			
			 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientExam();
	}

}
