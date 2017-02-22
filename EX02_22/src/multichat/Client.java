package multichat;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame {

	JTextArea textArea = new JTextArea();
	JScrollPane jsp = new JScrollPane(textArea);

	JTextField text = new JTextField();

	Socket sk;
	PrintWriter pw;
	BufferedReader br;

	public Client() {
		super("ä�� ���α׷�");

		Container con = getContentPane();
		con.add(jsp, "Center");
		con.add(text, "South");

		/** �ɼ� ���� */
		textArea.setFocusable(false);
		textArea.setBackground(Color.MAGENTA);
		text.requestFocus();// Ŀ�� �ؽ�Ʈ �ʵ�� ����

		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/** �������� �޼ҵ� ���� ������ */
		serverConnection();
		
		/**���� ������ ä�� �������� ������ ���� 
		 * (�͸�)�� �̳� Ŭ����
		 * */
		
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/**�ؽ�Ʈ ���� �о �������� ������ */
				pw.println(text.getText());
				
				/**�ؽ�Ʈ ������ ����� */
				text.setText("");
			}
		} );
	}

	/** ���� ���� */
	public void serverConnection() {
		try {
			/**�⺻ ���� 127.0.0.1 */
			 sk = new Socket("192.168.0.27", 8000);
			String name=JOptionPane.showInputDialog(this, "��ȭ��", "��ȭ�� �Է�", JOptionPane.QUESTION_MESSAGE);
			pw = new PrintWriter(sk.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
	
			pw.println(name);//��ȭ�� ����
			
			/** �޴� ������ */
			new Thread(){
				public void run() {
					try {
						String data="";
						while((data=br.readLine())!=null){
							textArea.append(data+"\n");
							
							
							/**��ũ�ѹ��� ��ġ�� �̵�*/
							int len = textArea.getText().length();
							textArea.setCaretPosition(len);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				};
			}.start();
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Client();
	}
}
