package jframe_exam;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogExam extends JFrame {

	public JDialogExam() throws HeadlessException {
		super("JDialog ����");
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		//J���̾� �α� �����
		//JDialog dialog=new JDialog(this,"���̾�α� ����!!����");// ���̾�α� ����ִ� ����� �� �ڽ��̾�  (��� ���� ����)
		JDialog dialog=new JDialog(this,"���̾�α� ����!!����",true);// ���̾�α� ���� ������� ����!!!
		//dialog.setTitle("���̾�α�!!");
		JButton btn = new JButton(new ImageIcon("src/loginImg.PNG"));
		dialog.add(btn,BorderLayout.SOUTH);
		dialog.setSize(300, 200);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		setSize(680, 480);

		//setLocation((dim.width - getWidth()) / 2, (dim.height - getHeight()) / 2);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new JDialogExam();
	}

}
