package D3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1206_View {
	public static int[] arr;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1206.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int tc=1; tc<=10; tc++){
			int a = sc.nextInt();
			arr = new int[a];

			for(int i=0; i<a; i++){
				arr[i] = sc.nextInt();
			}
			int ans = 0;
			for(int i=2; i<a-2; i++){
				if(arr[i] > arr[i-1] && 
						arr[i] > arr[i-2] && 
						arr[i] > arr[i+1] && 
						arr[i] > arr[i+2])
				{
					int max = arr[i-1];
					max = Math.max(max,arr[i-2]);
					max = Math.max(max,arr[i+1]);
					max = Math.max(max,arr[i+2]);

					ans += arr[i] - max;
				}
				


			}

			System.out.println("#" + tc + " " + ans);
			ans = 0;
		}
	}



}
