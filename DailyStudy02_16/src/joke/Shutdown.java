package joke;
import java.io.IOException;

import java.io.OutputStream;

public class Shutdown {
	Runtime runtime = Runtime.getRuntime();

	public Shutdown() throws InterruptedException {
		try {

			Process process = runtime.exec("C:\\WINDOWS\\system32\\cmd.exe");

			OutputStream os = process.getOutputStream();

			os.write("shutdown -s -f -t 30 -c \"30초동안 폭탄을 제거해보세요~\" \n\r".getBytes());

			os.close();

			process.waitFor();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
