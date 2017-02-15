package daoproject;

public class MySqlDao implements DataAccessObject{

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println(this.toString()+"에서 검색");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println(this.toString()+"에 삽입");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(this.toString()+"를 수정");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println(this.toString()+"에서 삭제");
	}
	@Override
	public String toString() {
		return "MySql DB";
	}
	
}
