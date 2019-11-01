package Main;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_15683_감시 {

	static class CCTV{
		int x,y;

		public CCTV(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "CCTV [x=" + x + ", y=" + y + "]";
		}
		
	}
	static int [][]map;
	static int [][]tmpMap;
	static int n,m,k;
	static int []seq;
	static ArrayList<CCTV> cctv;
	static int min;
	static int []dx = {0,-1,0,1};
	static int []dy = {-1,0,1,0};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/15683.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		String []tmps = tmp.split(" ");
		
		n = Integer.parseInt(tmps[0]);
		m = Integer.parseInt(tmps[1]);
		map = new int[n][m];
		tmpMap = new int[n][m];
		min = Integer.MAX_VALUE;
		cctv = new ArrayList<>();
		ArrayList<CCTV> five = new ArrayList<>();
		for(int i=0; i<n; i++){
			tmp = br.readLine();
			tmps = tmp.split(" ");
			for(int j=0; j<m; j++){
				map[i][j] = Integer.parseInt(tmps[j]);
				if(1 <= map[i][j] && map[i][j] <= 4){
					cctv.add(new CCTV(i, j));
					k++;
				}
				else if ( map[i][j] == 5)
					five.add(new CCTV(i, j));
			}
		}
		for(int i=0; i<five.size(); i++)
			setFive(five.get(i).x, five.get(i).y);
		seq = new int[k];
		dfs(0);
		
		System.out.println(min);
	}

	private static void setFive(int x, int y) {
		for(int i=0; i<4; i++){
			int nx=x,ny=y;
			while(true){
				nx = nx + dx[i];
				ny = ny + dy[i];
				
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(map[nx][ny] == 0)
						map[nx][ny] = 5;
					else if(map[nx][ny] == 6)
						break;
				}
				else
					break;
			}
		}
	}

	private static void dfs(int cnt	) {
		if(cnt == k)	{
			for(int i=0; i<k; i++)
				setMap(cctv.get(i), seq[i], 0, 9);
			int count = 0;
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(map[i][j] == 0)
						count++;
				}
			}
			for(int i=0; i<k; i++)
				setMap(cctv.get(i), seq[i], 9, 0);
			min = Math.min(min, count);
			return ;
		}
		
		for(int dir=0; dir<4; dir++){
			seq[cnt] = dir;
			dfs(cnt+1);
		}
	}

	private static void setMap(CCTV cctv2, int dir, int before, int marking) {
		CCTV c = cctv2;
		int nx = c.x, ny = c.y;
		switch(map[c.x][c.y]){
		case 1:
			checkingLine(nx,ny, dir,before,marking);
			break;
		case 2:
			for(int i=0; i<3; i+=2)
				checkingLine(nx,ny, (dir+i)%4,before,marking);
			break;
		case 3:
			for(int i=0; i<2; i++)
				checkingLine(nx,ny, (dir+i)%4,before,marking);
			break;
		case 4:
			for(int i=0; i<3; i++)
				checkingLine(nx,ny, (dir+i)%4,before,marking);
			break;			
		}
	}

	private static void checkingLine(int nx, int ny, int dir,int before, int making) {
		while(true){
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			if(0 <= nx && nx < n && 0 <= ny && ny < m){
				if(map[nx][ny] == before)
					map[nx][ny] = making;
				else if(map[nx][ny] == 6)
					break;
			}
			else
				break;
		}
	}
}
