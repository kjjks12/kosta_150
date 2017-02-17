package swing.graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LottoExam extends JFrame {

	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice gd = ge.getDefaultScreenDevice();

	JButton btn = new JButton("닫기");
	ImageCanvas canvas = new ImageCanvas();

	ImageIcon front, back;

	int x;
	int y;

	public LottoExam() {
		super("너의 여자친구는?????");
		gd.setFullScreenWindow(this);

		/** 1. 이미지 준비 */
		back = new ImageIcon("src/img/lt.PNG");
		Random r = new Random();
		int no = r.nextInt(10);// 0~9

		if (no < 2) {// 꽝
			front = new ImageIcon("src/img/onami.PNG");

		} else if (no > 5) {// 당첨
			front = new ImageIcon("src/img/suji.PNG");
		} else if (no < 7) {// 당첨
			front = new ImageIcon("src/img/wosung.PNG");
		}

		Container con = getContentPane();
		con.add(canvas, BorderLayout.CENTER);
		con.add(btn, BorderLayout.SOUTH);

		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		canvas.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				canvas.repaint();
				x = e.getX();
				y = e.getY();
			}
		});

	}// 생성자 끝

	/*** 이미지 넣어줄 캔버스 이너클래스 */

	class ImageCanvas extends Canvas {

		Toolkit tk = getToolkit();
		Dimension dim = tk.getScreenSize();

		@Override
		public void paint(Graphics g) {
			g.drawImage(back.getImage(), 0, 0, (int) dim.getWidth(), (int) dim.getHeight(), this);
		}

		@Override
		public void update(Graphics g) {
			g.setClip(x, y, 100, 100);
			g.drawImage(front.getImage(), 0, 0, (int) dim.getWidth(), (int) dim.getHeight(), this);
		}

	}// InnerClass

	public static void main(String[] args) {

		new LottoExam();
	}

}
