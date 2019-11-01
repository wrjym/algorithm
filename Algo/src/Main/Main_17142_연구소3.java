package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17142_연구소3 {
	static class 바이러스{
		int x,y,cnt;
		public 바이러스(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "바이러스 [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
	}
	static int [][]map;
	static int [][]v;
	static int n,m, ans;
	static int []seq;
	static ArrayList<바이러스> li;
	static int []dx = {0,-1,0,1};
	static int []dy = {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/17142.txt"));
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		v = new int[n][n];
		li = new ArrayList<>();
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1)
					map[i][j] = -2;
				if(map[i][j] == 2)
					li.add(new 바이러스(i, j, 0));
			}
		}

		seq = new int[m];
		ans = Integer.MAX_VALUE;
		dfs(0,0);
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
		sc.close();
	}
	private static void dfs(int idx, int cnt) {
		if(cnt == m){
			Queue<바이러스> q = new LinkedList<>();
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(map[i][j] == 0 || map[i][j] == -2)
						v[i][j] = map[i][j];
				}
			}
			for(int i=0; i<m; i++){
				바이러스 b = li.get(seq[i]);
				q.offer(new 바이러스(b.x, b.y, 1));
				v[b.x][b.y] = -1;
			}
			while(!q.isEmpty()){
				바이러스 b = q.poll();
				for(int dir=0; dir<4; dir++){
					int nx = b.x + dx[dir];
					int ny = b.y + dy[dir];
					if(0 <= nx && nx < n && 0 <= ny && ny < n){
						if(v[nx][ny] == 0 && map[nx][ny] != 2){
							v[nx][ny] = b.cnt;
							q.offer(new 바이러스(nx, ny, b.cnt+1));
						}
						else if(v[nx][ny] == 0){
							v[nx][ny] = -2;
							q.offer(new 바이러스(nx, ny, b.cnt+1));
						}
					}
				}
			}
			int min = 0;
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(v[i][j] == 0)
						return ;
					else
						min = Math.max(min, v[i][j]);
				}
			}
			ans = Math.min(ans, min);
			
			for(int i=0; i<m; i++){
				바이러스 b = li.get(seq[i]);
				q.offer(new 바이러스(b.x, b.y, 0));
				v[b.x][b.y] = 0;
			}
			return;
		}
		for(int i=idx; i<li.size(); i++){
			seq[cnt] = i;
			dfs(i+1, cnt+1);
		}
	}
}
