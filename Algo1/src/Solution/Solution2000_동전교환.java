package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2000_동전교환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] coin = new int[N];
		for (int i = 0; i < coin.length; i++) {
			coin[i]=sc.nextInt();
		}
		int money = sc.nextInt();
		
		
		int[][] m = new int[coin.length][money+1];
		for (int i = 0; i < coin.length; i++) {
			for(int j=1; j<=money;j++) {
				if(i-1<0) {
					m[i][j]=m[i][j-coin[i]]+1;
				}
				else if(j-coin[i]<0) {
					m[i][j]=m[i-1][j];
				}
				else {
					m[i][j]=Math.min(m[i][j-coin[i]]+1, m[i-1][j]);
				}
			}
		}
		System.out.println(m[coin.length-1][money]);
		

		for(int []a : m)System.out.println(Arrays.toString(a));
	}
}
