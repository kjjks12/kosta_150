package singlechat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	//�������
	ServerSocket server;
	Socket sk;
	
	//������
	public Server(){
		try {
			server = new ServerSocket(8888);	
			System.out.println("client���� ��ٸ�����...");
			sk = server.accept();
			System.out.println(sk.getInetAddress()+"���ӿϷ�");
			
			//Client���� ������ ������
			new SendThread(sk, "Server�� ���� ����").start();
			
			//�޴� ������
			new ServerRecieveThread().start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		new Server();

	}
	
	
	/**
	 * client�� �������� ������ ������ �޾Ƽ� ����Ϳ� ����ϴ� ������ 
	 * */
	class ServerRecieveThread extends Thread{
		@Override
		public void run() {
			try {
				BufferedReader br =new BufferedReader(new  InputStreamReader(sk.getInputStream()));
				
				String data="";
				while((data=br.readLine()) !=null){
					System.out.println(data);
				}
				
				if(sk!=null)sk.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}
	
	
	
	
}//ServerChatExam class









