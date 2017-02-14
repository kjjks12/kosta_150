package jframe_exam;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JFrameExam_Login extends JFrame {

	private JTextField idField = new JTextField("kjjks12");
	private JPasswordField pwdField = new JPasswordField("멍청아");
	private JTextArea textArea = new JTextArea("내용이 뭘까용??");

	private JPanel idPwdPanel = new JPanel();
	private JPanel idPwdLablePanel = new JPanel();
	private JPanel idPwdTextFieldPanel = new JPanel();
	private JScrollPane scrollPanel= new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	public JFrameExam_Login() {
		super("복합 패널 구성");

		/**기타기능*/
		textArea.setLineWrap(true);//화면안에 다 차면 자동 줄바꿈
		pwdField.setEchoChar('*');//비밀번호 모양설정
		
		//idField.setEnabled(false);//id쪽 아예 칠수 없게 만들어
		//pwdField.setEditable(false);//수정 불가능
		
		
		/** text 박스에 있는 데이터 가져오기 */
		String idValue=idField.getText();
		char []  passValue = pwdField.getPassword();
		//System.out.println(pwdField.getPassword());
		String textAreaValue= textArea.getText();
		
		/** Text 박스의 값들을 TextArea에 출력!!! */
		//1번째(textArea만 이걸 가지구 있어)
		textArea.append("아이디 :"+idValue+"\n");
		textArea.append("비번 : "+new String(passValue)+"\n");
		textArea.append("내용 :"+textAreaValue+"\n");
		
		//2번째
		textArea.setText("기존꺼 Append 다 지우고 덮어써버린데!!");
		
		
		JLabel idLable = new JLabel("ID :");
		JLabel pwdLable = new JLabel("Password :");

		idPwdPanel.setLayout(new BorderLayout());

		idPwdLablePanel.setLayout(new GridLayout(2, 1));
		idPwdLablePanel.add(idLable);
		idPwdLablePanel.add(pwdLable);

		idPwdTextFieldPanel.setLayout(new GridLayout(2, 1));
		idPwdTextFieldPanel.add(idField);
		idPwdTextFieldPanel.add(pwdField);

		idPwdPanel.add(idPwdLablePanel, BorderLayout.WEST);
		idPwdPanel.add(idPwdTextFieldPanel, BorderLayout.CENTER);

		Container container = getContentPane();
		container.add(idPwdPanel, BorderLayout.NORTH);
		container.add(scrollPanel, BorderLayout.CENTER);

		setSize(480, 680);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new JFrameExam_Login();
	}

}
