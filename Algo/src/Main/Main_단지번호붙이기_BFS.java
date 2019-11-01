package Main;



import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main_단지번호붙이기_BFS {
	static class XY{
		public int x;
		public int y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}
	}
	public static int []dx = {0, -1, 0, 1};
	public static int []dy = {-1, 0 , 1, 0};
	public static boolean [][]v;
	public static int [][]map;
	public static int []ans;
	public static int T;
	public static int cnt=1;
	public static Queue<XY> q = new LinkedList();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/main.txt"));
		Scanner sc = new Scanner(System.in);

		T = Integer.parseInt(sc.nextLine());
		map = new int [T][T];
		v = new boolean[T][T];
		ans = new int[T];
		for(int i=0; i<T; i++){
			String a = sc.nextLine();
			for(int j=0; j<T; j++){
				map[i][j] = Integer.parseInt(a.substring(j, j+1));
			}
		}

		for(int i=0; i<T; i++){
			for(int j=0; j<T; j++){
				if(map[i][j] == 1){
					cnt++;
					q.offer(new XY(i,j));
					bfs(i,j);
					
				}
			}
		}
		//		for(boolean b[] : v) System.out.println(Arrays.toString(b));		
		for(int b[] : map) System.out.println(Arrays.toString(b));
		Arrays.sort(ans);
		System.out.println(cnt-1);
		for(int i=0; i<T; i++){
			if(ans[i] > 0){
				System.out.println(ans[i]);
			}
		}
	}
	private static void bfs(int x, int y) {
		int nx=0, ny=0;
		while(!q.isEmpty()){
			XY a = q.poll();
			for(int z=0; z<4; z++){
				nx = dx[z] + a.x;
				ny = dy[z] + a.y;
				if(0 <= nx && nx < T && 0 <= ny && ny < T ){
					if(map[nx][ny] == 1 && v[nx][ny] == false){
						map[nx][ny] = cnt;
						ans[cnt] ++;
						q.offer(new XY(nx,ny));
						v[nx][ny] = true;
					}
				}

			}
		}
	}
}

