package singlechat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 키보드입력을 받아서 상대측에게 전송하기(보내기)
 */
public class SendThread extends Thread {
	Socket sk;
	String name;

	public SendThread(Socket sk, String name) {
		this.sk = sk;
		this.name = name;
	}

	@Override
	public void run() {
		// 키보드입력
		Scanner scan = new Scanner(System.in);

		try {
			// 상대측에게 보내기 위한 스트림 준비
			PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
			String data = "";
			/*
			 * while(!(data=scan.nextLine()).equals("exit")){ pw.println(name +
			 * " : " + data); }
			 */

			while (true) {
				data = scan.nextLine();
				if (data.equals("exit"))
					break;
				System.out.println(data);
				pw.println(name + " : " + data);
				pw.flush();
			}

			if (sk != null)
				sk.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
