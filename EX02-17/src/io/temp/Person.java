package io.temp;

public class Person {

	private String id;
	private String pwd;
	private String name;
	private String address;
	private String phoneNumber;
	
	/**
	 * 기본생성자
	 */
	public Person() {}
	
	public Person(String id, String pwd, String name, String address,String phoneNumber) {
	
		this.id= id;
		this.pwd=pwd;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	
	//Getter Setter
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return  "이름 =" + name +"\t주소 =" + address +"\t번호 =" + phoneNumber;
	}
}
