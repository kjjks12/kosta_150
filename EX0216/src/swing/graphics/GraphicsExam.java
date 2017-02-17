package swing.graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GraphicsExam extends JFrame{
	JButton btn = new JButton("클릭");
	Canvas centerP = new GraphicPanel();
	
	public GraphicsExam(){
		super("그래픽 연습 입니다");
		
		Container con = getContentPane();
		con.add(btn,BorderLayout.NORTH);
		con.add(centerP,BorderLayout.CENTER);
		
		
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd= ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(this);

	
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//화면을 지우고 다시 그린다
				centerP.repaint();
			}
		});
	}
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new GraphicsExam();
	}

}
