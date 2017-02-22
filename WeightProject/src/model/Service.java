package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import controller.Controller;
import view.ServicePanelView;
import view.StartView;

public class Service {


	private BufferedReader br;
	private BufferedWriter bw;

	public Service() {
		
	}

	public boolean loginCheck(StartView wmf) {
		UserDto user = null;
		try {
			br = new BufferedReader(new FileReader("src/resource/data"));
			String str;
			while ((str = br.readLine()) != null) {
				String[] dataArr = str.split(",");
				String id = dataArr[0];
				String pwd = dataArr[1];
				String name = dataArr[2];
				String weight = dataArr[3];

				/*
				 * user = new User(id, name, pwd, weight);
				 * System.out.println(user);
				 */
				// System.out.println(wmf.getIdField());
				// System.out.println(wmf.getPwdField());

				if (id.equals(wmf.getIdField().getText()) && pwd.equals(new String(wmf.getPwdField().getPassword()))) {
					user = new UserDto(id, pwd, name, weight);
					System.out.println("service"+user);
					
					//System.out.println("controller : "+controller);
					Controller.setUser(user);
					
					return true;
				}
			}

		} catch (IOException e) {
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
		return false;
	}

	public void Save(ServicePanelView spv) {

		UserDto user = Controller.getUser();
		System.out.println(user);
/*
		user.setPassword(new String(spv.getPwdField().getPassword()));
		user.setWeight(spv.getWeightField().getText());
		try {
			br = new BufferedReader(new FileReader("src/resource/data"));
			bw = new BufferedWriter(new FileWriter("src/resource/data"));
			String str;

			while ((str = br.readLine()) != null) {
				String[] dataArr = str.split(",");
				String id = dataArr[0];
				String pwd = dataArr[1];
				String name = dataArr[2];
				String weight = dataArr[3];
				if (user.getId().equals(id)) {

					// String resultStr=
					// user.getId()+","+user.getPassword()+","+user.getName()+","+user.getWeight();

					bw.write(str);

				}

			} // while

		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				br.close();
				bw.close();

			} catch (Exception e) {
				// TODO: handle exception
			}
		} // finally
			*/
	 
	}

}
