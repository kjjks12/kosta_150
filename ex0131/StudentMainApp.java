public class StudentMainApp 
{
	Student [] st= new Student[5];


	public void save(String [][]data){
		for(int i=0; i<st.length;i++){
			st[i]=this.create(data[i]);
		}
	}//save method

	/**
	Student 객체를 생성해서 리턴하는 메소드 작성
	*/
	
	private Student create(String [] row){
	Student st=	new Student(row[0], Integer.parseInt(row[1]));
	//st.setName(row[0]);
	//st.setAge(Integer.parseInt(row[1]));
	return st;
	}//create method


	public void print(){
		for (Student s :st ){
		System.out.println("주소 ="+s+"  "+"이름 ="+s.getName()+"  "+ "나이 ="+s.getAge());
		}
	}

	/**
	학생의 정보를 5개 저장하는 메소드를 작성
	모든 학생의 정보를 출력하는 메소드 작성

	*/
	public static void main(String[] args) 
	{
		//학생의 정보 초기치 데이터 5개 2차원 배열로 선언!
		String data [][]= {
			{"장희정","50"},
			{"정광수","26"},
			{"김진석","26"},
			{"정아름","25"},
			{"정진수","24"},
		};
	
	StudentMainApp sma= new StudentMainApp();
	sma.save(data);
	sma.print();
	}


}
