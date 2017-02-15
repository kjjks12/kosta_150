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

	 JButton btn1 = new JButton("첫번째");
	 JButton btn2 = new JButton("두번째");

	 JTextField text = new JTextField(30);

	public ActionOuterExam() throws HeadlessException {
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
 * Action  이벤트 관련 Class
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
		if(e.getSource()==aoe.btn1){//이벤트를 발생시켜주는 주체
			aoe.text.setText("1번 버튼을 눌렀어 ㅎㅎ");
		}
		else if(e.getSource()==aoe.btn2){
			//창의 위치를 변경
			aoe.text.setText("2번 !!");
		}
	}
}

/**
 * Mouse 이벤트 관련 class
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
		System.out.println("배거파");
		aoe.setTitle("배가 너무너무 고파용");

	}
	
}
