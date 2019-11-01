package D4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제해석
 * 정사각형(N^2)의 방에 숫자들이 랜덤으로 적혀있다.
 * 이 값들은 N^2의 크기가 최대 1이 최소이다.
 * 한 지점에서 좌표를 움직일때, 어느 좌표에 있을때 가장 많이 움직여야 하나.
 * 단, 좌표를 움직일때, 내 방보다 움직일 방이 숫자가 1 더 커야 한다.
 * 
 * 입력:
 * 테스트케이스 T
 * 하나의 정수 N
 * 각 방마다의 숫자들이 주어진다.
 * 
 * 해결 방법:
 * 필요한 map[][]과 방문의 v[][] 움직임을 확인하는 cnt[][]을 사용한다.
 * 좌표를 다 입력받고 0,0부터 움직이면서 좌표에 나보다 1큰 좌표에 들어간다.의 개념의 BFS를 생각해본다.
 * 움직일때마다 cnt의 방에다 추가해줘서 움직임을 체크해준다.
 * 조건식이 중요한데 값이 크면 큰값을 넣으면 되지만 만약에 동률이 되면 maxValue를 사용하여 더 작은 수의 값을 저장한다.
 * 
 * 출력:
 * 케이스마다 많은 방은 방문한 방의 수와 그 방에서 움직일 수 있 방의 수.
 */
class XYZ{
	public int x;
	public int y;

	public XYZ(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution_1861_정사각형방_서울9반_김용민 {
	public static int n;
	public static int max, maxValue;
	public static Queue<XYZ> q = new LinkedList();
	public static int [][]map;
	public static int [][]cnt;
	public static int [][]dxy = {{0,-1}, {-1,0}, {0,1} , {1,0}};
	public static boolean[][]v;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1861.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			map = new int[n][n];
			v = new boolean[n][n];
			max=0;
			maxValue=Integer.MAX_VALUE;
			cnt = new int[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					map[i][j] = sc.nextInt();
				}
			}

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					q.offer(new XYZ(i,j));
//					v[i][j] = true;
					bfs();
//					v = new boolean[n][n];
					
				}
			}

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(cnt[i][j] > max){
						max = cnt[i][j];
						maxValue = map[i][j];
					}
					else if(cnt[i][j] == max && maxValue > map[i][j]){
						max = cnt[i][j];
						maxValue = map[i][j];
					}
				}
			}
//			for(int a[]:cnt) System.out.println(Arrays.toString(a));
			System.out.println("#" + tc + " " + maxValue + " " + (max+1));
		}
	}

	private static void bfs() {
		int nx=0, ny=0;
		while(!q.isEmpty()){
			XYZ a = q.poll();
			for(int i=0; i<4; i++){
				nx = a.x + dxy[i][0];
				ny = a.y + dxy[i][1];
				if(0 <= nx && nx < n && 0 <= ny && ny < n){
					if(map[a.x][a.y] == (map[nx][ny]+1) /*&& v[nx][ny] == false*/){
						q.offer(new XYZ(nx,ny));
//						v[nx][ny] = true;
						cnt[nx][ny] += 1;
					}
				}
			}
		}
	}

}
