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
	private JPasswordField pwdField = new JPasswordField("��û��");
	private JTextArea textArea = new JTextArea("������ �����??");

	private JPanel idPwdPanel = new JPanel();
	private JPanel idPwdLablePanel = new JPanel();
	private JPanel idPwdTextFieldPanel = new JPanel();
	private JScrollPane scrollPanel= new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	public JFrameExam_Login() {
		super("���� �г� ����");

		/**��Ÿ���*/
		textArea.setLineWrap(true);//ȭ��ȿ� �� ���� �ڵ� �ٹٲ�
		pwdField.setEchoChar('*');//��й�ȣ ��缳��
		
		//idField.setEnabled(false);//id�� �ƿ� ĥ�� ���� �����
		//pwdField.setEditable(false);//���� �Ұ���
		
		
		/** text �ڽ��� �ִ� ������ �������� */
		String idValue=idField.getText();
		char []  passValue = pwdField.getPassword();
		//System.out.println(pwdField.getPassword());
		String textAreaValue= textArea.getText();
		
		/** Text �ڽ��� ������ TextArea�� ���!!! */
		//1��°(textArea�� �̰� ������ �־�)
		textArea.append("���̵� :"+idValue+"\n");
		textArea.append("��� : "+new String(passValue)+"\n");
		textArea.append("���� :"+textAreaValue+"\n");
		
		//2��°
		textArea.setText("������ Append �� ����� ����������!!");
		
		
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
