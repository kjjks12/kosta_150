package weight_controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import weight_model.User;
import weight_service.WeightService;
import weight_view.ServiceFrameView;
import weight_view.ServicePanelView;
import weight_view.WeigthMainFrameView;

public class WeightController {

	/** ���� */
	private User user = new User();
	private WeightService service = new WeightService();

	/** �̱��� ���� �� */
	private static WeightController instance = new WeightController();

	public static WeightController getInstance() {
		return instance;
	}

	private WeightController() {
	}

	/**
	 * Getter Setter
	 */

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * �޼ҵ�
	 * 
	 * @param wmf
	 */
	public void loginCheck(WeigthMainFrameView wmf) {

		if (service.loginCheck(wmf)) {
			wmf.dispose();
			new ServiceFrameView();

		} else {
			JOptionPane.showMessageDialog(null, "�α��� ����");
		}

	}

	public void CreateUser() {

	}

	public void save(ServicePanelView spv) {
		service.Save(spv);

	}

}
