package ex0215.event;

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

public class ActionOuterExam extends JFrame {

	 JButton btn1 = new JButton("ù��°");
	 JButton btn2 = new JButton("�ι�°");

	 JTextField text = new JTextField(30);

	public ActionOuterExam() throws HeadlessException {
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
		btn1.addActionListener(new ActionEventExam(this));
		btn2.addActionListener(new ActionEventExam(this));
		this.addMouseListener(new MouseEventExam(this));

	}
	
	
	public static void main(String[] args) {
		new ActionOuterExam();
	}

}

/** ********************************************************************************** */
/**
 * Action  �̺�Ʈ ���� Class
 * */

class ActionEventExam implements ActionListener{
	ActionOuterExam aoe;
	public ActionEventExam(ActionOuterExam actionOuterExam) {
		// TODO Auto-generated constructor stub
		aoe=actionOuterExam;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==aoe.btn1){//�̺�Ʈ�� �߻������ִ� ��ü
			aoe.text.setText("1�� ��ư�� ������ ����");
		}
		else if(e.getSource()==aoe.btn2){
			//â�� ��ġ�� ����
			aoe.text.setText("2�� !!");
		}
	}
}

/**
 * Mouse �̺�Ʈ ���� class
 * */
class MouseEventExam extends MouseAdapter{
	ActionOuterExam aoe;
	public MouseEventExam(ActionOuterExam actionOuterExam) {
		// TODO Auto-generated constructor stub
		aoe=actionOuterExam;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x= e.getX();
		int y=e.getY();
		aoe.text.setText(x+","+y);
		System.out.println("�����");
		aoe.setTitle("�谡 �ʹ��ʹ� ���Ŀ�");

	}
	
}
