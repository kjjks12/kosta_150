package jframe_exam;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExam02_Flowlayout {

	public JFrameExam02_Flowlayout() {
		super();
		/**�ʿ��� ��ü ���� (��� ���ϰ� �Ұž� )*/
		JFrame jf = new JFrame("��� �ȹް� ���!!");
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		
		/** ���̾ƿ� ����*/
		
		FlowLayout flowLayout= new FlowLayout(FlowLayout.TRAILING);
		//FlowLayout flowLayout= new FlowLayout(FlowLayout.RIGHT, 20, 20);
		jf.setLayout(flowLayout);
		
		/** ũ�� ����*/
		jf.setSize(300, 200);
		//jf.pack(); //������Ʈ���� �ʿ��� ũ�� ��ŭ�� �ּ�����  ũ��� �����ִ� ũ��
		
		/**������Ʈ �߰�*/
		jf.add(btn1);
		jf.add(btn2);
		
		/**������*/
		jf.setVisible(true);
		
		/** ���α׷� ����*/
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrameExam02_Flowlayout();

	}

}
