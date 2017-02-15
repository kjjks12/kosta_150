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
		super("�޸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
	

		/** ���� */
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuFile = new JMenu("����(F)");
		menuBar.add(menuFile);

		mntmFile = new JMenuItem("������");
		menuFile.add(mntmFile);

		mntmSave = new JMenuItem("����");
		menuFile.add(mntmSave);

		mntmOpen = new JMenuItem("����");
		menuFile.add(mntmOpen);
		
		

		/** ��ư ��� ------�� */
		menuFile.addSeparator();

		mntmClose = new JMenuItem("����");
		menuFile.add(mntmClose);

		menuEdit = new JMenu("����");
		menuBar.add(menuEdit);

		menuSort = new JMenu("����");
		menuEdit.add(menuSort);

		menuChkboxItemName = new JCheckBoxMenuItem("�̸�");
		menuSort.add(menuChkboxItemName);

		menuChkboxItemDate = new JCheckBoxMenuItem("��¥");
		menuSort.add(menuChkboxItemDate);

		menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);

		mntmInfo = new JMenuItem("����");
		menuHelp.add(mntmInfo);

		add(textArea, "Center");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		
	
		
		/**�޴� ����Ű */
		
		menuFile.setMnemonic('f'); //Alt + F;
		
		
		/**�޴������ۿ� ����Ű */
		mntmFile.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
		mntmClose.setAccelerator(KeyStroke.getKeyStroke('E', InputEvent.CTRL_DOWN_MASK));
		
		//intŸ�� ���� �ؼ� �ҹ��ڴ� �ȉµ�!!
		
		/** ������ ��� */
		mntmFile.addActionListener(new CustomActionListener(this));
		mntmSave.addActionListener(new CustomActionListener(this));
		mntmOpen.addActionListener(new CustomActionListener(this));
		mntmInfo.addActionListener(new CustomActionListener(this));
		mntmClose.addActionListener(new CustomActionListener(this));

		
		
		
		/** ���̾�α� */
		
		infoDialog = new JDialog(this, "���̾�α�", true);
		infoDialog.setSize(300, 200);
		infoDialog.setLocationRelativeTo(null);
		infoDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		infoDialog.add(new JLabel("������", 0), "Center");
		btnDialogConfirm= new JButton("Ȯ��");
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
		if (e.getSource() == memo.mntmFile) {// �̺�Ʈ�� �߻������ִ� ��ü
			memo.textArea.setText(null);
		} else if (e.getSource() == memo.mntmSave) {// �̺�Ʈ�� �߻������ִ� ��ü
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