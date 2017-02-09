public class homeWork3
{
	public static void main(String[] args) {
	
/*1번 문제 */	
	int sum=0;
	for( int i=0;i<100;i++){
		if((i%3)==0){
		sum+=i;
		}//if
	}//for

	System.out.println("1.3의 배수의 합 : "+sum);


/*2번 문제*/
	int dice1=0,dice2=0;
	for( ; ; ){
	dice1=(int)(Math.random()*6)+1;
	dice2=(int)(Math.random()*6)+1;
		if((dice1+dice2)==5){
		break;
		}//if
	}//while

System.out.println("DICE1 :"+dice1+" "+"DICE2 :"+dice2);



/*3번 문제*/

for(int x=1;10>=x;x++){
	for(int y=1;10>=y;y++){
		if((4*x)+(5*y)==60){
	System.out.println("("+x+","+y+")");
		}//if
	}//inner for
}//outer for



	}//main method
}//class
