package joke;

import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class JokeVirus extends JFrame {


	
	public JokeVirus() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		// 컴퓨터 환경이 여기로 담겨!!
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		this.setUndecorated(true);// 화면 확대 축소 최대화 없애버리기!! gd위에 와야해!!
		gd.setFullScreenWindow(this);
		
		Container container = getContentPane();
		container.add(new CustomJPanel());
		
		//파일 인수로 URL안받아
		//File bgm = new File("resource/bam.wav");
		//File bgm = new File("resource/bam.wav");
		//playSound(bgm);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void playSound(File file){
		   try {
		        Clip clip = AudioSystem.getClip(); //클립 생성
		        clip.open(AudioSystem.getAudioInputStream(file));
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		
	}

	public static void main(String[] args) {

		new JokeVirus();
	}

}
