package 못푼문제;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_13460_구슬탈출2 {
	static class rc_13460 {
		public int x;
		public int y;
		public int dir;
		public int cnt;
		public rc_13460(int x, int y, int dir, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "rc_13460 [x=" + x + ", y=" + y + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
	}

	static class rc{
		public int x;
		public int y;
		public rc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "check_rc [x=" + x + ", y=" + y + "]";
		}
	}
	public static ArrayList<rc_13460> list;
	public static int n,m;
	public static int min;
	public static int fx, fy;
	public static int []dx = {0,-1,0,1};
	public static int []dy = {-1,0,1,0};
	public static String [][]map;
	public static String [][]tmpMap;
	public static int []seq;
	public static int ans;
	public static String OT, TT;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/13460.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new String [n][m];
		tmpMap = new String[n][m];
		list  = new ArrayList<>();
		sc.nextLine();
		for(int i=0; i<n; i++){
			String a = sc.nextLine();
			for(int j=0; j<m; j++){
				map[i][j] = a.charAt(j)+"";
				if(map[i][j].equals("R")){
					list.add(new rc_13460(i,j,0,0));
				}
				if(map[i][j].equals("B")){
					list.add(new rc_13460(i,j,0,0));

				}
				if(map[i][j].equals("O"))
				{
					fx = i;
					fy = j;
				}
			}
		}
		min = 10;
		seq = new int[min+1];
		ans = Integer.MAX_VALUE;

		OT = map[list.get(0).x][list.get(0).y];
		TT = map[list.get(1).x][list.get(1).y];

		dfs(0);

		if(ans == Integer.MAX_VALUE){
			System.out.println(-1);
		}
		else{
			System.out.println(ans);
		}
		sc.close();

	}
	private static void dfs(int cnt) {
		if(cnt > min){
			//			System.out.println(Arrays.toString(seq));
			for(int i=0; i<min; i++){
				int dir = seq[i];
				int ax = list.get(0).x;
				int ay = list.get(0).y;
				int bx = list.get(1).x;
				int by = list.get(1).y;
				boolean a = false;
				boolean b = false;
				while(true){
					if(!a){
						ax = ax + dx[dir];
						ay = ay + dy[dir];
						if(0 <= ax && ax < n && 0 <= ay && ay < m){
							if(tmpMap[ax][ay].equals("#")){
								ax = ax - dx[dir];
								ay = ay - dy[dir];
								a = true;
							}
							else if(tmpMap[ax][ay].equals(TT) ){
								ax = ax - dx[dir];
								ay = ay - dy[dir];
								a = true;
							}
							else if(tmpMap[ax][ay].equals("O"))
								a = true;
						}
						else 
							a = true;
						tmpMap[ax][ay] = OT;
					}
					if(!b){
						tmpMap[bx][by] = ".";
						bx = bx + dx[dir];
						by = by + dy[dir];
						if(0 <= bx && bx < n && 0 <= by && by < m){
							if(bx == fx && by == fy){
								break;
							}
							
							if(tmpMap[bx][by].equals("#") || tmpMap[bx][by].equals(OT)){
								b = true;
								bx = bx - dx[dir];
								by = by - dy[dir];
							}
							else if(tmpMap[bx][by].equals("O"))
								b = true;
						}
						else
							b = true;
						tmpMap[ax][ay] = TT;
					}
					if(a && b)
						break;
				}
				
				if(ax == fx && ay == fy && bx == fx && by == fy){
					break;
				}
				else if(map[fx][fy].equals("B")){
					break;
				}
				else if(map[fx][fy].equals("R")){
					 min = i;
					 ans = Math.min(min, ans);
					 break;
				}
			}
			return ;
		}

		for(int dir=0; dir<4; dir++){
			seq[cnt] = dir;
			dfs(cnt+1);
			seq[cnt] = 0;
		}
	}


	private static void check(int dir) {



	}
	private static void viewMap() {
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}




