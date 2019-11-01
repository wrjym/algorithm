package D4;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_7829_보물왕김태혁 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/7829.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			Long min = Long.MAX_VALUE;
			Long max = Long.MIN_VALUE;
			for(int i=0; i<n; i++){
				Long a = sc.nextLong();
				min = Math.min(min, a);
				max = Math.max(max, a);
			}
			
			System.out.println("#" + tc + " " + (min*max));
		}
		sc.close();
	}

}
