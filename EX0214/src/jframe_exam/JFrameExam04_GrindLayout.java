package jframe_exam;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExam04_GrindLayout {

	public JFrameExam04_GrindLayout() {
		init();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		JFrame jf = new JFrame("그리드 레이아웃!!");
		//jf.setLayout(new GridLayout(3, 2));
		//jf.setLayout(new GridLayout(5, 0,10,30)); //갭을 주겠다
		//jf.setLayout(new GridLayout(0, 1));//0은 행이 무한대다!!
		
		Container con = jf.getContentPane(); //컨테이너 얻어오겠다

		jf.setLayout(null);//쓰던 레이아웃 버리겠다
		JButton[] btnArr = new JButton[4];

		
		int x= 0,y=0;
		for (int i = 0; i < btnArr.length; i++) {
			btnArr[i] = new JButton((i + 1) + "버튼");
			btnArr[i].setSize(100,50);
			btnArr[i].setLocation(x,y);
			x+=50;
			y+=50;
			con.add(btnArr[i]);
		}

		jf.setSize(300, 600);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JFrameExam04_GrindLayout();

	}

}
