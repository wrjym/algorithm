package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_연구소 {

	static class xy{
		public int x;
		public int y;
		public int num;
		public xy(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}
		@Override
		public String toString() {
			return "xy [x=" + x + ", y=" + y + ", num=" + num + "]";
		}


	}
	public static int [][]map;
	public static int [][]tmpMap;
	public static int []seq;
	public static int [][]v;
	public static int n,m;
	public static int min;
	public static int []dx = {0,-1,0,1};
	public static int []dy = {-1,0,1,0};
	public static Queue<xy> q;
	public static ArrayList<xy> list;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		tmpMap = new int[n][n];
		list = new ArrayList<>();
		int count=0;
		min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2){
					list.add(new xy(i,j,count++));
				}
			}
		}
		//		if(list.size()==m){
		//			min = 0;
		//		}
		seq = new int[m];
		nCr(0,0);
		if(min == Integer.MAX_VALUE){
			System.out.println(-1);
		}
		else{
			System.out.println(min);
		}
	}
	private static void nCr(int idx, int cnt) {
		if(cnt==m){
			System.out.println(Arrays.toString(seq));
			v = new int[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(map[i][j]==1){
						tmpMap[i][j] = map[i][j];
						v[i][j] = -1;
					}
					else if(map[i][j]==2){
						tmpMap[i][j] = 0;
						v[i][j] = -1;
					}
					else{
						tmpMap[i][j] = 0;
					}
				}
			}
			q = new LinkedList<>();
			for(int k=0; k<seq.length; k++){
				for(int i=0; i<list.size(); i++){
					int x = list.get(i).x;
					int y = list.get(i).y;
					int num = list.get(i).num;
					if(seq[k]==num){
						q.offer(new xy(x,y,0));
						tmpMap[x][y]=5;
						v[x][y] = -1;
					}
				}
			}

			bfs();

			int max=0;
			int flag=1;
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(max < v[i][j] && map[i][j] != 2){
						max = v[i][j];
					}
					if(v[i][j]==0){
						flag=0;
					}
				}
			}
			if(flag==0){
				max = Integer.MAX_VALUE;
			}

			min = Math.min(min, max);

			return;
		}
		for(int i=idx; i<list.size(); i++){
			seq[cnt] = i;
			nCr(i+1,cnt+1);
		}
	}
	private static void bfs() {
		while(!q.isEmpty()){
			xy a = q.poll();
			for(int i=0; i<4; i++){
				int nx = a.x + dx[i];
				int ny = a.y + dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<n){
					if(tmpMap[nx][ny] != 1 && v[nx][ny]==0){
						v[nx][ny] = a.num+1;
						q.offer(new xy(nx,ny,a.num+1));
					}
					else if(tmpMap[nx][ny] != 1 && v[nx][ny] == -1){
						v[nx][ny] = a.num+1;
						q.offer(new xy(nx,ny,a.num+1));
					}
				}
			}
		}

	}

}
