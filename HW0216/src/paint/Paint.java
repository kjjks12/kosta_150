package paint;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Paint extends JFrame {

	/** 1. 패널 */
	JPanel topP = new JPanel(new FlowLayout());
	Canvas centerC = new CsutomCanvas();

	/** 탑패널 구성 부분 */
	JTextField tfX = new JTextField("0", 5);
	JTextField tfY = new JTextField("0", 5);
	JTextField tfW = new JTextField("0", 5);
	JTextField tfH = new JTextField("0", 5);

	JRadioButton btnCircle = new JRadioButton("원");
	JRadioButton btnRect = new JRadioButton("사각형");
	ButtonGroup btnGroup = new ButtonGroup();

	JCheckBox btnFill = new JCheckBox("채우기");

	JButton btnDraw = new JButton("그리기");

	public Paint() throws HeadlessException {
		super("Paint");
		btnGroup.add(btnCircle);
		btnGroup.add(btnRect);

		topP.setBackground(Color.yellow);
		centerC.setBackground(Color.WHITE);

		/** 탑패널 에 버튼 넣기 */
		topP.add(new JLabel("X="));
		topP.add(tfX);
		topP.add(new JLabel("Y="));
		topP.add(tfY);
		topP.add(new JLabel("W="));
		topP.add(tfW);
		topP.add(new JLabel("H="));
		topP.add(tfH);

		topP.add(btnCircle);
		topP.add(btnRect);
		topP.add(btnFill);
		topP.add(btnDraw);

		Container con = getContentPane();
		con.add(topP, "North");
		con.add(centerC, "Center");

		setSize(800, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/** 리스너 구현 */
		btnDraw.addActionListener(new CustomListener());

	}// 생성자 끝

	public class CustomListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JRadioButton btnResult;

			if (e.getSource() == btnDraw) {

				int x = Integer.parseInt(tfX.getText());
				int y = Integer.parseInt(tfY.getText());
				int w = Integer.parseInt(tfW.getText());
				int h = Integer.parseInt(tfH.getText());

				Graphics g = centerC.getGraphics();

				if (btnCircle.isSelected()) {
					if (btnFill.isSelected()) {
						g.fillOval(x, y, w, h);
					} else {
						g.drawOval(x, y, w, h);
					}

				} else if (btnRect.isSelected()) {
					// g.fillRect(x, y, w, h);
					if (btnFill.isSelected()) {
						g.fillRect(x, y, w, h);
					}
					g.drawRect(x, y, w, h);

				} else {
					JOptionPane.showMessageDialog(null, "체크박스 선택해주세요!!");
				}

				/*
				 * Enumeration<AbstractButton> allRadioButton =
				 * btnGroup.getElements(); while
				 * (allRadioButton.hasMoreElements()) { JRadioButton temp =
				 * (JRadioButton) allRadioButton.nextElement(); if
				 * (temp.isSelected()) { btnResult = temp;
				 * JOptionPane.showMessageDialog(null, "You select : " +
				 * temp.getText()); } }
				 */

			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Paint();

	}

}
