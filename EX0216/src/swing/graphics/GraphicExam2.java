package swing.graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GraphicExam2 extends JFrame {

	
	Canvas centerC= new GraphicCanvas();
	
	JButton btn = new JButton("종료");
	
	
	public GraphicExam2() throws HeadlessException {
		super("그래픽 연습2");
		// TODO Auto-generated constructor stub
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd= ge.getDefaultScreenDevice();
		//gd.setFullScreenWindow(this);
	
		
		//downC.add(btn);
		Container con = getContentPane();
		con.add(btn,BorderLayout.SOUTH);
		con.add(centerC,BorderLayout.CENTER);
		
		setSize(400, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	
		
	}

	
	



	public static void main(String[] args) {
		new GraphicExam2();
	}
	
	
	
}
