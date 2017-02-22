package singlechat;

import java.awt.SecondaryLoop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 *������ 1:1ä���� ���� Ŭ���̾�Ʈ
 */
public class Client {

	public Client(){
		try {
			Socket sk = new Socket("192.168.0.66", 8888);	
			
			//������ ������
			new SendThread(sk, "Client�� ���� ����").start();
			
			//�޴� ������
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
