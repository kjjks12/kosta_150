package joke;
import java.io.IOException;

import java.io.OutputStream;

public class Shutdown {
	Runtime runtime = Runtime.getRuntime();

	public Shutdown() throws InterruptedException {
		try {

			Process process = runtime.exec("C:\\WINDOWS\\system32\\cmd.exe");

			OutputStream os = process.getOutputStream();

			os.write("shutdown -s -f -t 30 -c \"30�ʵ��� ��ź�� �����غ�����~\" \n\r".getBytes());

			os.close();

			process.waitFor();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
