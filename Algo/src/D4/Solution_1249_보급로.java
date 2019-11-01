package D4;
import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Solution_1249_보급로 {

	static class rc_1249 implements Comparable<rc_1249>{
		public int x;
		public int y;
		public int sum;
		public rc_1249(int x, int y, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.sum = sum;
		}

		@Override
		public String toString() {
			return "rc_1249 [x=" + x + ", y=" + y + ", sum=" + sum + "]";
		}
		@Override
		public int compareTo(rc_1249 o) {
			if(this.sum > o.sum)
				return 1;
			else
				return -1;
		}
	}

	static int n;
	static int [][]map;
	static int [][]v;
	static int min;
	static PriorityQueue<rc_1249> q;
	static int []dx = {0,-1,0,1};
	static int []dy = {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1249.txt"));
		Scanner sc = new Scanner(System.in);


		int T= Integer.parseInt(sc.nextLine());

		for(int tc=1; tc<=T; tc++){
			n = Integer.parseInt(sc.nextLine());
			map = new int[n][n];
			v = new int[n][n];
			min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++){
				String tmp = sc.nextLine();
				for(int j=0; j<n; j++){
					map[i][j] = Integer.parseInt(tmp.charAt(j)+"");
				}
			}
			q = new PriorityQueue<>();
			v[0][0] = 1;
			q.offer(new rc_1249(0, 0, map[0][0]));
			bfs();
			System.out.println("#" + tc + " " + min);
		}
		sc.close();
	}
	private static void bfs() {
		while(!q.isEmpty()){
			rc_1249 rc = q.poll();
			if(rc.x == n-1 && rc.y == n-1){
				min = Math.min(min, rc.sum);
				return ;
			}
			for(int dir=0; dir<4; dir++){
				int nx = rc.x + dx[dir];
				int ny = rc.y + dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < n ){
					if(v[nx][ny] == 0){
						v[nx][ny] = 1;
						q.offer(new rc_1249(nx, ny, rc.sum + map[nx][ny]));
					}
				}
			}
		}
	}
}










