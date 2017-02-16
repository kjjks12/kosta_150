package joke;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

/**
 * �г� ����� Ȯ���ϱ� ���ؼ� ���
 */
public class CustomJPanel extends JPanel {

	Toolkit tk = getToolkit();
	Dimension dim = tk.getScreenSize();

	URL imageUrl=getClass().getClassLoader().getResource("example.jpg");
	//getClass.getClassLoader() Ŭ������ ���� ���� ���� ��������
	//�ű⿡ �ִ� �ڿ��� �������ڴ�
	
//	Image img = tk.getImage("resource/example.jpg");// �̹������� ��Ҿ�
	Image img = tk.getImage(imageUrl);// �̹������� ��Ҿ�

	public CustomJPanel() {
		
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, (int)dim.getWidth(),(int)dim.getHeight(), this);
	}

}
