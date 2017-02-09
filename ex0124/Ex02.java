public class Ex02{

public static void main(String [] args){

int randNum=(int)(Math.random()*101)+100;
System.out.println("랜덤값 :"+randNum);
if(randNum%7==0){
System.out.println("7의 배수O.");
}

else{
System.out.println("7의 배수X.");
}

}

}