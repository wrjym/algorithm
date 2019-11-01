package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main1230_선물의집 {
	public static int n;
	public static int [][]map;
	public static int [][]v;
	public static int max;
	public static int []dx = {0,-1,0,1};
	public static int []dy = {-1,0,1,0};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1230.txt"));
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0,0,0);
		System.out.println(max);
		System.out.println("END POINT");


	}
	private static void dfs(int x, int y, int cnt) {
		if(x == n-1 && y == n-1){
			if(max < cnt){
				max = cnt;
			}
			return ;
		}
		if(map[x][y] == 2){
			cnt += 1;
		}
		
		int nx=0, ny=0;
		for(int i=0; i<4; i++){
			nx = x + dx[i];
			ny = y + dy[i];
			if( 0 <= nx && nx < n && 0 <= ny && ny < n){
				int now = map[x][y];
				
				if(map[nx][ny]!=1){
					map[x][y] = 1;
					dfs(nx,ny,cnt);
					map[x][y] = now;
				}
			}
		}


	}

}
