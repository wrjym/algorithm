package 못푼문제;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2105_디저트카페 {
	static int [][]map;
	static int [][]v;
	static int n,max;
	static int []desert;
	static int []dx = {1,1,-1,-1};
	static int []dy = {1,-1,-1,1};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/2105.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			v = new int[n][n];
			max = Integer.MIN_VALUE;
			int maxV = 0;
			for(int i=0; i<n; i++){
				String tmp = br.readLine();
				String []tmps = tmp.split(" ");
				for(int j=0; j<n; j++){
					map[i][j] = Integer.parseInt(tmps[j]);
					maxV = Math.max(maxV, map[i][j]);
				}
			}
			desert = new int[maxV+1];
//			vm(map);
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					dfs(i,j,0,0,0);
				}
			}
			System.out.println("#" + tc + " " + max);
		}

	}

	private static void dfs(int x, int y, int row, int col, int dir) {
		if(0 > x || x > n || 0 > y || y >= n)	//범위값을 벗어난 경우.
			return;
		if(dir == 2){
			if(col < 2 || row < 1)
				return ;
			vm(v);
			int nx = x-1;
			int ny = y+1;
			int []seq = new int[desert.length];
			for(int i=0; i<seq.length; i++)
				seq[i] = desert[i];

			for(int i=0; i<row; i++){
				nx = nx + dx[2];
				ny = ny + dy[2];
				if(0 <= nx && nx < n && 0 <= ny && ny < n){
					if(seq[map[nx][ny]]==0){
						seq[map[nx][ny]] = 1;
					}
					else
						return;
				}
				else
					return;
			}

			for(int i=0; i<col-2; i++){
				nx = nx + dx[3];
				ny = ny + dy[3];
				if(0 <= nx && nx < n && 0 <= ny && ny < n){
					if(seq[map[nx][ny]]==0){
						seq[map[nx][ny]] = 1;
					}
					else
						return;
				}
				else{
					return;
				}
			}

			int sum = 0;
			for(int i=0; i<seq.length; i++){
				if(seq[i] == 1)
					sum++;
			}
			max = Math.max(max,sum);
			return ;
		}
		else{
			if(desert[map[x][y]] == 0){
				dfs(x,y,row,col,dir+1);
				v[x][y] = 1;
				desert[map[x][y]] = 1;
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < n){
					if(dir == 0){
						dfs(nx, ny, row+1, col, dir);
					}
					else{
						dfs(nx, ny, row, col+1, dir);
					}
				}
				v[x][y] = 0;
				desert[map[x][y]] = 0;
			}
		}
	}

	private static void vm(int[][] m2) {
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(m2[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
