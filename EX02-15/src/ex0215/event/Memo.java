package ex0215.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Memo extends JFrame {

	JTextArea textArea = new JTextArea();

	JMenu menuFile;
	JMenu menuEdit;
	JMenu menuHelp;

	JMenuItem mntmFile;
	JMenuItem mntmSave;
	JMenuItem mntmOpen;
	JMenuItem mntmClose;

	JMenu menuSort;
	JCheckBoxMenuItem menuChkboxItemName;
	JCheckBoxMenuItem menuChkboxItemDate;

	JMenuItem mntmInfo;

	JFileChooser chooser = new JFileChooser();
	
	JDialog infoDialog;
	JButton btnDialogConfirm;
	
	public Memo() {
		super("메모장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
	

		/** 생성 */
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuFile = new JMenu("파일(F)");
		menuBar.add(menuFile);

		mntmFile = new JMenuItem("새파일");
		menuFile.add(mntmFile);

		mntmSave = new JMenuItem("저장");
		menuFile.add(mntmSave);

		mntmOpen = new JMenuItem("열기");
		menuFile.add(mntmOpen);
		
		

		/** 버튼 가운데 ------줄 */
		menuFile.addSeparator();

		mntmClose = new JMenuItem("종료");
		menuFile.add(mntmClose);

		menuEdit = new JMenu("편집");
		menuBar.add(menuEdit);

		menuSort = new JMenu("정렬");
		menuEdit.add(menuSort);

		menuChkboxItemName = new JCheckBoxMenuItem("이름");
		menuSort.add(menuChkboxItemName);

		menuChkboxItemDate = new JCheckBoxMenuItem("날짜");
		menuSort.add(menuChkboxItemDate);

		menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);

		mntmInfo = new JMenuItem("정보");
		menuHelp.add(mntmInfo);

		add(textArea, "Center");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		
	
		
		/**메뉴 단축키 */
		
		menuFile.setMnemonic('f'); //Alt + F;
		
		
		/**메뉴아이템에 단축키 */
		mntmFile.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
		mntmClose.setAccelerator(KeyStroke.getKeyStroke('E', InputEvent.CTRL_DOWN_MASK));
		
		//int타입 들어가야 해서 소문자는 안됀데!!
		
		/** 리스너 등록 */
		mntmFile.addActionListener(new CustomActionListener(this));
		mntmSave.addActionListener(new CustomActionListener(this));
		mntmOpen.addActionListener(new CustomActionListener(this));
		mntmInfo.addActionListener(new CustomActionListener(this));
		mntmClose.addActionListener(new CustomActionListener(this));

		
		
		
		/** 다이어로그 */
		
		infoDialog = new JDialog(this, "다이얼로그", true);
		infoDialog.setSize(300, 200);
		infoDialog.setLocationRelativeTo(null);
		infoDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		infoDialog.add(new JLabel("정광수", 0), "Center");
		btnDialogConfirm= new JButton("확인");
		infoDialog.add(btnDialogConfirm, "South");
		
		btnDialogConfirm.addActionListener(new DialogActionListener(this));
	
		
	}

	public static void main(String[] args) {
		new Memo();
	}

}

class CustomActionListener implements ActionListener {
	private Memo memo;

	public CustomActionListener(Memo memo) {
		this.memo = memo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == memo.mntmFile) {// 이벤트를 발생시켜주는 주체
			memo.textArea.setText(null);
		} else if (e.getSource() == memo.mntmSave) {// 이벤트를 발생시켜주는 주체
			memo.chooser.showSaveDialog(memo);
		} else if (e.getSource() == memo.mntmOpen) {
			memo.chooser.showOpenDialog(memo);
		}

		else if (e.getSource() == memo.mntmInfo) {
			memo.infoDialog.setVisible(true);
		} else if (e.getSource() == memo.mntmClose) {
			System.exit(0);
		}

	}

}

class DialogActionListener implements ActionListener {
	private Memo memo;

	public DialogActionListener(Memo memo) {
		this.memo = memo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==memo.btnDialogConfirm){
			memo.infoDialog.dispose();
		}
		
	}

}