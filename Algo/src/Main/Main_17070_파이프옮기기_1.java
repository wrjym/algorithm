package Main;
import java.io.FileInputStream;
import java.util.Scanner;


public class Main_17070_파이프옮기기_1 {

	static int [][]map;
	static int []dx = {0,1,1};	// 우 우대각선 하 
	static int []dy = {1,1,0};
	static int n, ans;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/17070.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ans = 0;
		map = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0,1,0);

		System.out.println(ans);
	}

	private static void dfs(int x, int y, int nowDir) {
		if(x == n-1 && y == n-1){
			ans++;
			return ;
		}
		for(int dir=0; dir<3; dir++){
			if((dir == 0 && nowDir == 2) || (dir == 2 && nowDir == 0)){
				continue;
			}
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(nx >= n || ny >= n || map[nx][ny] == 1){
				continue;
			}
			if(dir == 1 && (map[x][y+1] == 1 || map[x+1][y] == 1)){
				continue;
			}
			dfs(nx,ny,dir);
		}

	}

}
