package ex0215.event.inner;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ActionAnonymousExam2 extends JFrame {

	JButton btn1 = new JButton("첫번째");
	JButton btn2 = new JButton("두번째");

	JTextField text = new JTextField(30);

	public ActionAnonymousExam2() throws HeadlessException {
		super("Action Exam 입니다");
		// TODO Auto-generated constructor stub

		setLayout(new FlowLayout());

		Container con = getContentPane();
		con.add(btn1);
		con.add(btn2);
		con.add(text);

		setSize(500, 400);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/**
		 * 화면 구성 끝나고 등록!! 생성자 구현부 마지막 쪽에 와요!!
		 */

		/**
		 * 익명의 이너 클래스 !! 이너 클래스에서는 super this 사용을 못해브러요!!! super = 나 자신의 부모
		 * Object... this = inner 클래스 나자신!!
		 */
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text.setText(e.getActionCommand() + "클릭됨 ㅎㅎㅎ");
			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text.setText("두번째 버튼 클릭...");

				setTitle("ddd");// Outer 쪽에 있는거는 다 접근이 가능해!!

				JDialog d = new JDialog(ActionAnonymousExam2.this);
				d.setSize(300, 200);
				d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				d.setLocationRelativeTo(null);
				d.setVisible(true);

			}
		});

		/** 익명으로 할때에는 Adapter쓰는게 좋아용! */
		super.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

				int x= e.getX();
				int y = e.getY();
				
				text.setText(x+" , "+y);
				
			}

		});

	}

	public static void main(String[] args) {
		new ActionAnonymousExam2();
	}

}
