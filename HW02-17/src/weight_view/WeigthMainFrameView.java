package weight_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import weight_controller.WeightController;

public class WeigthMainFrameView extends JFrame implements ActionListener {

	private WeightController contrller = WeightController.getInstance();

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField pwdField;

	JButton btnLogin;
	JButton btnCreate;

	/**
	 * Create the frame.
	 */
	public WeigthMainFrameView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/** �� */
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 40, 96, 24);
		contentPane.add(lblId);

		JLabel lblPassword = new JLabel("PassWord :");
		lblPassword.setBounds(35, 80, 96, 24);
		contentPane.add(lblPassword);

		/** �ʵ� */
		idField = new JTextField();
		idField.setBounds(183, 44, 143, 24);
		contentPane.add(idField);
		idField.setColumns(10);

		pwdField = new JPasswordField();
		pwdField.setBounds(183, 82, 143, 24);
		contentPane.add(pwdField);
		pwdField.setColumns(10);

		btnLogin = new JButton("�α���");
		btnLogin.setBounds(226, 179, 97, 23);
		contentPane.add(btnLogin);

		btnCreate = new JButton("ȸ�� ����");
		btnCreate.setBounds(67, 179, 97, 23);
		contentPane.add(btnCreate);

		setTitle("������ ���� ���α׷�");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		/** ������ ��� */
		btnLogin.addActionListener(this);
		btnCreate.addActionListener(this);

	}// ������ ��

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JPasswordField getPwdField() {
		return pwdField;
	}

	public void setPwdField(JPasswordField pwdField) {
		this.pwdField = pwdField;
	}

	/** ������ */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnLogin) {

			contrller.loginCheck(this);
			/*
			 * if(idField.getText().equals("test") && new
			 * String(pwdField.getPassword()).equals("1234"))
			 * JOptionPane.showMessageDialog(null, "�α��� ����");
			 */
			
		}

		else if (e.getSource() == btnCreate) {
			new CreateUserFrameView();
		}

	}// ������ ��

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {

		new WeigthMainFrameView();
		/*
		 * String key = "aes256-test-key!!"; AES256Util aes256 = new
		 * AES256Util(key);
		 * 
		 * String text = "��ȣȭ���� ���� �����Դϴ�."; String encText =
		 * aes256.aesEncode(text); String decText = aes256.aesDecode(encText);
		 * 
		 * System.out.println("��ȣȭ�� ���� : " + text);
		 * System.out.println("��ȣȭ�� ���� : " + encText);
		 * System.out.println("��ȣȭ�� ���� : " + decText);
		 */
	}
}
