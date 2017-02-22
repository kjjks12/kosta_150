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
		super("채팅 프로그램");

		Container con = getContentPane();
		con.add(jsp, "Center");
		con.add(text, "South");

		/** 옵션 설정 */
		textArea.setFocusable(false);
		textArea.setBackground(Color.MAGENTA);
		text.requestFocus();// 커서 텍스트 필드로 놓게

		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/** 서버접속 메소드 따로 빼놨어 */
		serverConnection();
		
		/**엔터 누를면 채팅 보내지게 리스너 구현 
		 * (익명)의 이너 클래스
		 * */
		
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/**텍스트 값을 읽어서 서버에게 보낸다 */
				pw.println(text.getText());
				
				/**텍스트 영역을 지운다 */
				text.setText("");
			}
		} );
	}

	/** 서버 접속 */
	public void serverConnection() {
		try {
			/**기본 서버 127.0.0.1 */
			 sk = new Socket("192.168.0.27", 8000);
			String name=JOptionPane.showInputDialog(this, "대화명", "대화명 입력", JOptionPane.QUESTION_MESSAGE);
			pw = new PrintWriter(sk.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
	
			pw.println(name);//대화명 전송
			
			/** 받는 스레드 */
			new Thread(){
				public void run() {
					try {
						String data="";
						while((data=br.readLine())!=null){
							textArea.append(data+"\n");
							
							
							/**스크롤바의 위치를 이동*/
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
