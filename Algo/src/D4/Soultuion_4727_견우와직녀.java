package D4;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Soultuion_4727_견우와직녀 {
	static class rc_4727{
		public int x;
		public int y;
		public int cnt;
		public boolean b;
		public rc_4727(int x, int y, int cnt, boolean b) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.b = b;
		}
		@Override
		public String toString() {
			return "rc_4727 [x=" + x + ", y=" + y + ", cnt=" + cnt + ", b=" + b + "]";
		}
	}
	public static int [][]map;
	public static int min;
	public static int [][]v;
	public static int n,k;
	public static Queue<rc_4727> q;
	public static int []dx = {0,-1,0,1};
	public static int []dy = {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/4727.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			k = sc.nextInt();
			min = Integer.MAX_VALUE;

			map = new int[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					map[i][j] = sc.nextInt();
				}
			}
			q = new LinkedList<>();
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(map[i][j] == 0){
						int []check = new int[4];
						for(int dir=0; dir<4; dir++){
							int nx = i + dx[dir];
							int ny = j + dy[dir];
							if(0 <= nx && nx < n && 0 <= ny && ny < n){
								if(map[nx][ny] != 1){
									check[dir]=1;
								}
							}
						}
						if(check[0]==1 && (check[1]==1 || check[3]==1)){
							map[i][j] = -1;
						}
						else if(check[1]==1 && (check[0]==1 || check[2]==1 )){
							map[i][j] = -1;
						}
						else if(check[2]==1 && (check[1]==1 || check[3]==1)){
							map[i][j] = -1;
						}
						else if(check[3]==1 && (check[0]==1 || check[2]==1)){
							map[i][j] = -1;
						}
					}
				}
			}
			v = new int[n][n];
			for(int []a : v) Arrays.fill(a, 0);
			v[0][0] = 1;
			dfs(0,0,0,false);
			System.out.println("#" + tc + " " + min);

		}
	}
	private static void dfs(int x, int y, int cnt, boolean b) {
		if(x == n-1 && y == n-1){
			min = Math.min(min, cnt);
			return ;
		}
		if(cnt > min){
			return ;
		}
		for(int dir=0; dir<4; dir++){
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if(0 <= nx && nx < n && 0 <= ny && ny < n){
				if(map[nx][ny] == 1 && v[nx][ny] == 0 ){
					v[nx][ny] = cnt+1;
					dfs(nx,ny, cnt+1, b);
					v[nx][ny] = 0;
				}
				else if(map[nx][ny] > 1 && v[nx][ny] == 0){
					int temp = (cnt)%map[nx][ny];
					v[nx][ny] = cnt+map[nx][ny]-temp;
					dfs(nx,ny, cnt+map[nx][ny]-temp, b);
					v[nx][ny] = 0;
				}
				else if(map[nx][ny] == 0 && v[nx][ny] == 0 && b == false){
					int temp = (cnt)%k;
					v[nx][ny] = cnt-temp+k;
					dfs(nx,ny, cnt-temp+k ,true);
					v[nx][ny] = 0;
				}
			}

		}
	}
	private static void viewV() {
		System.out.println();
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(v[i][j] + "\t");
			}
			System.out.println();
		}
	}



}