package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11559_PuyoPuyo {
	static class rc_11559{
		public int x;
		public int y;
		public rc_11559(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int ans;
	static boolean b = true;
	static String[][] map;
	static int [][] v;
	static int r,c;
	static Queue<rc_11559> q;
	static ArrayList<rc_11559> li;
	static int []dx = {0,-1,0,1};
	static int []dy = {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/11559.txt"));
		Scanner sc = new Scanner(System.in);
		r = 12;
		c = 6;
		ans = 0;
		map = new String[r][c];
		v = new int[r][c];
		for(int i=0; i<r; i++){
			String a = sc.nextLine();
			for(int j=0; j<c; j++){
				map[i][j] = a.charAt(j)+"";
			}
		}
		while(b){
			b = false;
			v = new int[r][c];
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					if(!map[i][j].equals(".") && v[i][j] == 0){
						q = new LinkedList<>();
						li = new ArrayList<>();
						v[i][j] = 1;
						q.offer(new rc_11559(i,j));
						li.add(new rc_11559(i, j));
						bfs(map[i][j]);
						if(4 <= li.size()){
							b = true;
							for(int k=0; k<li.size(); k++){
								map[li.get(k).x][li.get(k).y] = ".";
							}
						}
					}
				}
			}
			if(b){
				ans++;
			}
			settingMap();
		}


		System.out.println(ans);
		sc.close();
	}
	private static void settingMap() {
		for(int j=0; j<c; j++){
			ArrayList<String> str = new ArrayList<>();
			int cnt =0;
			for(int i=r-1; i>=0; i--){
				if(!map[i][j].equals(".")){
					str.add(map[i][j]);
					map[i][j] = ".";
					cnt++;
				}
			}
			for(int i=r-1; i>r-1-str.size(); i--){
				map[i][j] = str.get(str.size()-(cnt--));
			}
			
		}
	}
	private static void bfs(String color) {
		while(!q.isEmpty()){
			rc_11559 rc = q.poll();
			for(int dir=0; dir<4; dir++){
				int nx = rc.x + dx[dir];
				int ny = rc.y + dy[dir];

				if(0 <= nx && nx < r && 0 <= ny && ny < c){
					if(map[nx][ny].equals(color) && v[nx][ny] == 0){
						v[nx][ny] = 1;
						q.offer(new rc_11559(nx, ny));
						li.add(new rc_11559(nx, ny));
					}
				}
			}
		}
	}

}
