package 못푼문제;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;



public class Solution_1865_동철이의일분배_서울9반_김용민 {
	public static int [][]work;
	public static int []emply;
	public static int []d = {1,2,3};
	public static int []seq;
	public static int N;
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("rs/1865.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();


		for(int tc=1; tc<=T; tc++){
			N = sc.nextInt();
			seq = new int[N];
			work = new int[N][N];
			emply = new int[N];
			int x,y;
			int max = 0;
			dfs(0,0);

		}

		sc.close();
	}
	private static void dfs(int cnt, int idx) {
		if(cnt==N){
			System.out.println(Arrays.toString(d));
			return ;
		}

		for(int i=0; i<N; i++){
			seq[i] = 1;
			dfs(cnt+1, idx+1);
			seq[i] = 0;
		}

	}

}




