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
		// ��ǻ�� ȯ���� ����� ���!!
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		this.setUndecorated(true);// ȭ�� Ȯ�� ��� �ִ�ȭ ���ֹ�����!! gd���� �;���!!
		gd.setFullScreenWindow(this);
		
		Container container = getContentPane();
		container.add(new CustomJPanel());
		
		//���� �μ��� URL�ȹ޾�
		//File bgm = new File("resource/bam.wav");
		//File bgm = new File("resource/bam.wav");
		//playSound(bgm);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void playSound(File file){
		   try {
		        Clip clip = AudioSystem.getClip(); //Ŭ�� ����
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
