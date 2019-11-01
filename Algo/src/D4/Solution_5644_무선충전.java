package D4;


import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_5644_무선충전 {
	static class rc_AB{
		public int Ax;
		public int Ay;
		public int Bx;
		public int By;
		public rc_AB(int ax, int ay, int bx, int by) {
			super();
			Ax = ax;
			Ay = ay;
			Bx = bx;
			By = by;
		}
		@Override
		public String toString() {
			return "rc_AB [Ax=" + Ax + ", Ay=" + Ay + ", Bx=" + Bx + ", By=" + By + "]";
		}

	}
	static class rc_5644{
		public int x;
		public int y;
		public int cnt;
		public int val;
		public rc_5644(int x, int y, int cnt, int val) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.val = val;
		}
		@Override
		public String toString() {
			return "rc_5644 [x=" + x + ", y=" + y + ", cnt=" + cnt + ", val=" + val + "]";
		}
	}
	static int[][][] map;
	static int [][]v;
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	static int [][]AB;
	static int k,m,n;
	static Queue<rc_5644> q;
	static Queue<rc_AB> A;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/5644.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){

			m = sc.nextInt();
			k = sc.nextInt();
			n = 11;
			AB = new int[2][m+1];
			map = new int[k][n][n];
			for(int j=0; j<2; j++){
				for(int i=1; i<=m; i++){
					AB[j][i] = sc.nextInt();
				}
			}
			for(int i=0; i<k; i++){
				q = new LinkedList<>();
				v = new int[n][n];
				int x = sc.nextInt();
				int y = sc.nextInt();
				int cnt = sc.nextInt();
				int val = sc.nextInt();
				q.offer(new rc_5644(y,x,0,val));
				v[y][x] = 1;
				map[i][y][x] = val;
				bfs(i, cnt);
			}
			A = new LinkedList<rc_AB>();
			A.offer(new rc_AB(1, 1, 10, 10));
			int ans =0;
			for(int j=0; j<=m; j++){
				rc_AB rc = A.poll();

				int Ax = rc.Ax + dx[AB[0][j]];
				int Ay = rc.Ay + dy[AB[0][j]];
				int Bx = rc.Bx + dx[AB[1][j]];
				int By = rc.By + dy[AB[1][j]];
				A.offer(new rc_AB(Ax, Ay, Bx, By));
				int sum = 0;
				for(int i=0; i<k; i++){
					int AMax = 0;
					int BMax = 0;
					AMax = map[i][Ax][Ay];
					for(int p=0; p<k; p++){
						BMax = map[p][Bx][By];
						if(AMax != 0 || BMax != 0){
						}
						if(AMax == BMax && i == p){
							sum = Math.max(sum, BMax);
						}
						else{
							sum = Math.max(sum, AMax+BMax);
						}
					}
				}
				ans += sum;
			}
			System.out.println("#" + tc + " " + ans);

		}
		sc.close();
	}
	private static void bfs(int BC, int cntMax) {
		while(!q.isEmpty()){
			rc_5644 rc = q.poll();
			if(cntMax == rc.cnt){
				return ;
			}
			for(int dir=1; dir<5; dir++){
				int nx = rc.x + dx[dir];
				int ny = rc.y + dy[dir];

				if(0 < nx && nx < n && 0 < ny && ny < n){
					if(v[nx][ny] == 0){
						map[BC][nx][ny] = rc.val;
						q.offer(new rc_5644(nx, ny, rc.cnt+1, rc.val));
					}
				}

			}


		}
	}
}






