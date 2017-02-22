package singlechat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	//멤버변수
	ServerSocket server;
	Socket sk;
	
	//생성자
	public Server(){
		try {
			server = new ServerSocket(8888);	
			System.out.println("client접속 기다리는중...");
			sk = server.accept();
			System.out.println(sk.getInetAddress()+"접속완료");
			
			//Client에게 보내는 스레드
			new SendThread(sk, "Server가 보낸 내용").start();
			
			//받는 스레드
			new ServerRecieveThread().start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		new Server();

	}
	
	
	/**
	 * client가 보내오는 내용을 서버가 받아서 모니터에 출력하는 스레드 
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









