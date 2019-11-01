import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_5648_원자소멸시뮬레이션 {
	static class rc_5648{
		int x,y,pow,dir;
		private rc_5648(int x,int y,int dir, int pow){
			this.x = x;
			this.y = y;
			this.pow = pow;
			this.dir = dir;
		}
		@Override
		public String toString(){
			return "["+x+","+y+"] "+ "dir : " + dir+" |";
		}
	}

	static int []dx = {0,0,-1,1};
	static int []dy = {1,-1,0,0};
	static Queue<rc_5648> q,clear;
	static int n,num,ans;
	static int [][]map = new int[4002][4002];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/5648.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
			num = Integer.parseInt(br.readLine());
			n = 4002;
			ans = 0;
			q = new LinkedList<>();
			clear = new LinkedList<>();
			for(int i=0; i<num; i++){
				String tmp = br.readLine();
				String []tmps = tmp.split(" ");
				int x = (Integer.parseInt(tmps[0])*2)+2000;
				int y = (Integer.parseInt(tmps[1])*2)+2000;
				int dir = Integer.parseInt(tmps[2]);
				int pow = Integer.parseInt(tmps[3]);
				q.offer(new rc_5648(x,y,dir,pow));
			}
			for(int i=0; i<n; i++){
				bfs();
				getEnergy();
				if(q.size() <= 1)
					break;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void getEnergy() {
		clear = new LinkedList<>();
		int size = q.size();
		for(int i=0; i<size; i++){
			rc_5648 rc = q.poll();
			if(map[rc.x][rc.y] == 1){
				map[rc.x][rc.y] = 0;
				q.offer(rc);
			}
			else if(map[rc.x][rc.y] > 1){
				clear.offer(rc);
				ans += rc.pow;
			}
		}
		size = clear.size();
		for(int i=0; i<size; i++){
			rc_5648 rc = clear.poll();
			map[rc.x][rc.y] = 0;
		}
	}
	private static void bfs() {
		int size = q.size();
		for(int i=0; i<size; i++){
			rc_5648 rc = q.poll();
			int nx = rc.x + dx[rc.dir];
			int ny = rc.y + dy[rc.dir];
			if(0 <= nx && nx < n && 0 <= ny && ny < n){
				map[nx][ny]++;
				q.offer(new rc_5648(nx, ny, rc.dir, rc.pow));
			}
		}
	}
}
