package model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentManageMent {
	ArrayList<Integer> list = new ArrayList<>();
	List<Student> stlist = new ArrayList<>();
	BufferedReader br = null;
	int num;
	public ArrayList<Student> arr = new ArrayList<>();
	
	public StudentManageMent() {
		// TODO Auto-generated constructor stub
	}
	
	//»ý¼ºÀÚ
	public StudentManageMent(int num) {
		this.num = num;
		
		try {
			br = new BufferedReader(new FileReader("src/kosta.txt"));
			
			String str = null;
			while( (str=br.readLine()) != null){
				String [] v = str.split(",");
				
				Student st = new Student(v[0],Integer.parseInt(v[1]));
				stlist.add(st);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		while(list.size() < stlist.size()){
			int k = (int)(Math.random()*stlist.size());
			if(list.contains(k))
				continue;
			else
				list.add(k);
		}

		
		for(int i=0;i<stlist.size();i++){
			arr.add(stlist.get(list.get(i)));
		}
			
	}
	

}
