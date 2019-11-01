package 못푼문제;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1859_백만장자프로젝트 {
	public static int[]a;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1859.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int b = sc.nextInt();
			a = new int[b];
			for(int i=0; i<b; i++){
				a[i] = sc.nextInt();
			}

			int cnt=0;	//마지막에 곱셈해서 쓸려고 만든 cnt
			int ans=0;	//총값을 위한
			int sum=0;	//현재까지 데이터 (1 1 2 => 1+1)
			int now = 0;	//현재 값 가리키고 있는 값.
			for(int i=0; i<b; i++){
				System.out.println(i + ":" + a[i] + " :  now:" + now);
				if(a[i] <= now){
					sum += a[i];
					cnt++;
				}
				else{
					ans += (a[i]*cnt) - sum;
					cnt = 0;
					sum = 0;
					now = a[i+1];
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
