package controller;

import javax.swing.JOptionPane;

import model.UserDto;
import model.Service;
import view.MainFrameView;
import view.ServicePanelView;
import view.StartView;

public class Controller {

	/** 변수 */
	private static UserDto user;
	private Service service = new Service();

	/** 싱글톤 생성 자 */
	private static Controller instance = new Controller();

	public static Controller getInstance() {
		return instance;
	}

	private Controller() {
		
	}

	/**
	 * Getter Setter
	 */

	
	/**
	 * 메소드
	 * 
	 * @param wmf
	 */
	public void loginCheck(StartView wmf) {

		if (service.loginCheck(wmf)) {
			wmf.dispose();
			new MainFrameView();

		} else {
			JOptionPane.showMessageDialog(null, "로그인 실패");
		}

	}

	
	
	
	public static UserDto getUser() {
		return user;
	}

	public static void setUser(UserDto user) {
		Controller.user = user;
	}

	public void CreateUser() {

	}

	public void save(ServicePanelView spv) {
		service.Save(spv);

	}

}
