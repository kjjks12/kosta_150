package linechat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {

	ServerSocket server;
	public ServerExam() {
		
		try {
			server= new ServerSocket(8000);
			
			while(true){
			System.out.println("Ŭ���̾�Ʈ ���� �����!!");
			Socket sk =server.accept();//Ŭ���̾�Ʈ ������ ��ٸ��� �޼ҵ�
			System.out.println(sk.getInetAddress()+"�� ���ӵǾ����ϴ�");//������ Ŭ���̾�Ʈ�� ip�� ����
			
			
			
			//Ŭ���� ��Ʈ�� ������ ������ �б� ���� ���� �б�
			
			
			BufferedReader br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String clientMessage= br.readLine();
			System.out.println("Ŭ���̾�Ʈ�� ���� ���� :"+clientMessage);
			
			
			
			
			//Ŭ���̾�Ʈ���� ������ ������
			/*
			PrintWriter pw =	new PrintWriter(sk.getOutputStream(),true);
			pw.println("�ڹ� ���� ���Ű� ȯ���մϴ�.");
			*/
			
			BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
			bw.write("�����");
			bw.flush();
			
			
			//sk.close();
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
	public static void main(String[] args) {
		new ServerExam();
	}
}
