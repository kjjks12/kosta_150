package singlechat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Ű�����Է��� �޾Ƽ� ��������� �����ϱ�(������)
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
		// Ű�����Է�
		Scanner scan = new Scanner(System.in);

		try {
			// ��������� ������ ���� ��Ʈ�� �غ�
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
