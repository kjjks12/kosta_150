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

	JButton btn1 = new JButton("첫번째");
	JButton btn2 = new JButton("두번째");

	JTextField text = new JTextField(30);

	public ActionExam_implement_use() throws HeadlessException {
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
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		this.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		
		/**방법 1*/
		/*
		if(e.getSource()==btn1){//이벤트를 발생시켜주는 주체
			text.setText("1번 버튼을 눌렀어 ㅎㅎ");
		}
		else if(e.getSource()==btn2){
			//창의 위치를 변경
			text.setText("2번 !!");
		}
	*/	
	
		
		
	/**방법 2
	 * 이벤트 발생 주체의 label값 얻어오기
	 * */
		String str=e.getActionCommand();
		if(str.equals("첫번째")){
			text.setText("1번 버튼을 눌렀어 ㅎㅎ");
		}
		else if (str.equals("두번째")){
			text.setText("2번 !!");
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
