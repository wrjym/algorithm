package Main;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.Scanner;

public class Main_14503_로봇청소기 {
	static int n,m;
	static int xx,yy,ddir;
	static int [][]map;
	static int cnt;
	static int []dx = {-1,0,1,0};
	static int []dy = {0,1,0,-1};
	static int []sx = {0,1,0,-1};
	static int []sy = {-1,0,1,0};
	static Queue<rc_14503> q;
	static class rc_14503{
		int x;
		int y;
		int dir;
		public rc_14503(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "rc_14503 [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/14503.txt"));
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		xx = sc.nextInt();
		yy = sc.nextInt();
		ddir = sc.nextInt();
		map = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				map[i][j] = sc.nextInt();
			}
		}

		cnt = 1;
		map[xx][yy] = 5;
		dfs(xx,yy,ddir);
		System.out.println(cnt);
		sc.close();
	}

	private static void dfs(int x, int y, int dir) {
		map[x][y] = 5;
		
		for(int i=0; i<4; i++){
			dir = (dir+3)%4;
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if(0 <= nx && nx < n && 0 <= ny && ny < m){
				if(map[nx][ny] == 0 ){	//2-1 왼쪽방향에 청소하지 않은 공간이 존재.
					cnt++;
					dfs(nx,ny,dir);
					return ;
				}
			}
			//다 돌고 원래 이동 좌표로 이동.

		}
		int back_dir = (dir+2)%4;
		int nx = x + dx[back_dir];
		int ny = y + dy[back_dir];
		if(0 <= nx && nx < n && 0 <= ny && ny < m){
			if(map[nx][ny] != 1)
				dfs(nx,ny,dir);
		}

	}

	private static void vm() {
		System.out.println();
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}


}







