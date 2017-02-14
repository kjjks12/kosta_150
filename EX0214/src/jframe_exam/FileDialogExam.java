package jframe_exam;

import java.awt.Container;
import java.awt.FileDialog;
import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileDialogExam extends JFrame {
	/** 1. awt */
	FileDialog save = new FileDialog(this, "�����ϱ�", FileDialog.SAVE);
	FileDialog open = new FileDialog(this, "�ҷ�����");// ����Ʈ�� ����

	/** 2. Swing */
	// �޼ҵ带 ���Ͽ� ���� �ݱ� ���Ҽ��� �־�!!
	JFileChooser filech = new JFileChooser();
	
	/**3.���� �ڵ��� */
	JColorChooser colorChooser = new JColorChooser();
	
	public FileDialogExam() throws HeadlessException {
		super("���ϴ��̾�α� �Դϴ�!!");
		/*
		 * save.setVisible(true); open.setVisible(true);
		 * System.out.println(open.getDirectory()); //������ ���
		 * System.out.println(open.getFile()); //���� �̸�
		 */
		
		filech.showOpenDialog(this);
		//System.out.println(filech.getSelectedFile()); //������ ���
		File file = filech.getSelectedFile();
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		//filech.showSaveDialog(this);
		
		
		Container con = getContentPane();
		con.add(colorChooser, "Center");
		 setSize(640, 480); setLocationRelativeTo(null); setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileDialogExam();

	}

}
