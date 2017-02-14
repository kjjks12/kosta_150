package jframe_exam;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class JFrameExam06_Component extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
;

	public JFrameExam06_Component() {
		super("SelectBoxExam");

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// setLocation(res.width/2, res.height/2);//JFRame �����̼� ��ġ ����
		System.out.println(dim.getWidth() + "   " + dim.getHeight());
		this.setSize(404, 366);
		int w = (dim.width / 2) - (getWidth() / 2);
		int h = (dim.height / 2) - (getHeight() / 2);

		setLocation(w, h);

		// setBounds(w,h, 450, 300);//������� �����̼� �����ִ°�

		// this.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ��Ƽ ���� = üũ�ڽ�
		JCheckBox hobby1 = new JCheckBox("���");
		hobby1.setBounds(39, 30, 115, 23);
		contentPane.add(hobby1);

		JCheckBox hobby2 = new JCheckBox("�Ա�", true);
		hobby2.setBounds(39, 76, 115, 23);
		contentPane.add(hobby2);

		JCheckBox hobby3 = new JCheckBox("���ڱ�", true);
		hobby3.setBounds(39, 120, 115, 23);
		contentPane.add(hobby3);

		JRadioButton btnRadioMan = new JRadioButton("����");
		btnRadioMan.setBounds(39, 179, 121, 23);
		contentPane.add(btnRadioMan);

		JRadioButton btnRadioWoman = new JRadioButton("����");
		btnRadioWoman.setBounds(39, 204, 121, 23);
		contentPane.add(btnRadioWoman);

		JRadioButton btnRadioMarid = new JRadioButton("��ȥ");
		btnRadioMarid.setBounds(39, 251, 121, 23);
		contentPane.add(btnRadioMarid);

		JRadioButton btnRadioSingle = new JRadioButton("��ȥ");
		btnRadioSingle.setBounds(39, 276, 121, 23);
		contentPane.add(btnRadioSingle);

		ButtonGroup group1 = new ButtonGroup();
		group1.add(btnRadioMan);
		group1.add(btnRadioWoman);

		ButtonGroup group2 = new ButtonGroup();
		group2.add(btnRadioMarid);
		group2.add(btnRadioSingle);
		
		
		
		String arr[]=new String[]{"�Ͽ���","������","ȭ����","������","�����","�ݿ���","�Ͽ���"};
		
		JList<String> list = new <String>JList(arr);
		list.setBounds(196, 179, 135, 50);
		contentPane.add(list);

		
		JComboBox<String> comboBox = new JComboBox<String>();
		for(int i=0;i<arr.length;i++){
			comboBox.addItem(arr[i]);
		}
	
		comboBox.setBounds(178, 30, 128, 23);
		contentPane.add(comboBox);
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}// ������ ������!!

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameExam06_Component frame = new JFrameExam06_Component();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
