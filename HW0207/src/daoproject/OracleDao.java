package daoproject;

public class OracleDao implements DataAccessObject{

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println(this.toString()+"���� �˻�");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println(this.toString()+"�� ����");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(this.toString()+"�� ����");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println(this.toString()+"���� ����");
	}

	@Override
	public String toString() {
		return "OracleDao DB";
	}

	
	
}
