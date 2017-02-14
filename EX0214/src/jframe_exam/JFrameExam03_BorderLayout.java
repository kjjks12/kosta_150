package jframe_exam;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExam03_BorderLayout extends JFrame {


	public JFrameExam03_BorderLayout() {
		super("3번째 연습");
		// TODO Auto-generated constructor stub
		init();
	}

	public void init() {
		//setLayout(new BorderLayout());
		setLayout(new BorderLayout(10,20));
		add(new JButton("North"), BorderLayout.NORTH);
		add(new JButton("South"), BorderLayout.SOUTH);
		add(new JButton("East"), BorderLayout.EAST);
		add(new JButton("West"), BorderLayout.WEST);
		add(new JButton("Center"), BorderLayout.CENTER);
		setSize(480, 680);
		/** 레이아웃 변경 */
	
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JFrameExam03_BorderLayout();
	}

}
