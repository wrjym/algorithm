package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution1209_Sum_서울9반_김용민 {

	public static int [][]arr = new int[100][100];
	public static void main(String[] args) throws Exception  {
		System.setIn(new FileInputStream("rs/input_1209.txt"));
		
		Scanner sc = new Scanner(System.in);


		for(int tc = 0; tc < 10; tc++){
			int T = sc.nextInt();
			int max = 0;
			for(int i=0; i<arr.length; i++){
				int sum = 0;
				for(int j=0; j<arr[i].length; j++){
					arr[i][j] = sc.nextInt();
					sum = arr[i][j];
				}
				if(sum > max)
					max = sum;					
			}

			for(int i=0; i<arr.length; i++){
				int sum =0;
				for(int j=0; j<arr[i].length; j++){
					sum += arr[j][i];
				}
				if(sum > max)
					max = sum;
			}
			
			for(int i=0;i<arr.length;i++){
				int sum =0;
				for(int j=0; j<arr[i].length; j++){
					if(i==j)
						sum += arr[i][j];
				}
				if(sum > max)
					max = sum;
			}
			int temp = arr.length-1;
			for(int i=arr.length-1;i>=0;i--){
				int sum=0;
				for(int j=0; j<arr[i].length;j++){
					if(i+j == 99)
						sum += arr[i][j];
				}
				if(sum > max)
					max = sum;
			}
			
			System.out.println("#" + T + " " + max);
			
			

		}
	}
}
