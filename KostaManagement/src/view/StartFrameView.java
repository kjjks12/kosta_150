package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class StartFrameView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField pwdField;
	private JButton btnLogin = new JButton("Login");;

	/**
	 * Create the frame.
	 */
	public StartFrameView() {
		super("KOSTA ManageMent");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("KOSTA ManageMent ", JLabel.CENTER);
		lblId.setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 30));
		lblId.setBounds(51, 34, 334, 41);
		contentPane.add(lblId);

		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setBounds(68, 100, 76, 22);
		contentPane.add(lblId_1);

		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setBounds(68, 143, 81, 22);
		contentPane.add(lblPassword);

		idField = new JTextField();
		idField.setBounds(156, 101, 116, 21);
		contentPane.add(idField);
		idField.setColumns(10);

		pwdField = new JPasswordField();
		pwdField.setBounds(156, 144, 116, 21);
		contentPane.add(pwdField);
		pwdField.setColumns(10);

		btnLogin.setBounds(260, 207, 97, 23);
		contentPane.add(btnLogin);

		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/** ¸®½º³Ê */

		btnLogin.addActionListener(this);

	}// »ý¼ºÀÚ

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogin) {
			if (idField.getText().equals("test") && new String(pwdField.getPassword()).equals("1234")) {
				JOptionPane.showMessageDialog(null, "ÀåÈñÁ¤´Ô ¹Ý°©½À´Ï´Ù");
				new MainMenuView();
				this.dispose();
			} 
			else {
				JOptionPane.showMessageDialog(null, "·Î±×ÀÎ ½ÇÆÐ");
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		StartFrameView frame = new StartFrameView();

	}
}
