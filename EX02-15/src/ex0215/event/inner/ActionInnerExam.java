package ex0215.event.inner;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ActionInnerExam extends JFrame {

	 JButton btn1 = new JButton("ù��°");
	 JButton btn2 = new JButton("�ι�°");

	 JTextField text = new JTextField(30);

	public ActionInnerExam() throws HeadlessException {
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
		btn1.addActionListener(new ActionEventExam());
		btn2.addActionListener(new ActionEventExam());
		this.addMouseListener(new MouseEventExam());

	}
	
	
	public static void main(String[] args) {
		new ActionInnerExam();
	}

	/**1. **************************** Inner Class **************************************** */
	/**2. �͸��� InnerŬ���� �̿� �ؼ� �̺�Ʈ ������ ���� ��������!!
	 * 	  1ȸ��!!
	 *  */

	/**
	 * ActionInnerExam.class
	 * inner Ŭ�������� ����!!
	 * outer Ŭ���� �̸� $innerŬ�����̸�.class
	 */

	/**
	 * Action  �̺�Ʈ ���� Class
	 * */

	class ActionEventExam implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btn1){//�̺�Ʈ�� �߻������ִ� ��ü
				text.setText("1�� ��ư�� ������ ����");
			}
			else if(e.getSource()==btn2){
				//â�� ��ġ�� ����
				text.setText("2�� !!");
			}
		}
	}

/**
 * Mouse �̺�Ʈ ���� class
 * */
	class MouseEventExam extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int x= e.getX();
			int y=e.getY();
			text.setText(x+","+y);
			System.out.println("�����");
			setTitle("�谡 �ʹ��ʹ� ���Ŀ�");

		}
		
	}
	
	
}




