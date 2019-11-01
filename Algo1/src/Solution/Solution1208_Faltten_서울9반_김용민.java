package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1208_Faltten_서울9반_김용민 {
	static int []arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//		int T = sc.nextInt();
		int max;
		int min;
		for(int test_case = 0; test_case < 10;test_case++){
			int num = sc.nextInt();
			arr = new int[100];
			for(int i=0;i<100;i++){
				arr[i] = sc.nextInt();
			}
			max = checkmax();
			min = checkmin();


			for(int i=0;i<num;i++){
				arr[max]--;
				arr[min]++;
				max = checkmax();
				min = checkmin();
			}

			System.out.println("#" + (test_case+1) + " "  + (arr[max]-arr[min]));

		}
	}

	private static int checkmax(){
		int max = 0;
		int index=0;
		for(int i=0;i<100;i++){
			if(arr[i] > max){
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
	private static int checkmin(){
		int min = 101;
		int index = 0;
		for(int i=0;i<100;i++){
			if(arr[i] < min){
				min = arr[i];
				index = i;
			}
		}
		return index;
	}
}


