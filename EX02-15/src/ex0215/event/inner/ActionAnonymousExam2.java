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

	JButton btn1 = new JButton("ù��°");
	JButton btn2 = new JButton("�ι�°");

	JTextField text = new JTextField(30);

	public ActionAnonymousExam2() throws HeadlessException {
		super("Action Exam �Դϴ�");
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
		 * ȭ�� ���� ������ ���!! ������ ������ ������ �ʿ� �Ϳ�!!
		 */

		/**
		 * �͸��� �̳� Ŭ���� !! �̳� Ŭ���������� super this ����� ���غ귯��!!! super = �� �ڽ��� �θ�
		 * Object... this = inner Ŭ���� ���ڽ�!!
		 */
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text.setText(e.getActionCommand() + "Ŭ���� ������");
			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text.setText("�ι�° ��ư Ŭ��...");

				setTitle("ddd");// Outer �ʿ� �ִ°Ŵ� �� ������ ������!!

				JDialog d = new JDialog(ActionAnonymousExam2.this);
				d.setSize(300, 200);
				d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				d.setLocationRelativeTo(null);
				d.setVisible(true);

			}
		});

		/** �͸����� �Ҷ����� Adapter���°� ���ƿ�! */
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
