package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_치킨배달 {
	static class xyc{
		public int x;
		public int y;
		public int n;
		public xyc(int x, int y, int n) {
			super();
			this.x = x;
			this.y = y;
			this.n = n;
		}
		@Override
		public String toString() {
			return "xyc [x=" + x + ", y=" + y + ", n=" + n + "]";
		}
	}
	public static int min;
	public static int [][]v;
	public static int []dx = {0,-1,0,1};
	public static int []dy = {-1,0,1,0};
	public static int N,M;
	public static int [][]map;
	public static int [][]tmpMap;
	public static int []seq;
	public static Queue<xyc> q;
	public static ArrayList<xyc> list;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt()+1;
		M = sc.nextInt();
		
		seq = new int[M];
		map = new int[N][N];
		tmpMap = new int[N][N];
		list = new ArrayList<>();
		min = Integer.MAX_VALUE;
		int cnt=0;
		for(int i=1; i<N; i++){
			for(int j=1; j<N; j++){
				map[i][j] = sc.nextInt();
				if(map[i][j]==2){
					list.add(new xyc(i,j,cnt++));
				}
			}
		}
		dfs(0,0);
		System.out.println(min);
	}
	private static void dfs(int idx,int cnt) {
		if(cnt == M){
//			System.out.println(Arrays.toString(seq));
			ArrayList<xyc> li = new ArrayList<>();
			v = new int[N][N];
			q = new LinkedList();
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(map[i][j] == 1){
						tmpMap[i][j] = map[i][j];
						li.add(new xyc(i,j,1));
					}
					else{
						tmpMap[i][j] = 0;
					}
				}
			}
			for(int i=0; i<seq.length; i++){
				for(int j=0; j<list.size(); j++){
					if(seq[i] == list.get(j).n){
						tmpMap[list.get(j).x][list.get(j).y] = 2;
						q.offer(new xyc(list.get(j).x,list.get(j).y,1));
					}
				}
			}
			bfs();
			int sum = 0;
			for(int i=0; i<li.size(); i++){
				sum += tmpMap[li.get(i).x][li.get(i).y];
			}
//			System.out.println(sum);
			min = Math.min(min, sum);
			
			return ;
		}
		for(int i=idx;i<list.size(); i++){
			seq[cnt] = i;
			dfs(i+1,cnt+1);
			seq[cnt] = 0;
		}
		
	}
	private static void bfs() {
		while(!q.isEmpty()){
			xyc a = q.poll();
			for(int i=0; i<4; i++){
				int nx = a.x + dx[i];
				int ny = a.y + dy[i];
				if(1 <= nx && nx < N && 1 <= ny && ny < N){
					if(tmpMap[nx][ny] != 2 && v[nx][ny] == 0){
						v[nx][ny] = 1;
						tmpMap[nx][ny] = a.n;
						q.offer(new xyc(nx,ny,a.n+1));
					}
					else if(tmpMap[nx][ny] == 1 && v[nx][ny] == 0){
						v[nx][ny] = 1;
						tmpMap[nx][ny] = a.n+1;
					}
				}
			}
		}
	}
	
	

}
