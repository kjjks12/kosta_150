package linechat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {

	public ClientExam() {
		/** 127.0.0.1 이 자신의 로컬 호스트래요 */
		try {
			Socket sk = new Socket("127.0.0.1", 8000);
			// 여기까지만 하면 sever.accept에서 자동 수락

			//서버가 보내온 데이터 읽기
			BufferedReader br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String serverMessage=br.readLine();
			System.out.println("서버가 보낸 내용 : "+serverMessage);

			
			//서버에 데이터 보내기
			PrintWriter pw=new PrintWriter(sk.getOutputStream(), true);
			pw.println("점심 추천해주세요");
			
			 

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
