package jframe_exam;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExam01 extends JFrame {

	/** ȭ�鱸���� ����� ������ �ۼ� */
	public JFrameExam01() {
		super("Jframe �ǽ� 1��"); // JFrame �� title������ ȣ��!!!
		this.initFrame();
	}

	public void initFrame() {
		/** 1. �ʿ��� ��ü(Component)�� ���� */
		JButton btn = new JButton("1 ");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		/**
		 * 2. �ΰ����� �ɼ��� ����(�ʿ������ ���صε�!!) JFrame�� ���̾ƿ� �����ʿ� �⺻(boarder Layout)
		 */
		super.setLayout(new FlowLayout());

		/** 3. Container���� Component�� �߰�*/
		super.add(btn);
		super.add(btn2);
		super.add(btn3);
		super.add(btn4);

		/** 4. Container�� ũ�⸦ ����*/
		super.setSize(480, 600);// super ���� ����
		
		/** 5. Container ������*/
		super.setVisible(true);// JFrame���� x��ư�� setvisible +>false�θ� �Ȱž� ���α׷�
								// ���׾�
		
		
		/** 6. x Ŭ�� ������ ����*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new JFrameExam01();

	}

}
