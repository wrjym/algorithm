package brutegreedy;

import java.util.Arrays;

public class CombiTest {

	public static int N = 6;
	public static int R = 3;
	public static int[] a = new int[R];
	public static int cnt;

	public static void comb(int n, int r) {
		if (r == 0) {
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		if (n < r) {
			return;
		}
		a[r - 1] = n - 1;
		comb(n - 1, r - 1); // nCr = n-1Cr-1 + n-1Cr
		comb(n - 1, r);
	}

	public static void main(String[] args) {
		comb(N, R);
		System.out.println(cnt);
	}
}
