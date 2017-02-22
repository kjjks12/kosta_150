package singlechat;

import java.awt.SecondaryLoop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 *서버와 1:1채팅을 위한 클라이언트
 */
public class Client {

	public Client(){
		try {
			Socket sk = new Socket("192.168.0.66", 8888);	
			
			//보내는 스레드
			new SendThread(sk, "Client가 보낸 내용").start();
			
			//받는 스레드
			new Thread(){
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
				};//run
				
			}.start();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		


		
	}
	public static void main(String[] args) {
		new Client();
	}
}
