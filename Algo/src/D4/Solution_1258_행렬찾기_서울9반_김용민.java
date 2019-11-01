package D4;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * 행렬찾기
 * 
 * 문제 풀이
 * 1. n*n의 2차원 배열에 있고, 그 안에 있는 박스들의 크기를 출력해야 한다.
 * 2. 각 박스의 가로, 세로값을 구한다.
 * 3. 박스의 가로 세로의 곱을 비교하여 낮은 순으로 출력한다.
 * 4. 만약 박스의 곱이 같은 경우에는 세로값이 낮은 순으로 출력한다.
 * 
 * 입력
 * n값
 * n*n의 안에 있는 숫자값을 받는다.
 *
 * 해결: 
 * 데이터를 처리할 int map[][] 배열, 방문처리할 boolean v[][] 배열.
 * bfs를 처리할때 Queue에 담아줄 XY class
 * 가로, 세로값을 처리해줄 Box class
 * 데이터를 map에다 넣어준다. for문*2 사용.
 * 아파트 단지묶기와 같이 BFS로 각 사각형을 셋팅하고 그 값들의 행,열을 찾는다.
 * BFS가 돌때, 가로세로값을 찾아서 Arraylist<Box>에 담아둔다.
 * 이후 list에 있는 것들을 Collections.sort(Comparator)를 사용해서 비교해준다.
 * 만약 o1 < o2 => -1		오름차순.	o1 < o2 => 1
 * 
 * ex)
 * 9
 * 1 1 3 2 0 0 0 0 0
 * 3 2 5 2 0 0 0 0 0
 * 2 3 3 1 0 0 0 0 0
 * 0 0 0 0 4 5 5 3 1
 * 1 2 5 0 3 6 4 2 1
 * 2 3 6 0 2 1 1 4 2
 * 0 0 0 0 4 2 3 1 1
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 
 * 1 1 1 1 0 0 0 0 0
 * 1 1 1 1 0 0 0 0 0
 * 1 1 1 1 0 0 0 0 0
 * 0 0 0 0 1 1 1 1 1
 * 1 1 1 0 1 1 1 1 1
 * 1 1 1 0 1 1 1 1 1
 * 0 0 0 0 1 1 1 1 1
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 
 * 2 2 2 2 0 0 0 0 0
 * 2 2 2 2 0 0 0 0 0
 * 2 2 2 2 0 0 0 0 0
 * 0 0 0 0 3 3 3 3 3
 * 4 4 4 0 3 3 3 3 3
 * 4 4 4 0 3 3 3 3 3
 * 0 0 0 0 3 3 3 3 3
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 
 * #1 3 2 3 3 4 4 5
 * 
 * 출력
 * list의 사이즈와 list를 sort한 값들을 출력해주면 된다.
 * 
 * 
 */
class XY{
	public int x;
	public int y;
	public int cnt;
	public XY(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}
class Box{
	public int col;
	public int row;
	public int mulCR;
	public Box() {}
	public Box(int col, int row, int mulCR) {
		this.col = col;
		this.row = row;
		this.mulCR = mulCR;
	}

}
public class Solution_1258_행렬찾기_서울9반_김용민 {
	public static int [][] map;
	public static boolean [][]v;
	public static int[] dx = {0, -1, 0 ,1};
	public static int[] dy = {-1, 0, 1, 0};
	public static int cnt = 1;
	public static int n;
	public static Queue<XY> q = new LinkedList();
	public static ArrayList<Box> list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1258.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			list = new ArrayList<>();
			map = new int[n][n];
			v = new boolean[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					map[i][j] = sc.nextInt();
					if(map[i][j] > 0){
						map[i][j] = 1;
					}
				}
			}

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(map[i][j] == 1 && v[i][j] == false){
						cnt++;
						q.offer(new XY(i,j,cnt));
						bfs(i,j);

					}
				}
			}
//			for(int a[] : map) System.out.println(Arrays.toString(a));




			System.out.print("#" + tc + " " + list.size() + " ");
			Collections.sort(list, new Comparator<Box>() {
				public int compare(Box o1, Box o2) {
					
					if(o1.mulCR < o2.mulCR){
						return -1;
					}
					else if(o1.mulCR < o2.mulCR){
						return 1;
					}
					else{
						if(o1.col < o2.col){
							return -1;
						}
						else{
							return 1;
						}
					}
					
				};
			});
			for(int i=0; i<list.size(); i++){
				System.out.print(list.get(i).col + " " + list.get(i).row + " ");
			}
			System.out.println();
			//			for(boolean b[] : v) System.out.println(Arrays.toString(b));






		}
	}

	private static void bfs(int x, int y) {
		int nx=0, ny=0;
		int maxCol=0;
		int maxRow=0;
		while(!q.isEmpty()){
			XY a = q.poll();
			for(int z=0; z<4; z++){
				nx = dx[z] + a.x;
				ny = dy[z] + a.y;

				if(0 <= nx && nx < n && 0 <= ny && ny < n ){
					if(map[nx][ny] == 1 && v[nx][ny] == false){
						if(maxCol < nx){
							maxCol = nx;
						}
						if(maxRow < ny){
							maxRow = ny;
						}

						map[nx][ny] = cnt;
						q.offer(new XY(nx,ny,cnt));
						v[nx][ny] = true;
					}
				}

			}
		}
		int col=maxCol-x+1;
		int row=maxRow-y+1;

		list.add(new Box(col,row,col*row));
	}

}
