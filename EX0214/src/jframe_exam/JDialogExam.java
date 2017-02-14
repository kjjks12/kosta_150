package jframe_exam;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogExam extends JFrame {

	public JDialogExam() throws HeadlessException {
		super("JDialog 연습");
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		//J다이얼 로그 만들기
		//JDialog dialog=new JDialog(this,"다이얼로그 제목!!ㅎㅎ");// 다이얼로그 띄워주는 사람은 나 자신이야  (모달 상태 가능)
		JDialog dialog=new JDialog(this,"다이얼로그 제목!!ㅎㅎ",true);// 다이얼로그 먼저 띄워지는 상태!!!
		//dialog.setTitle("다이얼로그!!");
		JButton btn = new JButton(new ImageIcon("src/loginImg.PNG"));
		dialog.add(btn,BorderLayout.SOUTH);
		dialog.setSize(300, 200);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		setSize(680, 480);

		//setLocation((dim.width - getWidth()) / 2, (dim.height - getHeight()) / 2);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new JDialogExam();
	}

}
