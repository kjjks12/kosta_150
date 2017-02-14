package jframe_exam;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExam01 extends JFrame {

	/** 화면구성을 담당할 생성자 작성 */
	public JFrameExam01() {
		super("Jframe 실습 1번"); // JFrame 의 title생성자 호출!!!
		this.initFrame();
	}

	public void initFrame() {
		/** 1. 필요한 객체(Component)를 생성 */
		JButton btn = new JButton("1 ");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		/**
		 * 2. 부가적인 옵션을 설정(필요없으면 안해두되!!) JFrame의 레이아웃 변경필요 기본(boarder Layout)
		 */
		super.setLayout(new FlowLayout());

		/** 3. Container위에 Component를 추가*/
		super.add(btn);
		super.add(btn2);
		super.add(btn3);
		super.add(btn4);

		/** 4. Container에 크기를 지정*/
		super.setSize(480, 600);// super 생략 가능
		
		/** 5. Container 보여줘*/
		super.setVisible(true);// JFrame에서 x버튼은 setvisible +>false로만 된거야 프로그램
								// 안죽어
		
		
		/** 6. x 클릭 했을때 종료*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new JFrameExam01();

	}

}
