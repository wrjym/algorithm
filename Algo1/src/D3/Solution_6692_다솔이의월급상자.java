package D3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_6692_다솔이의월급상자 {
	public static double [][]d;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/6692.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			
			d = new double [n][2];
			double ans = 0;
			for(int i=0; i<n; i++){
				d[i][0] = sc.nextDouble();
				d[i][1] = sc.nextDouble();
				ans += d[i][0] * d[i][1];
			}
			
			for(double []a : d)System.out.println(Arrays.toString(a));
			System.out.println(ans);
		}
	}

}
