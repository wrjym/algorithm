package D4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_2105_디저트카페 {
	public static int [][]map;
	public static int []d;
	public static int []dx = {1,1,-1,-1};
	public static int []dy = {1,-1,-1,1};
	public static int fx,fy;
	public static int n;
	public static int max;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/2105.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			map = new int[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					map[i][j] = sc.nextInt();
				}
			}
			//			for(int []a : map)System.out.println(Arrays.toString(a));
			max = -1;
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					d = new int[101];
					fx = i;
					fy = j;
					d[map[i][j]] = 1;
					dfs(i,j,1,0);
					d[map[i][j]] = 0;
				}
			}
			System.out.println("#" + tc + " " + max );
		}

		sc.close();
	}
	private static void dfs(int x, int y, int cnt, int dir) {
		for(int i= dir; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx == fx && ny == fy && cnt >= 4){
				if(max < cnt){
					max = cnt;
				}
				return ;
			}

			//			if(0 <= nx && nx < n && 0 <= ny && ny < n && d[map[nx][ny]] == 0) {

			if(nx<0 || ny<0 || nx>=n || ny>=n || d[map[nx][ny]]==1)
				continue;
			if(dir==0){
				if(i>1)
					continue;
			}else if(dir==1){
				if(i==3 || i==0)
					continue;
			}
			else if(dir==2){
				if(i==0 || i==1)
					continue;
			}else if(dir==3){
				if(i!=3 )
					continue;
			}
			d[map[nx][ny]] = 1;
			dfs(nx,ny,cnt+1, i);
			d[map[nx][ny]] = 0;
			//			}
		}
	}
}
