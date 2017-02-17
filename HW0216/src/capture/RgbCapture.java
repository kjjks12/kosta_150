package capture;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class RgbCapture extends JFrame  {

	/** �г� ���� */
	JPanel leftP = new JPanel(new GridLayout(3, 2));
	JPanel rightP = new JPanel(new GridLayout(3, 1));
	JPanel downP = new JPanel(new FlowLayout());
	Canvas canvas = new Canvas();

	/** ���� */
	JTextField tfR = new JTextField("0", 3);
	JTextField tfG = new JTextField("0", 3);
	JTextField tfB = new JTextField("0", 3);
	JScrollBar sbR = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 256);
	JScrollBar sbG = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 256);
	JScrollBar sbB = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 256);

	int r, g, b;

	public RgbCapture() throws HeadlessException {
		super("ColorPicker");

		/** ���� �г� */
		leftP.add(new JLabel("Red ="));
		leftP.add(tfR);
		leftP.add(new JLabel("Green ="));
		leftP.add(tfG);
		leftP.add(new JLabel("Blue ="));
		leftP.add(tfB);

		/** ������ �г� */

		rightP.add(sbR);
		rightP.add(sbG);
		rightP.add(sbB);

		/** �Ʒ��� �г� */
		canvas.setSize(100, 100);
		downP.add(canvas);
		/** ��ü �ֱ� */
		Container con = getContentPane();
		con.add(leftP, BorderLayout.WEST);
		con.add(rightP, BorderLayout.CENTER);
		con.add(downP, BorderLayout.SOUTH);

		setSize(800, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/** ������ */
		sbR.addAdjustmentListener(new CustomListener());
		sbG.addAdjustmentListener(new CustomListener());
		sbB.addAdjustmentListener(new CustomListener());

	}

	/**
	 * ��� 1 implement �� ���� �����ʿ� this�� �ҷ�����!!
	 * 
	 */
	/*
	 * @Override public void adjustmentValueChanged(AdjustmentEvent e) { // TODO
	 * Auto-generated method stub
	 * 
	 * if (e.getSource() == sbR) { r = e.getValue(); tfR.setBackground(new
	 * Color(r, 0, 0)); tfR.setText(r + ""); } else if (e.getSource() == sbG) {
	 * g = e.getValue(); tfG.setBackground(new Color(0, g, 0)); tfG.setText(g +
	 * ""); } else if (e.getSource() == sbB) { b = e.getValue();
	 * tfB.setBackground(new Color(0, 0, b)); tfB.setText(b + ""); }
	 * 
	 * canvas.setBackground(new Color(r, g, b));
	 * 
	 * }
	 */

	public class CustomListener implements AdjustmentListener {

		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == sbR) {
				r = e.getValue();
				tfR.setBackground(new Color(r, 0, 0));
				tfR.setText(r + "");
			} else if (e.getSource() == sbG) {
				g = e.getValue();
				tfG.setBackground(new Color(0, g, 0));
				tfG.setText(g + "");
			} else if (e.getSource() == sbB) {
				b = e.getValue();
				tfB.setBackground(new Color(0, 0, b));
				tfB.setText(b + "");
			}

			canvas.setBackground(new Color(r, g, b));

		}
	}

	public static void main(String[] args) {

		new RgbCapture();
	}
}
