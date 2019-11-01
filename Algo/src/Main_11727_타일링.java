import java.util.Scanner;

public class Main_11727_타일링 {

	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3; i<=n; i++)
			dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
//		solve(n);
		System.out.println(dp[n]);
		sc.close();
	}
	private static int solve(int n) {
		if(n == 1) return 1;
		if(n == 2) return 3;
		if(dp[n] != 0) return dp[n];
		return dp[n] = (solve(n-1) + 2*solve(n-2))%10007;
		
	}

}
