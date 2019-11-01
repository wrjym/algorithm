package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16234_인구이동 {

	static class rc_16234{
		int x,y;
		public rc_16234(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "rc_16234 [x=" + x + ", y=" + y + "]";
		}
	}
	static int L,R, n, cnt;
	static ArrayList<Integer> li;
	static int []dx = {0,-1,0,1};
	static int []dy = {-1,0,1,0};
	static int [][]map,v,tmpMap;
	static Queue<rc_16234> q;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/16234.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[n][n];
		v = new int[n][n];
		tmpMap = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
				tmpMap[i][j] = map[i][j];
			}
		}
		q = new LinkedList<>();
		int ans = 0;
		for(int year=0; year<2000; year++){
			ans = year;
			v = new int[n][n];
			cnt = 1;
			li = new ArrayList<>();
			li.add(0);
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(v[i][j] == 0){
						q.offer(new rc_16234(i, j));
						bfs();
					}
				}
			}
		
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(v[i][j] > 0){
						map[i][j] = li.get(v[i][j]);
					}
				}
			}
			if(li.size()==1){
				break;
			}
		}
		System.out.println(ans);
		sc.close();
	}
	private static void bfs() {
		int sum=0,count=0;
		boolean flag = false;
		while(!q.isEmpty()){
			rc_16234 rc = q.poll();
			for(int dir=0; dir<4; dir++){
				int nx = rc.x + dx[dir];
				int ny = rc.y + dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < n){
					int tmp = Math.abs(map[nx][ny] - map[rc.x][rc.y]);
					if(L <= tmp && tmp <= R && v[nx][ny] == 0){
						sum += map[nx][ny];
						v[nx][ny] = cnt;
						count++;
						q.offer(new rc_16234(nx, ny));
						flag = true;
					}
				}
			}
		}
		if(flag){
			int people = sum/count;
			li.add(people);
			cnt++;
		}
	}
	private static void vm(int[][] map2) {
		System.out.println("==================================================");
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++)
				System.out.print(map2[i][j] + " ");
			System.out.println();
		}
	}

}
