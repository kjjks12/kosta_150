package ex0215.event;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ActionExam_implement_use extends JFrame implements ActionListener ,MouseListener  {

	JButton btn1 = new JButton("ù��°");
	JButton btn2 = new JButton("�ι�°");

	JTextField text = new JTextField(30);

	public ActionExam_implement_use() throws HeadlessException {
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
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		this.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		
		/**��� 1*/
		/*
		if(e.getSource()==btn1){//�̺�Ʈ�� �߻������ִ� ��ü
			text.setText("1�� ��ư�� ������ ����");
		}
		else if(e.getSource()==btn2){
			//â�� ��ġ�� ����
			text.setText("2�� !!");
		}
	*/	
	
		
		
	/**��� 2
	 * �̺�Ʈ �߻� ��ü�� label�� ������
	 * */
		String str=e.getActionCommand();
		if(str.equals("ù��°")){
			text.setText("1�� ��ư�� ������ ����");
		}
		else if (str.equals("�ι�°")){
			text.setText("2�� !!");
		}
		
		
			

	}

	
	
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		int x= e.getX();
		int y=e.getY();
		text.setText(x+","+y);
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ActionExam_implement_use();
	}

}
