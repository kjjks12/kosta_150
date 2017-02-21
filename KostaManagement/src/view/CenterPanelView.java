package view;

import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JLabel;

public class CenterPanelView extends JPanel {

	/**
	 * Create the panel.
	 */
	public CenterPanelView() {
		setLayout(null);
		
		JLabel cleanLbel = new JLabel("ø¿¥√¿« ¡∂");
		cleanLbel.setFont(new Font("∏º¿∫∞ÌµÒ", Font.PLAIN, 20));
		cleanLbel.setBounds(19, 38, 117, 26);
		add(cleanLbel);

	}

}
