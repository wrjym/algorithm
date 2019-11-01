import java.util.*;
public class Main_1788_피보나치수의확장 {
	static int n;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = Math.abs(n);

		if(n == 0){
			System.out.println(0+"\n"+0);
		}
		else{
			dp = new int[k+1];
			dp[0] = 0;
			dp[1] = 1;
			for(int i=2; i<=k; i++)
				dp[i] = (dp[i-1] + dp[i-2])%1000000000;
			if(n > 0){
				System.out.println(1);
				System.out.println(dp[k]%1000000000);
			}
			else{
				if(n%2==0){
					System.out.println(-1);
					System.out.println(dp[k]%1000000000);
				}
				else{
					System.out.println(1);
					System.out.println(dp[k]%1000000000);
				}

			}
		}
	}
	private static int fibonacci(int k) {
		System.out.println(k);
		if(k == 0) return 0;
		if(k == 1) return 1;
		if(dp[k] != 0 ) return dp[k];
		return (fibonacci(k-1) + fibonacci(k-2))%1000000000;
	}

}
