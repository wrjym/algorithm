package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Solution5431_민석이의과제체크하기_서울9반_김용민 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=0;test_case<T;test_case++){
			int allStudent = sc.nextInt();
			int gStudent = sc.nextInt();
			

			int []arr = new int[allStudent];
			
			for(int i=0;i<gStudent;i++){
				int temp = sc.nextInt();
				arr[temp-1] = 1;
			}
//			System.out.println(Arrays.toString(arr));
			System.out.print("#" + (test_case+1) + " ");
			for(int i=0;i<allStudent;i++){
				if(arr[i]==0)
					System.out.print(i+1 + " ");				
			}
			System.out.println();
						
		}

	}

}
