package D4;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1949_등산로조성 {
	static class rc_1949{
		public int x;
		public int y;
		public int now;
		public int cnt;
		public boolean check;
		public rc_1949(int x, int y,int now, int cnt, boolean check) {
			super();
			this.x = x;
			this.y = y;
			this.now = now;
			this.cnt = cnt;
			this.check = check;
		}

		public int getNow() {
			return now;
		}
		public void setNow(int now) {
			this.now = now;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getCnt() {
			return cnt;
		}
		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
		public boolean isCheck() {
			return check;
		}
		public void setCheck(boolean check) {
			this.check = check;
		}

		@Override
		public String toString() {
			return "rc_1949 [x=" + x + ", y=" + y + ", now=" + now + ", cnt=" + cnt + ", check=" + check + "]";
		}


	}
	public static int [][]map;
	public static int [][]v;
	public static int []dx = {0,-1,0,1};
	public static int []dy = {-1,0,1,0};
	public static int n;
	public static int k;
	public static int ans;
	public static ArrayList<rc_1949> li;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1949.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int max = 0;
			n = sc.nextInt();
			k = sc.nextInt();
			map = new int[n][n];
			v = new int [n][n];
			li = new ArrayList<>();
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					map[i][j] = sc.nextInt();
					max = Math.max(max, map[i][j]);
				}
			}

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(map[i][j] == max){
						li.add(new rc_1949(i, j, max, 0, false));
					}
				}
			}
			ans = 0;
			for(int i=0; i<li.size(); i++){
				rc_1949 rc = li.get(i);
				v = new int[n][n];
				v[rc.x][rc.y] = 1;
				dfs(rc.x, rc.y, rc.now, rc.cnt+1, false);

				//				System.out.println("================");
				//				System.out.println(rc);

			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void dfs(int x, int y, int now, int cnt, boolean check) {

		ans = Math.max(ans, cnt);
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < n && 0 <= ny && ny < n){
				if(!check){
					if(map[nx][ny] < now && v[nx][ny] == 0){
						v[nx][ny] = 1;
						dfs(nx,ny,map[nx][ny],cnt+1,false);
						v[nx][ny] = 0;
					}
					else{
						for(int j=0; j<=k; j++){
							if(map[nx][ny]-j < now && v[nx][ny] == 0){
								v[nx][ny] = 1;
								int before = map[nx][ny];
								map[nx][ny] -= j;
								dfs(nx,ny,map[nx][ny],cnt+1,true);
								map[nx][ny] = before;
								v[nx][ny] = 0;
							}
						}
					}
				}
				else {
					if(map[nx][ny] < now && v[nx][ny] == 0){	//나보다 작은애한테만 가야한다.
						v[nx][ny] = 1;
						dfs(nx,ny,map[nx][ny],cnt+1,check);
						v[nx][ny] = 0;
					}
				}
			}
			
		}
	}
	private static void view() {
		System.out.println();
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
	}


}
