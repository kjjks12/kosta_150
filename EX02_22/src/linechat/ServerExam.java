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
			System.out.println("클라이언트 접속 대기중!!");
			Socket sk =server.accept();//클라이언트 접속을 기다리는 메소드
			System.out.println(sk.getInetAddress()+"님 접속되었습니다");//접속한 클라이언트의 ip가 나와
			
			
			
			//클라이 언트가 보내온 데이터 읽기 문자 단위 읽기
			
			
			BufferedReader br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String clientMessage= br.readLine();
			System.out.println("클라이언트가 보낸 내용 :"+clientMessage);
			
			
			
			
			//클라이언트에게 데이터 보내기
			/*
			PrintWriter pw =	new PrintWriter(sk.getOutputStream(),true);
			pw.println("자바 세상에 오신걸 환영합니다.");
			*/
			
			BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
			bw.write("배고파");
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
