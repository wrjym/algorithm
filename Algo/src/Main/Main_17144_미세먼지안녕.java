package Main;
import java.util.*;
import java.io.*;
public class Main_17144_미세먼지안녕 {
	static int r,c,T;
	static int [][]map, tmpMap;
	static int []dx = {0,-1,0,1};
	static int []dy = {-1,0,1,0};
	static int []airX, airY;
	static Queue<Integer> q;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/17144.txt"));
		Scanner sc = new Scanner(System.in);

		r = sc.nextInt();
		c = sc.nextInt();
		T = sc.nextInt();
		airX = new int[2];
		map = new int[r][c];
		tmpMap = new int[r][c];
		q = new LinkedList<>();
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				map[i][j] = sc.nextInt();
			}
		}
		int tmpC = 0;
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(map[i][j] == -1){
					airX[tmpC++] = i;
				}
			}
		}
		for(int time=0; time<T; time++){
			확산();
			윗방향(airX[0]);
			아랫방향(airX[1]);
		}
		
		int sum = 0;
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(map[i][j] > 0){
					sum += map[i][j];
				}
			}
		}
		System.out.println(sum);
		sc.close();
	}
	private static void 아랫방향(int e) {
		int nx = e, ny = 0, dir=3;
		for(dir=3; dir<7; dir++){
			nx = e + dx[dir%4];
			ny = 0 + dy[dir%4];
			if(airX[1] <= nx && nx <= r && 0 <= ny && ny < c && map[nx][ny] >= 0){
				break;
			}
		}
		
		아랫방향dfs(nx,ny,dir%4);
		q.poll();
		아랫방향채우기dfs(nx,ny,dir%4);
	}
	private static void 아랫방향채우기dfs(int x, int y, int dir) {
		if(map[x][y] == -1 || q.isEmpty())
			return;
		else{
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(airX[1] <= nx && nx < r && 0 <= ny && ny < c){
				map[x][y] = q.poll();
				아랫방향채우기dfs(nx,ny,dir);
			}
			else
				아랫방향채우기dfs(x,y,(dir+3)%4);
		}
	}
	private static void 아랫방향dfs(int x, int y, int dir) {
		if(map[x][y] == -1)
			return;
		else{
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(airX[1] <= nx && nx < r && 0 <= ny && ny < c){
				q.offer(map[x][y]);
				map[x][y] = 0;
				아랫방향dfs(nx,ny,dir);
			}
			else
				아랫방향dfs(x,y,(dir+3)%4);
		}
		
	}
	private static void 윗방향(int e) {
		int nx=e,ny=0, dir=1;
		for(dir=1; dir<5; dir++){
			nx = e + dx[dir%4];
			ny = 0 + dy[dir%4];
			if(0 <= nx && nx <= airX[0] && 0 <= ny && ny < c && map[nx][ny] >= 0){
				break;
			}
		}
		윗방향dfs(nx,ny,dir%4);
		q.poll();
		윗방향채우기dfs(nx,ny,dir%4);
	}
	private static void 윗방향채우기dfs(int x, int y, int dir) {
		if(map[x][y] == -1 || q.isEmpty())
			return;
		else{
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(0 <= nx && nx <= airX[0] && 0 <= ny && ny < c){
				map[x][y] = q.poll();
				윗방향채우기dfs(nx,ny,dir);
			}
			else
				윗방향채우기dfs(x,y,(dir+1)%4);
		}
	}
	private static void 윗방향dfs(int x, int y, int dir) {
		if(map[x][y] == -1)
			return;
		else{
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(0 <= nx && nx <= airX[0] && 0 <= ny && ny < c){
				q.offer(map[x][y]);
				map[x][y] = 0;
				윗방향dfs(nx,ny,dir);
			}
			else
				윗방향dfs(x,y,(dir+1)%4);
		}
	}
	private static void 확산() {
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(map[i][j] > 0){
					int cnt=0;
					int nx = i;
					int ny = j;
					for(int dir=0; dir<4; dir++){
						nx = i + dx[dir];
						ny = j + dy[dir];
						if(0 <= nx && nx < r && 0 <= ny && ny < c){
							if(map[nx][ny] >= 0){
								tmpMap[nx][ny] += (map[i][j] / 5);
								cnt++;
							}
						}
					}
					tmpMap[i][j] = tmpMap[i][j] + map[i][j] - ((map[i][j] / 5)*cnt);
				}
			}
		}
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				map[i][j] = tmpMap[i][j];
				tmpMap[i][j] = 0;
			}
		}
		map[airX[0]][0] = -1;
		map[airX[1]][0] = -1;

	}
	private static void vm(int[][] map2) {
		System.out.println("==================");
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				System.out.print(map2[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
