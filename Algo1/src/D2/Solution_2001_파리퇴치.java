package D2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_2001_파리퇴치 {
	public static int map[][];
	public static int max=0;
	public static int sum=0;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2001.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			map = new int[N][N];
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++)
				{
					map[i][j] = sc.nextInt();
				}
			}
			
//			for(int[]a : map)System.out.println(Arrays.toString(a));

			for(int i=0; i<N-M+1; i++){
				for(int j=0; j<N-M+1; j++){
					check(i,j,M);
					if(max < sum){
						max = sum;
					}
					
				}
			}
			
			
			System.out.println("#" + tc + " " + max);
			max = 0;
		}
	}

	private static void check(int x, int y, int M) {
		sum = 0;
		for(int i=x; i<x+M; i++){
			for(int j=y; j<y+M; j++){
				sum += map[i][j];
			}
			
		}
	}
}
