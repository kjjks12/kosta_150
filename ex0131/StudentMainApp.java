public class StudentMainApp 
{
	Student [] st= new Student[5];


	public void save(String [][]data){
		for(int i=0; i<st.length;i++){
			st[i]=this.create(data[i]);
		}
	}//save method

	/**
	Student ��ü�� �����ؼ� �����ϴ� �޼ҵ� �ۼ�
	*/
	
	private Student create(String [] row){
	Student st=	new Student(row[0], Integer.parseInt(row[1]));
	//st.setName(row[0]);
	//st.setAge(Integer.parseInt(row[1]));
	return st;
	}//create method


	public void print(){
		for (Student s :st ){
		System.out.println("�ּ� ="+s+"  "+"�̸� ="+s.getName()+"  "+ "���� ="+s.getAge());
		}
	}

	/**
	�л��� ������ 5�� �����ϴ� �޼ҵ带 �ۼ�
	��� �л��� ������ ����ϴ� �޼ҵ� �ۼ�

	*/
	public static void main(String[] args) 
	{
		//�л��� ���� �ʱ�ġ ������ 5�� 2���� �迭�� ����!
		String data [][]= {
			{"������","50"},
			{"������","26"},
			{"������","26"},
			{"���Ƹ�","25"},
			{"������","24"},
		};
	
	StudentMainApp sma= new StudentMainApp();
	sma.save(data);
	sma.print();
	}


}
