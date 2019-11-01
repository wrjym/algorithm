package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_인구이동 {
	static class xy{
		public int x;
		public int y;
		public int value;
		public xy(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}
		@Override
		public String toString() {
			return "xy [x=" + x + ", y=" + y + ", value=" + value + "]";
		}

	}
	public static int ans;
	public static ArrayList<xy> list;
	public static Queue<xy> q;
	public static int [][]map;
	public static int [][]v;
	public static int n,L,R;
	public static int totalSum;
	public static int per;
	public static int []dx = {0,1,0,-1};
	public static int []dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1.txt"));
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		ans = 0;
		list = new ArrayList<>();
		q = new LinkedList<>();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[n][n];
		v = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
			}
		}

		find();
		System.out.println(ans);

	}
	private static void find() {
		while(true){
			v = new int[n][n];
			list = new ArrayList<>();
			int [][]tmp=new int[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					tmp[i][j] = map[i][j];
				}
			}
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(v[i][j] == 0){
						v[i][j] = 1;
						list.add(new xy(i,j,map[i][j]));
						q.offer(new xy(i,j,map[i][j]));
						bfs();
						list.clear();
					}
				}
			}
			
			per = 0;
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(map[i][j] != tmp[i][j]){
						per = 1;
					}
				}
			}
			if(per==1){
				ans++;
			}
			else {
				break;
			}
		}
	}
	private static void bfs() {
		int cnt=1;
		while(!q.isEmpty()){
			xy a = q.poll();
			for(int i=0; i<4; i++){
				int nx = a.x + dx[i];
				int ny = a.y + dy[i];
				if(0 <= nx && nx < n && 0 <= ny && ny < n){
					int tmp = Math.abs(map[a.x][a.y] - map[nx][ny]);
					if(L <= tmp && tmp <= R && v[nx][ny] == 0){
						q.offer(new xy(nx,ny,map[nx][ny]));
						list.add(new xy(nx,ny,map[nx][ny]));
						v[nx][ny] = 1;
						cnt++;
					}
				}
			}
		}
		
		totalSum = 0;
		if(cnt==1){
			list = new ArrayList<>();
		}
		if(cnt>1){
			
			for(int i=0; i<list.size(); i++) totalSum += list.get(i).value;
			for(int i=0; i<list.size(); i++) map[list.get(i).x][list.get(i).y] = (totalSum/list.size());
		}



	}

}








