package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_6855 {

	public static int []house;
	public static int []da;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/input_6855.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int cnt = -1;
			house = new int[n];
			da = new int[n-1];
			for(int i=0; i<house.length; i++){
				house[i] = sc.nextInt();
			}
			for(int i=0; i<house.length-1; i++){
				da[i] = house[i+1]-house[i];
			}
			int sum=0;
			k = k-1;
			Arrays.sort(da);
			for(int i=0; i<da.length-k;i++){
				sum+=da[i];
			}
			
			
			System.out.println("#" + tc + " " + sum);
			

//			System.out.println(Arrays.toString(da));



		}




	}

}
