package hw2014;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 02-14
 * 정광수
 * 계산기  GUI
 */

public class CalculatorStyleExam extends JFrame {
private JButton btnPlus= new JButton("+");
private JButton btnMinus= new JButton("-");
private JButton btnMul= new JButton("*");
private JButton btnDiv= new JButton("/");
private JButton btnEqual= new JButton("=");
private JButton btnNumArr[]= new JButton[10];
	
	
	public CalculatorStyleExam() throws HeadlessException {
		super("CalculatorStyleExam");
	
		
		JTextField resultField = new JTextField("0.0");

		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new GridLayout(1,0));
		resultPanel.add(resultField);

		JPanel calPanel = new JPanel();
		calPanel.setLayout(new GridLayout(3, 5));
		calPanel.add(btnPlus);
		calPanel.add(btnMinus);
		calPanel.add(btnMul);
		calPanel.add(btnDiv);
		calPanel.add(btnEqual);
		
		for(int i=0;i<btnNumArr.length;i++){
			btnNumArr[i]=new JButton((i+1+""));
			calPanel.add(btnNumArr[i]);
		}
		Container con = getContentPane();
		con.add(resultPanel, BorderLayout.NORTH);
		con.add(calPanel, BorderLayout.CENTER);

		setSize(360, 280);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new CalculatorStyleExam();
	}

}
