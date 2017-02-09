/**
1~12 사이의 난수를 발생해서 정수형 변수에 저장한다. 
28 30 31일
1월 31
2월 28
3월 31
4월 30
5월 31
6월 30
7월 31
8월 31
9월 30
10월 31
11월 30
12월 31

31일 : 1 3 5 7 8 10 12
30일 : 4 6 9 11
28일 : 2

*/
public class SwitchTest02{

	public static void main(String [] args){

    int randNum=(int)(Math.random()*12)+1;

	switch(randNum){
		case 2: System.out.println(randNum+"월은 28일 까지");break;
		case 4:
		case 6:
		case 9:
		case 11:System.out.println(randNum+"월은 30일 까지");break;

		default:
		System.out.println(randNum+"월은 31일 까지");

		}//switch

	System.out.println("------------------------");

	if(randNum==2){
	System.out.println(randNum+"월은 28일 까지");}
	else if(randNum==4 || randNum==6 || randNum==9 || randNum==11){
	System.out.println(randNum+"월은 30일 까지");
	}
	else{
	System.out.println(randNum+"월은 31일 까지");
	}//if-else




	}//main method
}//class