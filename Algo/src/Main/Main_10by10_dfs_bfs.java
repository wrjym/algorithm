package Main;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_10by10_dfs_bfs {
	static class xy{
		public int x;
		public int y;
		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		@Override
		public String toString() {
			return "xy [x=" + x + ", y=" + y + "]";
		}
	}
	public static int [][]map;
	public static int [][]v;
	public static int cnt;
	public static Queue<xy> q;
	public static int []dx = {-1,1,0,0};
	public static int []dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);

		q = new LinkedList<>();
		map = new int[10][10];
		v = new int[10][10];
		cnt = 2;
		map[0][0] = 1;
		v[0][0] = 1;
		dfs(0,0);

		for(int []a : map) System.out.println(Arrays.toString(a));
		System.out.println();
		q.offer(new xy(0,0));
		v[0][0] = 0;
		bfs();
		for(int []a : map) System.out.println(Arrays.toString(a));
		
	}
	private static void bfs() {
		while(!q.isEmpty()){
			xy a = q.poll();
			for(int i=0; i<4; i++){
				int nx = a.x + dx[i];
				int ny = a.y + dy[i];
				if(0 <= nx && nx < 10 && 0 <= ny && ny < 10){
					if(map[nx][ny] != 0 && v[nx][ny] == 1){
						v[nx][ny] = 0;
						cnt++;
						map[nx][ny] = (cnt)-100;
						q.offer(new xy(nx,ny));
					}
				}
			}
		}
	}
	private static void dfs(int x, int y) {
		if(x == 10 && y == 10){
			return ;
		}
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx <10 && 0 <= ny && ny < 10){
				if(map[nx][ny]==0 && v[nx][ny]==0){
					map[nx][ny] = cnt++;
					v[nx][ny] = 1;
					dfs(nx,ny);
				}
			}
		}
		
	}
}
