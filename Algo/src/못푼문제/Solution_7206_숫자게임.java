package 못푼문제;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_7206_숫자게임 {
	public static int[] su;
	public static int len;
	public static int zero[] = {10,100,1000,10000};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/7206.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for(int tc=1; tc<=T; tc++){
			int x = sc.nextInt();
			findlen(12345);

			cut();



		}
	}
	private static void cut() {
		int cnt=2;
		int change=0;
		System.out.println("cut");
		for(int i=0; i<len; i++){

			for(int j=0; j<cnt; j++){
				change++;
				if(change <= cnt){
					//					System.out.print(su[j] + " : " + change + " ");
					System.out.print(su[j] + "");
					change=0;
				}
				
			}
			System.out.print(" ");
			for(int j = cnt; j < len; j++) {
				System.out.print(su[j] + "");
			}
			System.out.println();
			change=0;
			cnt = cnt+1;
			System.out.println(cnt);
		}
	}
	private static void findlen(int p) {
		while(p>1){
			p /= 10;
			len++;
		}
		len = len+1;
		System.out.println(len);
		su = new int[len];
		p = 12345;
		for(int i=len-1; i>=0; i--){
			su[i] = p % 10;
			p = p/10;
			//			System.out.println(p);
		}

		System.out.println(Arrays.toString(su));
	}
}
