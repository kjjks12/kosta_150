package weight_view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ServiceFrameView extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public ServiceFrameView() {

		Container con = getContentPane();
		con.add(new ServicePanelView());
		
		
		setTitle("ȸ�� ���� ����");
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
