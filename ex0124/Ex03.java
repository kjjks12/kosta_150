public class Ex03{

	private String yoil;
	
	public void setYoil(String yoil){
		this.yoil=yoil;
	}
	public String getyoil(){
		return yoil;
	}

	public static void main(String []args){
	//숫자가 10, 20 ,30,100 사이의의 숫자가 발생(10의 배수로만)
	int num=((int)(Math.random()*10)+1)*10;
	System.out.println(num);

	Ex03 ex= new Ex03();



	switch(num/10){
		case 1:
			ex.setYoil("일요일");
			break;
		case 2:
			ex.setYoil("월요일");
			break;
		case 3:
			ex.setYoil("화요일");
			break;
		case 4:
			ex.setYoil("수요일");
			break;
		case 5:
			ex.setYoil("목요일");
			break;
		case 6:
			ex.setYoil("금요일");
			break;
		default:
			ex.setYoil("토요일");
			

		}//switch
	System.out.println(ex);
	}//main method


	@Override
	public String toString(){
	return "요일 = "+yoil;
	}
}//class