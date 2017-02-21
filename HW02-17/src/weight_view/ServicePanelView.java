package weight_view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import weight_controller.WeightController;
import javax.swing.JButton;

public class ServicePanelView extends JPanel implements ActionListener{

	WeightController controller = WeightController.getInstance();

	JPanel topP = new JPanel();
	JPanel centerP = new JPanel();
	JPanel centerLabelP= new JPanel(new GridLayout(2, 1));
	JPanel centerTextFieldP= new JPanel();
	private JTextField weightField;
	private JPasswordField pwdField;
	
	private JButton btnChange;

	public ServicePanelView() {
		/** 기본 패널 변경 */
		setLayout(new BorderLayout());
		
		/** 탑 패널 설정  (라벨류)*/
		topP.setLayout(new GridLayout(2, 1));
		JLabel infoLabel = new JLabel("ID :" + controller.getUser().getId());
		infoLabel.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		topP.add(infoLabel, BorderLayout.NORTH);

		JLabel userChangeInfoLabel = new JLabel("회원 정보 변경");
		userChangeInfoLabel.setFont(new Font("맑은고딕", Font.PLAIN, 30));
		topP.add(userChangeInfoLabel, BorderLayout.SOUTH);
		
		add(topP, BorderLayout.NORTH);
		
	
		
		centerP.setLayout(null);
		
		JLabel pwdLabel = new JLabel("Password :");
		pwdLabel.setBounds(30, 39, 107, 26);
		centerP.add(pwdLabel);
		
		JLabel weightLabel = new JLabel("Weight :");
		weightLabel.setBounds(30, 91, 112, 26);
		centerP.add(weightLabel);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(149, 39, 122, 26);
		centerP.add(pwdField);
		pwdField.setColumns(10);
		
		weightField = new JTextField();
		weightField.setText(controller.getUser().getWeight());
		weightField.setBounds(148, 92, 122, 26);
		centerP.add(weightField);
		weightField.setColumns(10);
		
		btnChange = new JButton("변경하기");
		btnChange.setBounds(294, 204, 128, 32);
		centerP.add(btnChange);
		
		add(centerP);
		
		
		/** 리스너 등록 */
		btnChange.addActionListener(this);
	}

	
	/** Getter Setter*/
	public JTextField getWeightField() {
		return weightField;
	}


	public void setWeightField(JTextField weightField) {
		this.weightField = weightField;
	}


	public JPasswordField getPwdField() {
		return pwdField;
	}


	public void setPwdField(JPasswordField pwdField) {
		this.pwdField = pwdField;
	}
	
	
	
	/** 리스너 */
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnChange){
			controller.save(this);
			
			
		}
	}



	
}
