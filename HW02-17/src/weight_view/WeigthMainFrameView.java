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

		/** 라벨 */
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 40, 96, 24);
		contentPane.add(lblId);

		JLabel lblPassword = new JLabel("PassWord :");
		lblPassword.setBounds(35, 80, 96, 24);
		contentPane.add(lblPassword);

		/** 필드 */
		idField = new JTextField();
		idField.setBounds(183, 44, 143, 24);
		contentPane.add(idField);
		idField.setColumns(10);

		pwdField = new JPasswordField();
		pwdField.setBounds(183, 82, 143, 24);
		contentPane.add(pwdField);
		pwdField.setColumns(10);

		btnLogin = new JButton("로그인");
		btnLogin.setBounds(226, 179, 97, 23);
		contentPane.add(btnLogin);

		btnCreate = new JButton("회원 가입");
		btnCreate.setBounds(67, 179, 97, 23);
		contentPane.add(btnCreate);

		setTitle("몸무게 관리 프로그램");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		/** 리스너 등록 */
		btnLogin.addActionListener(this);
		btnCreate.addActionListener(this);

	}// 생성자 끝

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

	/** 리스너 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnLogin) {

			contrller.loginCheck(this);
			/*
			 * if(idField.getText().equals("test") && new
			 * String(pwdField.getPassword()).equals("1234"))
			 * JOptionPane.showMessageDialog(null, "로그인 성공");
			 */
			
		}

		else if (e.getSource() == btnCreate) {
			new CreateUserFrameView();
		}

	}// 리스너 끝

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {

		new WeigthMainFrameView();
		/*
		 * String key = "aes256-test-key!!"; AES256Util aes256 = new
		 * AES256Util(key);
		 * 
		 * String text = "암호화되지 않은 문자입니다."; String encText =
		 * aes256.aesEncode(text); String decText = aes256.aesDecode(encText);
		 * 
		 * System.out.println("암호화할 문자 : " + text);
		 * System.out.println("암호화된 문자 : " + encText);
		 * System.out.println("복호화된 문자 : " + decText);
		 */
	}
}
