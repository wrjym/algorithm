package Main;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main_17142_다리만들기2_1 {
	static class Island{
		int x,y;
		public Island(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Island [x=" + x + ", y=" + y + "]";
		}

	}
	static int n,m,fx,fy;
	static int [][]map,v;
	static Queue<Island> q;
	static int island;
	static int min;
	static int []tmpSeq;
	static int []dx = {0, -1, 0, 1};
	static int []dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/17472.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				map[i][j] = sc.nextInt();
			}
		}

		checkingIsland();
		int []seq = new int[island];
		tmpSeq = new int[seq.length];
		min = Integer.MAX_VALUE;
		dfs(0,0,0,0,seq);
		if(min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
		sc.close();
	}
	private static void dfs(int x, int y, int sum, int is, int[] seq) {
		if(min < sum || x == n){
			return;
		}
		if(island-2 == is){	// 섬 갯수 - 1개 였을때 모두 연결 가능.
			int tmp = 0;
			v = new int[n][m];
			v[fx][fy] = 1;
			tmpSeq[map[fx][fy]] = 1;
			q.offer(new Island(fx, fy));
			bfss();
			for(int i=1; i<tmpSeq.length; i++){
				if(tmpSeq[i] == 1)
					tmp++;
				tmpSeq[i] = 0;
			}
			if(tmp == island-1)
				min = Math.min(min, sum);
			return;
		}
		if(map[x][y] >= 10){
			if(y + 1 < m)
				dfs(x, y+1, sum, is, seq);
			else
				dfs(x+1, 0, sum, is, seq);
		}
		else{
			if(y + 1 < m)
				dfs(x, y+1, sum, is, seq);
			else
				dfs(x+1, 0, sum, is, seq);
			for(int dir=0; dir<4; dir++){
				boolean b = true;
				int nx = x;
				int ny = y;
				//	확인.
				seq[map[x][y]] = 1;
				while(true){
					nx += dx[dir];
					ny += dy[dir];
					if(0 <= nx && nx < n && 0 <= ny && ny < m){
						if(map[nx][ny] < 10 && map[x][y] != map[nx][ny])
							break;
					}
					else{
						b = false;
						break;
					}
				}
				//	선긋기.
				if(b){
					nx = x;
					ny = y;
					int tmpSum = 0;
					while(true){
						nx += dx[dir];
						ny += dy[dir];
						if(0 <= nx && nx < n && 0 <= ny && ny < m){
							if(map[nx][ny] >= 10){
								map[nx][ny]++;
								tmpSum++;
							}
							else if(map[nx][ny] < 10 && map[x][y] != map[nx][ny]){
								break;
							}
						}
						else{
							break;
						}
					}
					if(tmpSum >= 2){
						if(y + 1 < m)
							dfs(x, y+1, sum+tmpSum, is+1, seq);
						else
							dfs(x+1, 0, sum+tmpSum, is+1, seq);
					}
					nx = x;
					ny = y;
					while(true){
						nx += dx[dir];
						ny += dy[dir];
						if(0 <= nx && nx < n && 0 <= ny && ny < m){
							if(map[nx][ny] >= 10){
								map[nx][ny]--;
							}
							else if(map[nx][ny] < 10 && map[x][y] != map[nx][ny]){
								break;
							}
						}
						else{
							break;
						}
					}
				}
				seq[map[x][y]] = 0;
			}
		}

	}
	private static void checkingIsland() {
		int cnt = 2;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(map[i][j] == 1){
					q = new LinkedList<>();
					q.offer(new Island(i, j));
					map[i][j] = cnt;
					bfs(cnt++);
					fx = i;
					fy = j;
				}
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(map[i][j] > 0)
					map[i][j]-=1;
				else
					map[i][j] = 10;
			}
		}
		island = cnt-1;
	}
	private static void bfs(int cnt) {
		while(!q.isEmpty()){
			Island is = q.poll();
			for(int dir=0; dir<4; dir++){
				int nx = is.x + dx[dir];
				int ny = is.y + dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(map[nx][ny] == 1){
						q.offer(new Island(nx, ny));
						map[nx][ny] = cnt;
					}
				}
			}
		}
	}
	private static void bfss() {	//다리 확인할때 섬으로 확산하는 bfs()
		while(!q.isEmpty()){
			Island is = q.poll();
			for(int dir=0; dir<4; dir++){
				int nx = is.x + dx[dir];
				int ny = is.y + dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(map[nx][ny] < 10 && v[nx][ny] == 0){
						v[nx][ny] = 1;
						q.offer(new Island(nx, ny));
					}
					else if(map[nx][ny] > 10 ){
						direct(nx,ny,dir);
					}
				}
			}
		}
	}
	private static void direct(int nx, int ny, int dir) {	//다리 놓았던거 확인할때 일직선으로 가는 함수.
		int tmps = 1;
		while(true){
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			if(0 <= nx && nx < n && 0 <= ny && ny < m){
				if(map[nx][ny] > 10){
					v[nx][ny]++;
					tmps++;
				}
				else if(map[nx][ny] < 10 && tmpSeq[map[nx][ny]] == 0 ){
					if(tmps >= 2){
						v[nx][ny] ++;
						tmpSeq[map[nx][ny]] = 1;
						q.offer(new Island(nx, ny));
					}
					return;
				}
				else 
					return;
			}
			else{
				return ;
			}
		}
	}
	private static void vm(int[][] m2) {
		System.out.println("=============================================");
		for(int i=0; i<n; i++)	{
			for(int j=0; j<m; j++){
				System.out.print(m2[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
