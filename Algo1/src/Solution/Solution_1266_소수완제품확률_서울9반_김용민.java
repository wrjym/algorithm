package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1266_소수완제품확률_서울9반_김용민 {
	public static int []frime = {2,3,5,7,11,13,17};
	public static int cnt=0;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/input_1266.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			double A = sc.nextDouble();
			double B = sc.nextDouble();
			
			double ab=0;
			double ba=0;
			for(int i=0; i<frime.length; i++){
				cnt=0;
				comb(18,frime[i]);

				ab += Math.pow((A/100), frime[i]) * Math.pow(1-(A/100), 18-frime[i]) *cnt ;
				ba += Math.pow((B/100), frime[i]) * Math.pow(1-(B/100), 18-frime[i]) *cnt ;
			}
			
			ab = 1 - ab;
			ba = 1 - ba;
			
			double result = 1 - (ab * ba);
			
			System.out.printf("#" + tc + " " + "%.6f\n",result);
			

		}

	}

	public static void comb(int n, int r) {
		
		if (r == 0) {
			cnt++;
			return;
		}
		if (n < r) {
			return;
		}
		comb(n - 1, r - 1); // nCr = n-1Cr-1 + n-1Cr
		comb(n - 1, r);
	}

}
