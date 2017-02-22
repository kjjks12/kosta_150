package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

public class MainFrameView extends JFrame {

	private Controller controller = Controller.getInstance();
	
	private JPanel contentPane;
	private JPanel topP;


	/**
	 * Create the frame.
	 */
	public MainFrameView() {

		
		
		/** 탑 패널 user정보 */
		//topP.setLayout(new BorderLayout());
		//topP.add(new Label(controller.getUser().getName()),BorderLayout.CENTER);
		
		
		//Container con = getContentPane();
		//con.add(topP, BorderLayout.NORTH);
		
		
		setTitle("회원 정보 변경");
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
