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
	private JLabel lable = new JLabel("����ð�");

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

		/** �ð� ���� */
		/**
		 * Calendar �� �߻�(abstract) class���� �ٷ� ����� ���� ����. GregorianCalendar class
		 * �� Calendar�� ��ӹ޾Ƽ� Calendar�� method�� �����ϰ��ִ�. Calendar �� ����ϱ����ؼ� �켱 �Ʒ���
		 * ���� Calendar�� �����Ѵ�
		 * 
		 * Calendar cal= Calendar.getInstance(); //���������� GregorianCalendar()��
		 * ȣ���Ѵ� �Ǵ� Calendar cal = new GregorianCalendar();
		 */
		
		
		Thread th = new Thread(){
			public void run() {
				while (true) {
					Calendar today = Calendar.getInstance();// ���� ��¥ �ð������� ������
					int year=today.get(Calendar.YEAR);
					int month= today.get(Calendar.MONTH);
					int date= today.get(Calendar.DATE);
					int hour= today.get(Calendar.HOUR);
					int minute= today.get(Calendar.MINUTE);
					int second= today.get(Calendar.SECOND);
				
					StringBuilder sb= new StringBuilder();
					sb.append(year+"��");
					sb.append(month+"��");
					sb.append(date+"��");
					sb.append(hour+"��");
					sb.append(minute+"��");
					sb.append(second+"��");
					
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
