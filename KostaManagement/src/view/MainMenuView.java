package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.StudentManageMent;

public class MainMenuView extends JFrame {
	JPanel panel = new JPanel();
	JTextField tf = new JTextField(10);
	JComboBox<String> cb = new JComboBox<>(); // 불참자 리스트
	JRadioButton ra1 = new JRadioButton("청소 조");
	JRadioButton ra2 = new JRadioButton("팀플 조");
	JRadioButton ra3 = new JRadioButton("밥 조");
	ButtonGroup group = new ButtonGroup();
	JLabel la2 = new JLabel("불참자");
	JLabel la = new JLabel("인원수");

	JComboBox<String> cb2 = new JComboBox<>(); // 인원수
	JButton btn = new JButton("조 짜기");
	JTextArea ta = new JTextArea();
	int team = 1;

	public MainMenuView() {
		super("조 정하기");

		panel.add(la2);
		panel.add(tf);
		panel.setBackground(Color.cyan);
		cb.addItem(" ");
		panel.add(cb);
		group.add(ra1);
		group.add(ra2);
		group.add(ra3);
		panel.add(ra1);
		panel.add(ra2);
		panel.add(ra3);
		panel.add(la);
		panel.add(cb2);
		cb2.addItem("3");
		cb2.addItem("4");
		cb2.addItem("5");
		cb2.addItem("6");
		panel.add(btn);
		add(panel, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);

		btn.addActionListener(new ActionListener() {
			int count = 1;

			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				if (ra1.isSelected()) {
					ta.append("청소조");
				} else if (ra2.isSelected()) {
					ta.append("팀플조");
				} else if (ra3.isSelected()) {
					ta.append("밥 조");
				}
				count = 1;
				int num = cb2.getSelectedIndex();
				StudentManageMent practice = new StudentManageMent(num);
				for (int i = 0; i < practice.arr.size(); i++) {
					if (i % (num + 3) == 0) {
						ta.append("\n");
						ta.append(count + "조 : ");
						count++;
					}

					ta.append(practice.arr.get(i).getName() + " ");

				}

			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);

		/** 리스너 */
		tf.addKeyListener(new MyKeyListener());

	}

	public class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_ENTER){
				if(tf.getText().equals("")){
					JOptionPane.showMessageDialog(null,"이름을 입력해주세요");
				}
				else{
					int num = cb2.getSelectedIndex();
					StudentManageMent practice = new StudentManageMent(num);
					for(int i=0;i<practice.arr.size();i++){
						
						if(practice.arr.get(i).getName().equals(tf.getText())==true){
							cb.addItem(tf.getText());
						}
						else{
							JOptionPane.showMessageDialog(null,"입력하신 이름은 없습니다");
							break;
						}
					}
					
				}
				
				
				
			}
			
		}
	}
}
