package D1;

import java.util.Scanner;

public class D1_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner input = new Scanner(System.in);
		        int count = input.nextInt();
		        int[] arr = new int[count];
		        int middlecount=Math.round(count/2);
		        for(int i=0; i<count;i++)
		        {
		        	int num = input.nextInt();
		        	arr[i]=num;
		        }
		        System.out.println(arr[middlecount]);
		        
	}

}
