package joke;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

/**
 * 패널 기능을 확장하기 위해서 사용
 */
public class CustomJPanel extends JPanel {

	Toolkit tk = getToolkit();
	Dimension dim = tk.getScreenSize();

	URL imageUrl=getClass().getClassLoader().getResource("example.jpg");
	//getClass.getClassLoader() 클래스에 관한 현재 정보 가져오구
	//거기에 있는 자원을 가져오겠다
	
//	Image img = tk.getImage("resource/example.jpg");// 이미지까지 담았어
	Image img = tk.getImage(imageUrl);// 이미지까지 담았어

	public CustomJPanel() {
		
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, (int)dim.getWidth(),(int)dim.getHeight(), this);
	}

}
