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

	/** 변수 */
	private User user = new User();
	private WeightService service = new WeightService();

	/** 싱글톤 생성 자 */
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
	 * 메소드
	 * 
	 * @param wmf
	 */
	public void loginCheck(WeigthMainFrameView wmf) {

		if (service.loginCheck(wmf)) {
			wmf.dispose();
			new ServiceFrameView();

		} else {
			JOptionPane.showMessageDialog(null, "로그인 실패");
		}

	}

	public void CreateUser() {

	}

	public void save(ServicePanelView spv) {
		service.Save(spv);

	}

}
