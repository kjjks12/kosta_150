package thread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clock extends JFrame  {

	private Calendar cal = Calendar.getInstance();
	private JLabel lable = new JLabel("현재시간");

	public Clock() throws HeadlessException {
		super();

		JPanel upP = new JPanel(new BorderLayout());
		upP.add(lable);
		Container con = getContentPane();
		con.add(lable, BorderLayout.NORTH);


		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/** 시계 쓰기 */
		/**
		 * Calendar 는 추상(abstract) class여서 바로 사용할 수는 없다. GregorianCalendar class
		 * 가 Calendar를 상속받아서 Calendar의 method를 구현하고있다. Calendar 를 사용하기위해서 우선 아래와
		 * 같이 Calendar를 선언한다
		 * 
		 * Calendar cal= Calendar.getInstance(); //내부적으로 GregorianCalendar()를
		 * 호출한다 또는 Calendar cal = new GregorianCalendar();
		 */
		
		
		Thread th = new Thread(){
			public void run() {
				while (true) {
					Calendar today = Calendar.getInstance();// 현재 날짜 시간정보를 가져와
					int year=today.get(Calendar.YEAR);
					int month= today.get(Calendar.MONTH);
					int date= today.get(Calendar.DATE);
					int hour= today.get(Calendar.HOUR);
					int minute= today.get(Calendar.MINUTE);
					int second= today.get(Calendar.SECOND);
				
					StringBuilder sb= new StringBuilder();
					sb.append(year+"년");
					sb.append(month+"월");
					sb.append(date+"일");
					sb.append(hour+"시");
					sb.append(minute+"분");
					sb.append(second+"초");
					
					setTitle(sb.toString());
					lable.setText(sb.toString());
					try{
						Thread.sleep(1000);
						
					}catch (Exception e) {
					e.printStackTrace();
					}
				}
			}
		
		
		};
			
		
		th.setDaemon(true);
		th.start();

		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Clock();
	}

}
