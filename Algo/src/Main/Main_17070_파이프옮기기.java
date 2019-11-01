package Main;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main_17070_파이프옮기기 {

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
		switch(nowDir){
		case 0:	//가로
			for(int dir=0; dir<2; dir++){
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < n){
					if(map[nx][ny] == 0 ){
						if(dir == 1 && map[x+1][y]==0 && map[x][y+1]==0){
							dfs(nx,ny,dir);
						}
						else if(dir != 1){
							dfs(nx,ny,dir);
						}
					}
				}
			}
			break;
		case 1:	//대각선
			for(int dir=0; dir<3; dir++){
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < n){
					//대각선으로 올때 가로나 세로는 원래 오던 방향인 대각선이 0이여야 갈 수 있다.
					if(map[nx][ny] == 0){
						if(dir == 1 && map[x+1][y]==0 && map[x][y+1]==0){
							dfs(nx,ny,dir);
						}
						else if(dir != 1){
							dfs(nx,ny,dir);
						}
					}
				}
			}
			break;
		case 2:	//세로
			for(int dir=2; dir>0; dir--){
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < n){
					if(map[nx][ny] == 0){
						if(dir == 1 && map[x+1][y]==0 && map[x][y+1]==0){
							dfs(nx,ny,dir);
						}
						else if(dir != 1){
							dfs(nx,ny,dir);
						}
					}
				}
			}
			break;
		}

	}


}
