package jframe_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameExam05_JPannel extends JFrame {
	private JButton btnFile = new JButton("File");
	private JButton btnHelp = new JButton("Help");
	private JPanel panel = new JPanel();

	public JFrameExam05_JPannel() {
		super("복합 레이아웃");
		// 기타작업
		// 1)바탕생 변경
		panel.setBackground(new Color(204, 0, 51));
		//2)글자색 변경
	
		
		// 1.컨테이너 가져오기
		Container container = super.getContentPane();

		// 2.Japnel위에 추가

		btnFile.setFont(new Font(Font.SERIF,Font.ITALIC+Font.BOLD,30));
		btnFile.setBackground(Color.blue);
		panel.add(btnFile);
		
		panel.add(btnHelp);

		container.add(panel, BorderLayout.NORTH);
		container.add(new JButton("WestButton"), BorderLayout.WEST);
		container.add(new JButton("CenterButton"), BorderLayout.CENTER);

		setSize(600, 480);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JFrameExam05_JPannel();
	}

}
