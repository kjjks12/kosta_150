package multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	ServerSocket server;
	Socket sk;

	List<ServerThread> list = new ArrayList<>();

	public Server() {

		try {
			server = new ServerSocket(8000);

			while (true) {
				System.out.println("Client ���� ����� ....");
				sk = server.accept();
				System.out.println(sk.getInetAddress() + "���� ���� �Ǿ����ϴ�");

				ServerThread st = new ServerThread();
				list.add(st);
				st.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/** ���� �޼ҵ� */
	public static void main(String[] args) {

		new Server();
	}
	
	/** ��� Ŭ���̾�Ʈ���� ��ȭ�� �������ִ� �޽�� */
	public void sendMesage(String message){
		for(ServerThread st:list){
			st.pw.println(message);
		}
	}
	

	/** ���ӵ� Ŭ���̾�Ʈ�� ������� ���� �ϱ� ���� class */
	class ServerThread extends Thread {
		/** ������ ���� ���� */
		BufferedReader br;
		/** ������ ���� ���� */
		PrintWriter pw;
		/** ��ȭ�� ���� */
		String name;

		@Override
		public void run() {
			try {
				/** Ŭ���̾�Ʈ�� �������� ������ �б�*/
				br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				
				
				/** ���ӵ� Ŭ���̾�Ʈ���� ������ ������*/
				pw = new PrintWriter(sk.getOutputStream(),true);
				
				/** ��ȭ�� �б� */
				name= br.readLine();
				sendMesage("["+name+"]�� �����ϼ̽��ϴ�");
				
				String data="";
				while((data=br.readLine())!=null){
					sendMesage("["+name+"]"+data);
				}
			
			} catch (IOException e) {	//������ ����� ó��
				//���� �����带 list ���� ����
				list.remove(this); //this= ������
				//��� Ŭ���̾�Ʈ���� �˷���
				sendMesage("["+name+"]�� �����ϼ̽��ϴ�");//Ŭ���̾�Ʈ�鿡�� �����°�
				System.out.println(sk.getInetAddress()+"�ּ���"+"["+name+"]�� �����ϼ̽��ϴ�");//������ �ܼ�â
			
			}


		}
	}

}
