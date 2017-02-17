package swing.graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GraphicExam3 extends JFrame implements ActionListener {

	Canvas centerC = new GraphicCanvas2();

	JButton btn = new JButton("지우기");

	public GraphicExam3() throws HeadlessException {
		super("그래픽 연습2");
		// TODO Auto-generated constructor stub

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		// gd.setFullScreenWindow(this);

		// downC.add(btn);
		Container con = getContentPane();
		con.add(btn, BorderLayout.SOUTH);
		con.add(centerC, BorderLayout.CENTER);

		setSize(400, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Graphics g = centerC.getGraphics();
		int w= centerC.getWidth();
		int h = centerC.getHeight();
		g.clearRect(0, 0, w, h);

	}

	public static void main(String[] args) {
		new GraphicExam3();
	}

}
