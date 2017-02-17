package swing.graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GraphicCanvas2 extends Canvas implements MouseMotionListener {

	public GraphicCanvas2() {
		super();
		// TODO Auto-generated constructor stub
		addMouseMotionListener(this);

	}
	int x=40, y=40;

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Autxo-generated method stub
		Graphics g = getGraphics();
		//g.drawString("■", e.getX(), e.getY());
		g.fillOval(e.getX(), e.getY(), 50, 50);
		//g.drawString("마우스 따라 다니기",);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {

		//g.drawString("마우스 따라 다니기", x, y);
	}
	
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		
	}

}
