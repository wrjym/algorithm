package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_아기상어 {
	static class Shark{
		int x, y, size, time;
		public Shark(int x, int y, int size, int time) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", size=" + size + ", time=" + time + "]";
		}
	}

	static int n;
	static ArrayList<Shark> li;
	static int [][]map;
	static int [][]v;
	static Shark shark;
	static Queue<Shark> q;
	static int eat;
	static int ans;
	static int []dx = {-1,0,0,1};
	static int []dy = {0,-1,1,0};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/16236.txt"));
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
		v = new int[n][n];
		q = new LinkedList<>();

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9){
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}
		eat = 0;
		q = new LinkedList<>();
		q.offer(shark);
		bfs();

		System.out.println(shark.time);
		sc.close();
	}
	private static void VM(int[][] is) {
		System.out.println();
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(is[i][j] + "\t");
			}
			System.out.println();

		}
	}
	private static void bfs() {
		while(!q.isEmpty()){
			li = new ArrayList<>();
			clearMap(v);
			v[shark.x][shark.y] = shark.time;
			int abletime = Integer.MAX_VALUE;
			while(!q.isEmpty()){
				Shark s = q.poll();
				if(abletime < s.time)
					continue;
				for(int dir=0; dir<4; dir++){	//상 좌 우 하 방향으로 이동.
					int nx = s.x + dx[dir];
					int ny = s.y + dy[dir];
					if(0 <= nx && nx < n && 0 <= ny && ny < n ){
						if(0 < map[nx][ny]){	//물고기가 위치하는 
							if(map[nx][ny] < shark.size && v[nx][ny]==0){
								li.add(new Shark(nx,ny, shark.size, s.time+1));
								abletime = s.time;
							}
							else if(map[nx][ny] == shark.size && v[nx][ny]==0){	//같은 크기의 물고기 지나가기.
								v[nx][ny] = s.time+1;
								q.offer(new Shark(nx,ny,shark.size, s.time+1));
							}
						}
						else if(map[nx][ny] == 0 && v[nx][ny]==0){	//물고기가 존재하지 않기 때문에 그냥 지나가기 위한 조건
							v[nx][ny] = s.time+1;
							q.offer(new Shark(nx,ny,shark.size, s.time+1));
						}
					}
				}
			}
			Collections.sort(li,new Comparator<Shark>() {
				@Override
				public int compare(Shark o1, Shark o2) {
					if(o1.x < o2.x)
						return -1;
					else if(o1.x > o2.x)
						return 1;
					else {
						if(o1.y < o2.y){
							return -1;
						}
						else
							return 1;
					}
				}
			});
			if(li.size()>0){
				Shark s = li.get(0);
				shark = s;
				map[s.x][s.y] = 0;
				q.clear();
				q.offer(s);
				eat++;
			}
			
			if(eat == shark.size){
				shark = new Shark(shark.x, shark.y, eat+1, shark.time);
				eat = 0;
			}
		}
	}
	private static void clearMap(int[][] is) {
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				is[i][j] = 0;
			}
		}
	}

}
