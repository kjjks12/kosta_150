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
	FileDialog save = new FileDialog(this, "저장하기", FileDialog.SAVE);
	FileDialog open = new FileDialog(this, "불러오기");// 디폴트가 열기

	/** 2. Swing */
	// 메소드를 통하여 열기 닫기 정할수가 있어!!
	JFileChooser filech = new JFileChooser();
	
	/**3.색상 코드집 */
	JColorChooser colorChooser = new JColorChooser();
	
	public FileDialogExam() throws HeadlessException {
		super("파일다이얼로그 입니다!!");
		/*
		 * save.setVisible(true); open.setVisible(true);
		 * System.out.println(open.getDirectory()); //선택한 경로
		 * System.out.println(open.getFile()); //파일 이름
		 */
		
		filech.showOpenDialog(this);
		//System.out.println(filech.getSelectedFile()); //선택한 경로
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
