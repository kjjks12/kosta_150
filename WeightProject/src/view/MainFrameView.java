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

		
		
		/** ž �г� user���� */
		//topP.setLayout(new BorderLayout());
		//topP.add(new Label(controller.getUser().getName()),BorderLayout.CENTER);
		
		
		//Container con = getContentPane();
		//con.add(topP, BorderLayout.NORTH);
		
		
		setTitle("ȸ�� ���� ����");
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
