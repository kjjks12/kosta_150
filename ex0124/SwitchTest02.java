/**
1~12 ������ ������ �߻��ؼ� ������ ������ �����Ѵ�. 
28 30 31��
1�� 31
2�� 28
3�� 31
4�� 30
5�� 31
6�� 30
7�� 31
8�� 31
9�� 30
10�� 31
11�� 30
12�� 31

31�� : 1 3 5 7 8 10 12
30�� : 4 6 9 11
28�� : 2

*/
public class SwitchTest02{

	public static void main(String [] args){

    int randNum=(int)(Math.random()*12)+1;

	switch(randNum){
		case 2: System.out.println(randNum+"���� 28�� ����");break;
		case 4:
		case 6:
		case 9:
		case 11:System.out.println(randNum+"���� 30�� ����");break;

		default:
		System.out.println(randNum+"���� 31�� ����");

		}//switch

	System.out.println("------------------------");

	if(randNum==2){
	System.out.println(randNum+"���� 28�� ����");}
	else if(randNum==4 || randNum==6 || randNum==9 || randNum==11){
	System.out.println(randNum+"���� 30�� ����");
	}
	else{
	System.out.println(randNum+"���� 31�� ����");
	}//if-else




	}//main method
}//class