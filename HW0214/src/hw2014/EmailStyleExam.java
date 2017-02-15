package hw2014;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/**
 * 02-14
 * ������
 * �̸���  GUI
 */
public class EmailStyleExam extends JFrame {

	private JButton btnUpSend = new JButton("������");
	private JButton btnUpRewrite = new JButton("�ٽþ���");
	private JButton btnDownSend = new JButton("������");
	private JButton btnDownReWrite = new JButton("�ٽþ���");
	private JButton btnSearch = new JButton("ã��");

	private TextArea textArea = new TextArea();

	public EmailStyleExam() throws HeadlessException {
		super("EmailStyleExam");

		JLabel sendPersonLable = new JLabel("������ ���");
		JLabel getPersonLable = new JLabel("�޴� ���");
		JLabel titleLable = new JLabel("���� ");

		JLabel attachLable = new JLabel("÷������");
		
		

		JTextField sendTextField = new JTextField();
		JTextField getTextField = new JTextField();
		JTextField titleTextField = new JTextField();

		JTextField attachTextField = new JTextField();

		JPanel upPanel = new JPanel();
		upPanel.setLayout(new BorderLayout());

		JPanel lablePanel = new JPanel();
		lablePanel.setLayout(new GridLayout(3, 1));
		lablePanel.add(sendPersonLable);
		lablePanel.add(getPersonLable);
		lablePanel.add(titleLable);

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(3, 1));
		fieldPanel.add(sendTextField);
		fieldPanel.add(getTextField);
		fieldPanel.add(titleTextField);

		
		upPanel.add(lablePanel,BorderLayout.WEST);
		upPanel.add(fieldPanel,BorderLayout.CENTER);
		
		// Center�κ�

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		
		
		JPanel centerTopPanel = new JPanel();
		centerTopPanel.add(btnUpSend);
		centerTopPanel.add(btnUpRewrite);
		
		
		JPanel centerButtomPanel = new JPanel();
		centerButtomPanel.setLayout(new BorderLayout());
		centerButtomPanel.add(attachLable,BorderLayout.WEST);
		centerButtomPanel.add(attachTextField,BorderLayout.CENTER);
		centerButtomPanel.add(btnSearch,BorderLayout.EAST);
		
		
		JScrollPane Scrollpanel = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		centerPanel.add(centerTopPanel,BorderLayout.NORTH);
		centerPanel.add(Scrollpanel,BorderLayout.CENTER);
		centerPanel.add(centerButtomPanel,BorderLayout.SOUTH);
		
		JPanel buttomPanel = new JPanel();
		buttomPanel.setLayout(new FlowLayout());
		buttomPanel.add(btnDownSend);
		buttomPanel.add(btnDownReWrite);
		
		
		Container con = getContentPane();
		con.add(upPanel, "North");
		con.add(centerPanel, "Center");
		con.add(buttomPanel,"South");
		

		setSize(320, 360);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EmailStyleExam();
	}

}
