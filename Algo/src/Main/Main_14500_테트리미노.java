package Main;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main_14500_테트리미노 {
	static int n,m;
	static int [][]map;
	static int [][]v;
	static int max;
	static int []dx = {0,-1,0,1,0,-1};
	static int []dy = {-1,0,1,0,-1,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/14500.txt"));
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		v = new int[n][m];
		max = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				fuckmoyang(i,j);
				v[i][j] = 1;
				dfs(i,j,1,map[i][j]);
				v[i][j] = 0;

			}
		}
		System.out.println(max);
		sc.close();
	}

	private static void dfs(int x, int y, int cnt, int sum) {
		if(cnt == 4){
			max = Math.max(max, sum);
			return ;
		}
		for(int dir=0; dir<4; dir++){
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if(0 <= nx && nx < n && 0 <= ny && ny < m){
				if(v[nx][ny] == 0){
					v[nx][ny] = 1;
					dfs(nx, ny, cnt+1, sum+map[nx][ny]);
					v[nx][ny] = 0;
				}
			}

		}

	}

	private static void fuckmoyang(int x, int y) {
		for(int i=0; i<4; i++){
			int sum = map[x][y];
			for(int j=i; j<i+3; j++){
				int nx = x + dx[j];
				int ny = y + dy[j];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					sum += map[nx][ny];
				}
			}
			max = Math.max(max, sum);
		}
	}

}








