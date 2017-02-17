package swing.event;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardLayoutEventExam extends JFrame  implements ActionListener{

	CardLayout card = new CardLayout();
	
	JPanel centerP= new JPanel(card);
	
	JPanel southP= new JPanel();
	JButton pre= new JButton("이전");
	JButton next= new JButton("다음");
	
	//centerP 영역에 올려질 화면 (JPanel)
	JPanel redP= new JPanel();
	JPanel greenP= new JPanel();
	JPanel blueP= new JPanel();
	
	public CardLayoutEventExam() throws HeadlessException {
		super("카드레이아웃 연습");
		
		southP.add(pre);
		southP.add(next);
		
		redP.setBackground(Color.red);
		greenP.setBackground(Color.GREEN);
		blueP.setBackground(Color.BLUE);
		
		
		
		/**카드 레이아웃 제한자 = 별명(Alias)가 있어야 한대!! */
		centerP.add(redP, "r");
		centerP.add(greenP, "g");
		centerP.add(blueP, "b");
	
		//처음 보여질 화면 지정!!
		//card.show(centerP, "b");
		
		
		//패널 추가 
		Container con = getContentPane();
		con.add(centerP, "Center");
		con.add(southP, "South");
		
		
		GraphicsEnvironment ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd=ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(this);
	
		setVisible(true);
	
		
		/**버튼 리스너 등록 */
		pre.addActionListener(this);
		next.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==next){
			card.next(centerP);
			
		}
		else if(e.getSource()==pre){
			card.previous(centerP);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new CardLayoutEventExam();
	}

}
