package D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1959_두개의숫자열 {
	public static int[] a;
	public static int[] b;
	public static int max=0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1959.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			a = new int[n];
			b = new int[m];
			max = 0;
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			for(int i=0; i<m; i++)
				b[i] = sc.nextInt();
		
			int tt = 0;
			if(n<m){
				tt = compare(b,a);
			}
			else{
				tt = compare(a,b);
			}
			
			if(max < tt){
				max = tt;
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	private static int compare(int[] x, int[] y) {
		int maxx = 0;
		int aa = x.length - y.length + 1;
		int sum = 0;
		for(int i=0; i<aa; i++){
			for(int j=0; j<y.length; j++){
				sum = sum + (x[j+i] * y[j]);
//				System.out.println("a : " + x[j+i] + "  b : " + y[j] + "  sum : " + sum);
			}
			if(maxx < sum){
				maxx = sum;
			}
			sum = 0;
		}
		return maxx;
	}


}
