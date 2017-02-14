package jframe_exam;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExam02_Flowlayout {

	public JFrameExam02_Flowlayout() {
		super();
		/**필요한 객체 생성 (상속 안하고 할거야 )*/
		JFrame jf = new JFrame("상속 안받고 사용!!");
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		
		/** 레이아웃 변경*/
		
		FlowLayout flowLayout= new FlowLayout(FlowLayout.TRAILING);
		//FlowLayout flowLayout= new FlowLayout(FlowLayout.RIGHT, 20, 20);
		jf.setLayout(flowLayout);
		
		/** 크기 지정*/
		jf.setSize(300, 200);
		//jf.pack(); //컴포넌트들이 필요한 크기 만큼의 최소한의  크기로 보여주는 크기
		
		/**컴포넌트 추가*/
		jf.add(btn1);
		jf.add(btn2);
		
		/**보여줘*/
		jf.setVisible(true);
		
		/** 프로그램 종료*/
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrameExam02_Flowlayout();

	}

}
