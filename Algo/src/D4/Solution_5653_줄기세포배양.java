package D4;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_5653_줄기세포배양 {
	static class Cell{
		public int x;
		public int y;
		public int lifetime;
		public Cell(int x, int y, int lifetime) {
			super();
			this.x = x;
			this.y = y;
			this.lifetime = lifetime;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + lifetime;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (lifetime != other.lifetime)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "Cell [x=" + x + ", y=" + y + ", lifetime=" + lifetime + "]";
		}
	}

	static class State{
		public int x;
		public int sx;
		public int ex;
		public int state;
		public State(int x, int sx, int ex, int state) {
			super();
			this.x = x;
			this.sx = sx;
			this.ex = ex;
			this.state = state;
		}
		@Override
		public String toString() {
			return "State [x=" + x + ", sx=" + sx + ", ex=" + ex + ", state=" + state + "]";
		}
	}
	static State[][] map;
	static int [][]v;
	static int s;
	static int ans;
	static int n,m,k;
	static ArrayList<Cell> cell;
	static Queue<Cell> q;
	static int []dx = {0,-1,0,1};
	static int []dy = {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/5653.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++){
			String text = br.readLine();
			String []num = text.split(" ");
			n = Integer.parseInt(num[0]);
			m = Integer.parseInt(num[1]);
			k = Integer.parseInt(num[2]);
			map = new State[n+300][m+300];
			for(State []a : map) Arrays.fill(a, new State(0, 0, 0, -1));
			ans = 0;
			cell = new ArrayList<>();
			q = new LinkedList<>();
			for(int i=0; i<n; i++){
				text = br.readLine();
				num = text.split(" ");
				for(int j=0; j<m; j++){
					int a = Integer.parseInt(num[j]);
					if(a != 0){
						map[i+150][j+150] = new State(a, a, 2*a , 0);
					}
				}
			}
			n = n+300;
			m = m+300;
			for(int time=1; time<=k; time++){
				ans = 0;
				for(int i=0; i<n; i++){
					for(int j=0; j<m;j++){
						if(map[i][j].x != 0){
							State s = map[i][j];
							if(s.sx <= time && time < s.ex){
								map[i][j] = new State(s.x, s.sx, s.ex, 2);
								q.offer(new Cell(i, j, s.x));
								ans++;
							}
							else if(s.sx > time){
								map[i][j] = new State(s.x, s.sx, s.ex, 1);
								ans++;
							}
							else if(s.ex <= time){
								map[i][j] = new State(s.x, s.sx, s.ex, 3);
							}
						}
					}
				}
				while(!q.isEmpty()){
					Cell c = q.poll();
					for(int dir=0; dir<4; dir++){
						int nx = c.x + dx[dir];
						int ny = c.y + dy[dir];
						if(map[nx][ny].x == 0){
							map[nx][ny] = new State(c.lifetime, time+1+c.lifetime, time+1+(c.lifetime*2), 0);
						}
						else if(map[nx][ny].x < c.lifetime && map[nx][ny].state == 0){
							map[nx][ny] = new State(c.lifetime, time+1+c.lifetime, time+1+(c.lifetime*2), 0);
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}

	}



}
