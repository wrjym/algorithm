package Main;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class XY{
	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int x;
	public int y;

}
public class Main1840_치즈_서울9반_김용민 {
	public static int [][] map;
	public static boolean [][]v;
	public static Queue<XY> q = new LinkedList();
	public static int dx[] = {0, -1, 0, 1};
	public static int dy[] = {-1, 0, 1, 0};
	public static int n,m;
	public static int min;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/치즈.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		min = n*m;
		map = new int[n][m];
		v = new boolean[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m ; j++){
				map[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		int cnt = 1;
		while(cnt>0){
			q.offer(new XY(0,0));
			v[0][0] = true;
			BFS();
			cnt = 0;
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(map[i][j] >= 2){
						map[i][j] =	0;
						cnt++;
					}
					//					if(0 < map[i][j] && map[i][j] <= 2){
					//						cnt++;
					//						map[i][j] = 1;
					//					}
				}
			}

			System.out.println(cnt);
			v = new boolean[n][m];
			if(cnt!=0){
				ans++;
				if(cnt < min){
					min = cnt;
				}
			}
			

			for(int a[] :map) System.out.println(Arrays.toString(a));
			System.out.println();
		}

		System.out.println(ans + " : " + min);
		//		for(int a[] :map) System.out.println(Arrays.toString(a));
	}
	private static void BFS() {
		int nx=0, ny=0;

		while(!q.isEmpty()){
			XY a = q.poll();
			for(int i=0; i<4; i++){
				nx = a.x + dx[i];
				ny = a.y + dy[i];

				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(map[nx][ny] == 0 && v[nx][ny] == false){
						q.offer(new XY(nx,ny));
						v[nx][ny] = true;
					}
					else if(map[nx][ny] >=1){
						map[nx][ny]++;
					}
				}
			}

		}

	}

}
