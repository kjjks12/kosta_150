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
				System.out.println("Client 접속 대기중 ....");
				sk = server.accept();
				System.out.println(sk.getInetAddress() + "님이 접속 되었습니다");

				ServerThread st = new ServerThread();
				list.add(st);
				st.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/** 메인 메소드 */
	public static void main(String[] args) {

		new Server();
	}
	
	/** 모든 클라이언트에게 대화명 전달해주는 메쏘드 */
	public void sendMesage(String message){
		for(ServerThread st:list){
			st.pw.println(message);
		}
	}
	

	/** 접속된 클라이언트를 스레드로 관리 하기 위한 class */
	class ServerThread extends Thread {
		/** 읽을때 쓰기 위해 */
		BufferedReader br;
		/** 보낼때 쓰기 위해 */
		PrintWriter pw;
		/** 대화명 저장 */
		String name;

		@Override
		public void run() {
			try {
				/** 클라이언트가 보내오는 데이터 읽기*/
				br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				
				
				/** 접속된 클라이언트에게 데이터 보내기*/
				pw = new PrintWriter(sk.getOutputStream(),true);
				
				/** 대화명 읽기 */
				name= br.readLine();
				sendMesage("["+name+"]님 입장하셨습니다");
				
				String data="";
				while((data=br.readLine())!=null){
					sendMesage("["+name+"]"+data);
				}
			
			} catch (IOException e) {	//소켓이 끊기면 처리
				//현재 스레드를 list 에서 제거
				list.remove(this); //this= 쓰레드
				//모든 클라이언트에게 알려줌
				sendMesage("["+name+"]님 퇴장하셨습니다");//클라이언트들에게 보내는거
				System.out.println(sk.getInetAddress()+"주소의"+"["+name+"]님 퇴장하셨습니다");//서버의 콘솔창
			
			}


		}
	}

}
