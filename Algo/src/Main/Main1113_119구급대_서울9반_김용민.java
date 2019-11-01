package Main;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main1113_119구급대_서울9반_김용민 {
	public static int n,m,fx,fy;
	public static int[][]map ;
	public static int []dx = {0,-1,0,1};
	public static int []dy = {-1,0,1,0};
	public static int min;
	public static int ccnt=-1;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1113.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		min = Integer.MAX_VALUE;
		
		fx=sc.nextInt();
		fy=sc.nextInt();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0,0,-1,4);
		System.out.println(min);
		sc.close();
	}

	private static void dfs(int x, int y, int cnt, int dir) {
		if(cnt > min){
			return ;
		}
		if(x==fx && y==fy){
			if(min > cnt){
				min = cnt;
			}
			return ;			
		}
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < n && 0 <= ny && ny < m){
				if(map[nx][ny] == 1){
					map[nx][ny] = ccnt--;
					
					if(dir == i){
						dfs(nx,ny,cnt,i);
					}
					else{
						dfs(nx,ny,cnt+1,i);
					}
					ccnt++;
					map[nx][ny] = 1;
				}
			}
		}
		
		
		
		
	}

}
