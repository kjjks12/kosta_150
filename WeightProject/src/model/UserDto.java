package model;

public class UserDto {

	private String id;
	private String password;
	private String name;
	private String weight;

	public UserDto() {
		// TODO Auto-generated constructor stub
	}


	public UserDto(String id, String password, String name, String weight) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.weight = weight;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "아이디 :"+id+" 암호 :"+password+" 이름 :"+name+" 몸무게"+weight;
		
	}

}
