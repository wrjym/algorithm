package D4;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2382_미생물격리 {

	static class rc2382{
		public int x;
		public int y;
		public int msm;
		public int dir;
		public int dirValue;
		public rc2382(int x, int y, int msm, int dir, int dirValue) {
			super();
			this.x = x;
			this.y = y;
			this.msm = msm;
			this.dir = dir;
			this.dirValue = dirValue;
		}
		public rc2382() {
			super();
		}
		@Override
		public String toString() {
			return "rc2382 [x=" + x + ", y=" + y + ", msm=" + msm + ", dir=" + dir + ", dirValue=" + dirValue + "]";
		}
	}
	static rc2382 [][]map;
	static int n,m,k;
	static Queue<rc2382> q;
	static int []dx = {0,-1,1,0,0};
	static int []dy = {0,0,0,-1,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2382.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc <= T; tc++){
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();


			map = new rc2382[n][n];
			for(int i=0; i<k; i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				int msm = sc.nextInt();
				int dir = sc.nextInt();
				map[x][y] = new rc2382(x, y, msm, dir, msm);
			}

			for(int z=0; z<m; z++){
				q = new LinkedList<>();
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						if(map[i][j] != null){
							q.offer(map[i][j]);
							map[i][j] = null;
						}
					}
				}
				bfs();
			}
			int sum =0;
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(map[i][j] != null){
						sum += map[i][j].msm;
					}
				}
			}

			System.out.println("#" + tc + " " + sum);
		}
		sc.close();
	}
	private static void bfs() {
		while(!q.isEmpty()){
			rc2382 rc = q.poll();

			int nx = rc.x + dx[rc.dir];
			int ny = rc.y + dy[rc.dir];

			if(0 < nx && nx < n-1 && 0 < ny && ny < n-1){
				if(map[nx][ny] != null){
					map[nx][ny].dir = map[nx][ny].dirValue > rc.msm ? map[nx][ny].dir : rc.dir;
					map[nx][ny].dirValue = map[nx][ny].dirValue > rc.msm ? map[nx][ny].dirValue : rc.msm;
					map[nx][ny].msm += rc.msm;
				}
				else{
					map[nx][ny] = new rc2382(nx,ny, rc.msm, rc.dir, rc.msm);
				}
			}
			else{
				switch(rc.dir%2){
				case 0:
					map[nx][ny] = new rc2382(nx, ny, rc.msm/2, rc.dir-1, rc.msm/2);
					break;
				case 1:
					map[nx][ny] = new rc2382(nx, ny, rc.msm/2, rc.dir+1, rc.msm/2);
					break;
				}
			}

		}
	}

}




















