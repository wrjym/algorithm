package Main;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_단지번호붙이기_DFS2 {
	public static int[][]map;
	public static int[] ans;
	public static int T;
	public static int cnt=2;
	public static int []dx = {0, -1, 0, 1};
	public static int []dy = {-1, 0 , 1, 0 };
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/main.txt"));
		Scanner sc = new Scanner(System.in);

		T = Integer.parseInt(sc.nextLine());

		map = new int[T][T];
		ans = new int[T];
		for(int i=0; i<T; i++){
			String a = sc.nextLine();
			for(int j=0; j<T; j++){
				map[i][j] = a.charAt(j) - '0';
			}
		}

		for(int a[] : map) System.out.println(Arrays.toString(a));
		for(int i=0; i<T; i++){
			for(int j=0; j<T; j++){
				if(map[i][j] == 1){
					dfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println();
		for(int a[] : map) System.out.println(Arrays.toString(a));
		Arrays.sort(ans);
		
		System.out.println(cnt-2);
		for(int i=0; i<ans.length; i++){
			if(ans[i] > 0){
				System.out.println(ans[i]);
			}
		}
		
	}
	private static void dfs(int x, int y) {
		int nx=0, ny=0;
		map[x][y] = cnt;
		ans[cnt]++;
		for(int i=0; i<4; i++){
			nx = x + dx[i];
			ny = y + dy[i];
			if(0 <= nx && nx < T && 0 <= ny && ny < T){
				if(map[nx][ny] == 1){
					dfs(nx,ny);
				}
			}
		}
	}


}







