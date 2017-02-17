package swing.graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GraphicCanvas extends Canvas implements MouseMotionListener {

	int x=40, y=40;
	
	public GraphicCanvas() {
		super();
		// TODO Auto-generated constructor stub
		addMouseMotionListener(this);

	}


	@Override
	public void mouseDragged(MouseEvent e) {
		x= e.getX();
		y= e.getY();
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {
		
		g.drawString("마우스 따라 다니기", x, y);
	}

}
