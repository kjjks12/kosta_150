public class Lotto
{
	int []lottoNum= new int[6];

	public void init(){

		for(int i=0;i<lottoNum.length;i++){
		int temp=(int)((Math.random()*45)+1);
			if(findOvelap(temp,i,j)
			
		lottoNum[i]=
		

		}

	}
	
	public boolean findOvelap(int temp, int index1,int index2){
	
	boolean ret=false;
		for(index2=0;index2<index1;index2++){
			if(lottoNum[index1]==lottoNum[index2]){
			ret= false;
			break;
			}
			else{
			ret=true;
			}
		}
	return ret;
	}

	public void printAll(){
		
		for(int i=0;i<lottoNum.length;i++){
			System.out.print(lottoNum[i]+" ");
		}
	
	}

	public static void main(String[] args) 
	{
		Lotto lt= new Lotto();
		System.out.println("로또 번호 ");
	//System.out.println(lt.lottoNum.length);
	
	lt.init();
	lt.printAll();
	}
}
