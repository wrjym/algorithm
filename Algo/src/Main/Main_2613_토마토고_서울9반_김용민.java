package Main;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Main_2613_토마토고_서울9반_김용민 {
	static class XY{
		public int x;
		public int y;
		public int day;
		public XY(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	public static int map[][];
	public static boolean visit[][];
	public static int dx[] = {0, -1, 0, 1};
	public static int dy[] = {-1, 0, 1, 0};
	public static Queue<XY> q;
	public static int n,m,h;
	public static int max=0;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2613.txt"));
		Scanner sc = new Scanner(System.in);

		for(int tc=1; tc<=1; tc++){
			max = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[m][n];
			visit = new boolean[m][n];
			q = new LinkedList<XY>();
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					map[i][j] = sc.nextInt();
				}
			}
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					if(map[i][j] == 1){
						visit[i][j] = true;
						q.offer(new XY(i,j,0));
					}
				}
			}
			BFS();
			//			for(int []c : map) System.out.println(Arrays.toString(c));

			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					if(map[i][j] == 0){
						max = -1;
					}
				}
			}
			System.out.println(max);
		}
	}
	private static void BFS() {
		int nx=0, ny=0;
		while(!q.isEmpty()){
			XY a = q.poll();
			for(int i=0; i<4; i++){
				nx = a.x + dx[i];
				ny = a.y + dy[i];
				if(0 <= nx && nx < m && 0 <= ny && ny < n){
					if(map[nx][ny] == 0 && visit[nx][ny] == false){
						map[nx][ny] = a.day+1;
						if(max < a.day+1){
							max = a.day+1;
						}
						q.offer(new XY(nx,ny,a.day+1));
						visit[nx][ny] = true;
					}
				}
			}
		}
	}


}
