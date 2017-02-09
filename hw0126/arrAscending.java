public class arrAscending
{

	int arr [] = {5,7,1,2,4,3,8,9,6,10};
	
	public void sort()
	{
	for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
         int  temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

	}
	
public void printAll(){

  for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
}

	public static void main(String[] args) 
	{
		arrAscending as = new arrAscending();
		System.out.println("정렬 전");
		as.printAll();
		as.sort();

		System.out.println("\n정렬 후");
		as.printAll();

	}
}
