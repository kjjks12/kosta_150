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

	 JButton btn1 = new JButton("첫번째");
	 JButton btn2 = new JButton("두번째");

	 JTextField text = new JTextField(30);

	public ActionInnerExam() throws HeadlessException {
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
		btn1.addActionListener(new ActionEventExam());
		btn2.addActionListener(new ActionEventExam());
		this.addMouseListener(new MouseEventExam());

	}
	
	
	public static void main(String[] args) {
		new ActionInnerExam();
	}

	/**1. **************************** Inner Class **************************************** */
	/**2. 익명의 Inner클래스 이용 해서 이벤트 생성시 같이 만들어버려!!
	 * 	  1회성!!
	 *  */

	/**
	 * ActionInnerExam.class
	 * inner 클래스들의 형태!!
	 * outer 클래스 이름 $inner클래스이름.class
	 */

	/**
	 * Action  이벤트 관련 Class
	 * */

	class ActionEventExam implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btn1){//이벤트를 발생시켜주는 주체
				text.setText("1번 버튼을 눌렀어 ㅎㅎ");
			}
			else if(e.getSource()==btn2){
				//창의 위치를 변경
				text.setText("2번 !!");
			}
		}
	}

/**
 * Mouse 이벤트 관련 class
 * */
	class MouseEventExam extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int x= e.getX();
			int y=e.getY();
			text.setText(x+","+y);
			System.out.println("배거파");
			setTitle("배가 너무너무 고파용");

		}
		
	}
	
	
}




