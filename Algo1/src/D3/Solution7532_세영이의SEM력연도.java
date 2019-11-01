package D3;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution7532_세영이의SEM력연도 {
	public static int S,E,M;
	public static int ans;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/7532.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			ans = 0;
			S = sc.nextInt();
			E = sc.nextInt();
			M = sc.nextInt();

			findYear();
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void findYear() {
		while(true){
			S--;	E--;	M--;	ans++;
			if(S == 0 && E == 0 && M == 0 )
				return;
			if(S==0)
				S = 365;
			if(E==0)
				E = 24;
			if(M==0)
				M = 29;
		}

	}


}
