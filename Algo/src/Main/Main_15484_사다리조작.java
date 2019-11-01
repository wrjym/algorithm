package Main;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main_15484_사다리조작 {

	static int [][]map;

	static int row,col,m,k;
	static int min;
	static int []dx = {0,0,1};
	static int []dy = {-1,1,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/15484.txt"));
		Scanner sc = new Scanner(System.in);
		col = sc.nextInt()*2;
		m = sc.nextInt();
		row = sc.nextInt()+2;

		map = new int[row][col];
		for(int i=0; i<m; i++){
			int x = sc.nextInt();
			int y = sc.nextInt()*2;
			map[x][y] = 1;
		}
		min = 4;
		for(int i=0; i<min; i++){
			k = i;
			dfs(1,2,0);
		}

		if(min == 4){
			System.out.println(-1);
		}
		else{
			System.out.println(min);
		}
		sc.close();
	}
	private static void dfs(int x, int y, int cnt) {
		if(cnt == k){
			boolean b = true;
			for(int i=1; i<col; i+=2){
				if(b)
					b = check(i);
				else	//중간에 하나라도 문제가 생기면. 바로 종료.
					return ;
			}
			if(b){
				min = Math.min(min, k);
			}
			return ;
		}

		if(1 <= x && x < row-1 && 2 <= y && y < col){
			if(map[x][y] != 0){
				if(y+2 < col)
					dfs(x, y+2, cnt);
				else
					dfs(x+1, 2, cnt);
			}
			else{	//map이 0이여서 값을 넣을 수 있을때.
				if(y+2 < col)
					dfs(x, y+2, cnt);
				else
					dfs(x+1, 2, cnt);
				map[x][y] = 1;
				if(y+2 < col)
					dfs(x, y+2, cnt+1);
				else
					dfs(x+1, 2, cnt+1);
				map[x][y] = 0;

			}
		}
		else{
			return ;
		}

	}
	private static boolean check(int c) {
		int nx = 1;
		int ny = c;
		//		System.out.println("현재 위치 : " + c);
		while(true){
			for(int dir=0; dir<2; dir++){
				ny = ny + dy[dir];
				if(1 <= ny && ny < col){
					if(map[nx][ny] == 1){
						ny = ny + dy[dir];
						break;
					}
					else if(map[nx][ny] == 0){
						ny = ny - dy[dir];
					}
				}
				else
					ny = ny - dy[dir];
			}
			nx = nx + 1;

			if(nx == row){
				break;
			}
		}

//		System.out.println("종료시점 : " + c + " " + ny);
		if(c == ny){
			return true;
		}
		else{
			return false;
		}
	}
	private static void vm() {
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
