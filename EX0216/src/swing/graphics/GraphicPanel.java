package swing.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import javax.swing.JPanel;

public class GraphicPanel extends Canvas {

	int x;
	int y;

	public GraphicPanel() {
		super();
		// TODO Auto-generated constructor stub
		setBackground(Color.YELLOW);

	}

	/**
	 * Frame���� �ϸ� 0,0 ���� ����
	 * 
	 * @return
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		// super.paint(g);// ���� �������� !!!
		g.fillRect(x, y, 100, 100);
		x += 5;
		y += 5;
	}
/*
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(x, y, 100, 100);
		x += 5;
		y += 5;

	}
*/
/*	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		Graphics g = getGraphics();
		g.fillRect(x, y, 100, 100);
		x += 5;
		y += 5;
	}*/

	
	
}
