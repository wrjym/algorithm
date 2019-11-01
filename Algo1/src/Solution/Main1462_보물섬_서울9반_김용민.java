package Solution;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class XY{
	public int row;	//가로
	public int col;	//세로
	public int cnt;	//현재까지 얼마나 움직였는지 알려주는 cnt
	public XY(int row, int col, int cnt) {	//생성
		super();
		this.col = col;
		this.row = row;
		this.cnt = cnt;
	}
}
public class Main1462_보물섬_서울9반_김용민 {
	public static char[][] map;
	public static int[][] check;
	public static int []dx = {0, -1, 0, 1};
	public static int []dy = {-1, 0, 1, 0};
	public static int max=0;
	public static Queue<XY> queue = new LinkedList<XY>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x= sc.nextInt();
		int y= sc.nextInt();
		sc.nextLine();
		map = new char[x][y];
		check = new int[x][y];
		for(int i=0; i<x; i++){
			String a = sc.nextLine();
			for(int j=0; j<y; j++){
				map[i][j] = a.charAt(j);
			}
		}
		for(int i=0; i<x; i++){
			for(int j=0; j<y; j++){
				if(map[i][j] == 'L'){
					bfs(i,j);
					check = new int[x][y];
				}

			}
		}
		System.out.println(max);
	}

	private static void bfs(int i, int j) {
		int cnt=0;
		queue.add(new XY(i,j,cnt));
		check[i][j] = 1;
		
		
		while(!queue.isEmpty()){
			int a = queue.peek().row;
			int b = queue.peek().col;
			int c = queue.peek().cnt;
//			System.out.println("a : " + a + "   b : " + b);
			if(max < c){
				max = c;
			}
			queue.poll();
			for(int k=0; k<4; k++){
				int x = a + dx[k];
				int y = b + dy[k];
				if(0 <= x && x < map.length && 0 <= y && y < map[0].length 
						&& check[x][y]==0 && map[x][y] == 'L'){
					queue.add(new XY(x,y,(c+1)));
					check[x][y] = 1;
				}
				
			}
		}
	}



}
