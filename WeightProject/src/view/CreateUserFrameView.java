package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import aes.AES256Util;
import controller.Controller;
import model.UserDto;

public class CreateUserFrameView extends JFrame implements ActionListener {

	private Controller controller= Controller.getInstance();
	
	private JPanel centerP;
	private JPanel buttomP;

	private JTextField nameField = new JTextField();
	private JTextField idField = new JTextField();
	private JPasswordField pwdField = new JPasswordField();
	private JTextField weightField = new JTextField();

	private JButton btnOverlap;
	private JButton btnCreate;
	private UserDto user;
	

	/**
	 * Create the frame.
	 */
	public CreateUserFrameView() {

		setTitle("회원 가입 ");

		centerP = new JPanel();
		centerP.setLayout(null);

		JLabel labelCreate = new JLabel("회원가입");
		labelCreate.setBounds(38, 24, 236, 61);
		labelCreate.setFont(new Font("맑은고딕", Font.BOLD, 40));
		centerP.add(labelCreate);

		Label label_1 = new Label("ID : ");
		label_1.setBounds(38, 110, 60, 30);
		label_1.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		centerP.add(label_1);
		idField.setBounds(104, 110, 166, 30);
		centerP.add(idField);

		btnOverlap = new JButton("중복확인");
		btnOverlap.setBounds(300, 110, 101, 30);
		centerP.add(btnOverlap);

		Label label_2 = new Label("암호 : ");
		label_2.setBounds(38, 158, 60, 30);
		label_2.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		centerP.add(label_2);
		pwdField.setBounds(104, 158, 166, 30);
		centerP.add(pwdField);

		Label label = new Label("이름 : ");
		label.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		label.setBounds(38, 207, 60, 30);
		centerP.add(label);
		nameField.setBounds(104, 207, 166, 30);
		centerP.add(nameField);

		Label label_3 = new Label("몸무게  :");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		label_3.setBounds(38, 257, 70, 30);
		centerP.add(label_3);

		JLabel lblNewLabel = new JLabel("Kg");
		lblNewLabel.setBounds(217, 257, 51, 30);
		centerP.add(lblNewLabel);

		weightField.setBounds(104, 257, 101, 30);
		centerP.add(weightField);
		weightField.setColumns(5);

		btnCreate = new JButton("회원 가입");
		btnCreate.setBounds(374, 337, 124, 42);
		centerP.add(btnCreate);

		Container con = getContentPane();
		con.add(centerP, BorderLayout.CENTER);

		setBounds(100, 100, 600, 458);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/** 리스너 등록 */
		btnCreate.addActionListener(this);

	}// 생성 자 끝

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		saveUser();

	}

	public void saveUser() {

	/*	String id = idField.getText();
		String name = nameField.getText();
		String pwd = new String(pwdField.getPassword());
		String weight =weightField.getText();
		System.out.println(name + id + pwd);*/
		try {
			String key = "aes256-test-key!!";
			AES256Util aes = new AES256Util(key);

			user= new UserDto();
			user.setId(aes.aesEncode(idField.getText()));
			user.setName(aes.aesEncode(nameField.getText()));
			user.setPassword(aes.aesEncode(new String(pwdField.getPassword())));
			user.setWeight(weightField.getText());
			
			//String encText = aes256.aesEncode(name);
			//String decText = aes256.aesDecode(encText);
		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
	
	
}
