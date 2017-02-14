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
		// setLocation(res.width/2, res.height/2);//JFRame 로케이션 위치 변경
		System.out.println(dim.getWidth() + "   " + dim.getHeight());
		this.setSize(404, 366);
		int w = (dim.width / 2) - (getWidth() / 2);
		int h = (dim.height / 2) - (getHeight() / 2);

		setLocation(w, h);

		// setBounds(w,h, 450, 300);//사이즈와 로케이션 같이주는거

		// this.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 멀티 선택 = 체크박스
		JCheckBox hobby1 = new JCheckBox("놀기");
		hobby1.setBounds(39, 30, 115, 23);
		contentPane.add(hobby1);

		JCheckBox hobby2 = new JCheckBox("먹기", true);
		hobby2.setBounds(39, 76, 115, 23);
		contentPane.add(hobby2);

		JCheckBox hobby3 = new JCheckBox("잠자기", true);
		hobby3.setBounds(39, 120, 115, 23);
		contentPane.add(hobby3);

		JRadioButton btnRadioMan = new JRadioButton("남자");
		btnRadioMan.setBounds(39, 179, 121, 23);
		contentPane.add(btnRadioMan);

		JRadioButton btnRadioWoman = new JRadioButton("여자");
		btnRadioWoman.setBounds(39, 204, 121, 23);
		contentPane.add(btnRadioWoman);

		JRadioButton btnRadioMarid = new JRadioButton("기혼");
		btnRadioMarid.setBounds(39, 251, 121, 23);
		contentPane.add(btnRadioMarid);

		JRadioButton btnRadioSingle = new JRadioButton("미혼");
		btnRadioSingle.setBounds(39, 276, 121, 23);
		contentPane.add(btnRadioSingle);

		ButtonGroup group1 = new ButtonGroup();
		group1.add(btnRadioMan);
		group1.add(btnRadioWoman);

		ButtonGroup group2 = new ButtonGroup();
		group2.add(btnRadioMarid);
		group2.add(btnRadioSingle);
		
		
		
		String arr[]=new String[]{"일요일","월요일","화요일","수요일","목요일","금요일","일요일"};
		
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
	}// 생성자 데스요!!

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
