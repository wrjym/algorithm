package Main;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class XYZ{
	public int z;
	public int x;
	public int y;
	public int day;
	public XYZ(int z, int x, int y,int day) {
		super();
		this.z = z;
		this.x = x;
		this.y = y;
		this.day = day;
	}
	@Override
	public String toString() {
		return "XYZ [z=" + z + ", x=" + x + ", y=" + y + ", day=" + day + "]";
	}
}
public class Main_2614_토마토초_서울9반_김용민 {
	public static int n,m,h;
	public static Queue<XYZ> q = new LinkedList<>();
	public static int [][]dxyz = {{0,0,-1}, {0,-1,0}, {0,0,1} , {0,1,0}, {-1,0,0}, {1,0,0}};
	public static int map[][][];
	public static boolean visit[][][];
	public static int max =0;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2613.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		h = sc.nextInt();
		max = 0;
		map = new int[h][m][n];
		visit = new boolean[h][m][n];
		for(int z=0; z<h; z++){
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					map[z][i][j] = sc.nextInt();
					if(map[z][i][j] == 1){
						q.offer(new XYZ(z,i,j,0));
						visit[z][i][j] = true;
					}
					System.out.print(map[z][i][j] + " ");
				}
				System.out.println();
			}
		}
		dfs();
		for(int z=0; z<h; z++){
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					if(map[z][i][j]==0){
						max = -1;
					}
				}
			}
		}
		for(int[][]a : map) for(int []aa : a) System.out.println(Arrays.toString(aa));
		System.out.println(max);

	}
	private static void dfs() {
		int nx,ny,nh;
		while(!q.isEmpty()){
			XYZ a = q.poll();
			int cnt = 1;
			for(int i=0; i<6; i++){
				nh = a.z + dxyz[i][0];
				nx = a.x + dxyz[i][1];
				ny = a.y + dxyz[i][2];
//								System.out.println("nh : " + nh + " nx : " + nx + " ny : " + ny);
				if(0 <= nx && nx < m && 0 <= ny && ny < n && 0 <= nh && nh < h){
					if(map[nh][nx][ny]==0 && visit[nh][nx][ny] == false){
						map[nh][nx][ny] = a.day + cnt;
						if((a.day+cnt) > max){
							max = a.day+cnt;
						}
						q.offer(new XYZ(nh,nx,ny,a.day+cnt));
						visit[nh][nx][ny] = true;
					}
				}

			}


		}
	}
}
