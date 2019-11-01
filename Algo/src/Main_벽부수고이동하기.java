import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_벽부수고이동하기{
	static class Wall  {
		int x,y,cnt;
		boolean use;
		public Wall(int x, int y, int cnt, boolean use) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.use = use;
		}
		@Override
		public String toString() {
			return "Wall [x=" + x + ", y=" + y + ", cnt=" + cnt + ", use=" + use + "]";
		}


	}
	static int n,m;
	static int []dx = {0,-1,0,1};
	static int []dy = {-1,0,1,0};
	static int [][]map;
	static int [][][]v;
	static int min;
	static Queue<Wall> wall;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/2206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();
		String []tmps = tmp.split(" ");
		n = Integer.parseInt(tmps[0]);
		m = Integer.parseInt(tmps[1]);
		map = new int[n][m];
		v = new int[2][n][m];
		min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			tmp = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(tmp.charAt(j)+"");
				v[0][i][j] = Integer.MAX_VALUE;
			}
		}
		wall = new LinkedList<>();
		v[0][0][0] = 1;
		wall.offer(new Wall(0, 0, 0, false));
		bfs();

		if(min == Integer.MAX_VALUE) 
			System.out.println(-1);
		else 
			System.out.println(min+1);
	}
	private static void bfs() {
		while(!wall.isEmpty()) {
			Wall w = wall.poll();
			if(w.x == n-1 && w.y == m-1) {
				min = Math.min(min, w.cnt);
				return ;
			}
			for(int dir=0; dir<4; dir++) {
				int nx = w.x + dx[dir];
				int ny = w.y + dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < m) {
					if(map[nx][ny] == 1 && !w.use) {
						v[0][nx][ny] = 1;
						wall.offer(new Wall(nx, ny,w.cnt+1, true));
					}
					else if(map[nx][ny] == 0 && v[0][nx][ny] == 0) {
						v[1][nx][ny] = 1;
						wall.offer(new Wall(nx, ny, w.cnt+1 , w.use));
					}
//					vm(v);
				}
			}
		}
	}
	private static void vm(int[][] v2) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) 
				System.out.print(v2[i][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}

}
