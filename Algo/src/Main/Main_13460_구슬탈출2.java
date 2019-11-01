package Main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;
public class Main_13460_구슬탈출2 {
	static class 구슬{
		int x,y;
		String color;
		public 구슬(int x,int y, String color){
			this.x = x;
			this.y = y;
			this.color = color;
		}
		@Override
		public String toString(){
			return "[" + x + " " + y + " color : " + color + "]";
		}
	}
	static int n,m, k, fx, fy, ans;
	static String[][] map,tmpMap;
	static int []seq;
	static int count;
	static Queue<구슬> q;
	static boolean flag;
	static ArrayList<구슬> li,tmpli;
	static int []dx = {0,-1,0,1};
	static int []dy = {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/13460.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		String []tmps = tmp.split(" ");
		n = Integer.parseInt(tmps[0]);
		m = Integer.parseInt(tmps[1]);
		q = new LinkedList<>();
		map = new String[n][m];
		tmpMap = new String[n][m];
		li = new ArrayList<>();
		for(int i=0; i<n; i++){
			tmp = br.readLine();
			for(int j=0; j<m; j++){
				map[i][j] = tmp.charAt(j) + "";
				if(map[i][j].equals("R") || map[i][j].equals("B"))
					li.add(new 구슬(i,j,map[i][j]));
				else if(map[i][j].equals("O")){
					fx = i;
					fy = j;
				}

			}
		}
		//		ans = Integer.MAX_VALUE;
		//		count = 0;
		//		k = 10;
		//		seq = new int[k];
		//		dfs(0);
		for(k = 0; k <= 10; k++){
			seq = new int[k];
			dfs(0);
			if(flag)
				break;
		}

		//		if(ans == Integer.MAX_VALUE)
		//			ans = -1;
		//		System.out.println(ans);
		if(k == 11)
			k = -1;
		System.out.println(k);

	}

	private static void dfs(int cnt) {
		if(k == cnt){
			tmpli = new ArrayList<>();
			for(int i=0; i<2; i++)
				tmpli.add(li.get(i));
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					tmpMap[i][j] = map[i][j];
				}
			}

			for(int dir=0; dir<k; dir++){
				int dirs = seq[dir];
				switch(dirs){
				case 0:	//좌.
					left(dirs);
					break;
				case 1:	//상.
					up(dirs);
					break;
				case 2:	//우.
					right(dirs);
					break;
				case 3:	//하.
					down(dirs);
					break;
				}

				int sum = 0;
				int color = 0;
				if(tmpli.get(0).x == fx && tmpli.get(1).x == fx && tmpli.get(0).y == fy && tmpli.get(1).y == fy)
					return ;
				for(int i=0; i<2; i++){
					구슬 gu = tmpli.get(i);
					if(gu.x == fx && gu.y == fy){
						sum++;
						color = i;
					}
				}
				if(sum == 1){
					if(tmpli.get(color).color.equals("R")){
						flag = true;
						//						System.out.println(dir);
						ans = Math.min(dir+1, ans);
					}
					else
						return ;
				}
			}
			count++;
			return;
		}

		for(int i=0; i<4; i++){
			seq[cnt] = i;
			dfs(cnt+1);
		}
	}
	private static void down(int dir) {
		Collections.sort(tmpli, new Comparator<구슬>(){
			@Override
			public int compare(구슬 o1, 구슬 o2){
				if(o1.x < o2.x)
					return 1;
				else if(o1.x > o2.x)
					return -1;
				return 0;
			}
		});
		for(int i=0; i<2; i++){
			구슬 gu = tmpli.get(i);
			int nx = gu.x, ny = gu.y;
			while(true){
				tmpMap[nx][ny] = ".";
				nx += dx[dir];
				ny += dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(tmpMap[nx][ny].equals("."))
						tmpMap[nx][ny] = gu.color;
					else if(tmpMap[nx][ny].equals("#") || tmpMap[nx][ny].equals("R") || tmpMap[nx][ny].equals("B")){
						tmpMap[nx - dx[dir]][ny - dy[dir]] = gu.color;
						tmpli.set(i, new 구슬(nx - dx[dir],ny - dy[dir],gu.color));
						break;
					}
					else if(tmpMap[nx][ny].equals("O")){
						tmpli.set(i, new 구슬(nx,ny, gu.color));
						break;
					}
				}
				else
					break;
			}
		}
	}

	private static void right(int dir){
		Collections.sort(tmpli, new Comparator<구슬>(){
			@Override
			public int compare(구슬 o1, 구슬 o2){
				if(o1.y < o2.y)
					return 1;
				else if(o1.y > o2.y)
					return -1;
				return 0;
			}
		});
		for(int i=0; i<2; i++){
			구슬 gu = tmpli.get(i);
			int nx = gu.x, ny = gu.y;
			while(true){
				tmpMap[nx][ny] = ".";
				nx += dx[dir];
				ny += dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(tmpMap[nx][ny].equals("."))
						tmpMap[nx][ny] = gu.color;
					else if(tmpMap[nx][ny].equals("#") || tmpMap[nx][ny].equals("R") || tmpMap[nx][ny].equals("B")){
						tmpMap[nx - dx[dir]][ny - dy[dir]] = gu.color;
						tmpli.set(i, new 구슬(nx - dx[dir],ny - dy[dir],gu.color));
						break;
					}
					else if(tmpMap[nx][ny].equals("O")){
						tmpli.set(i, new 구슬(nx,ny, gu.color));
						break;
					}
				}
				else
					break;
			}
		}
	}
	private static void up(int dir){
		Collections.sort(tmpli, new Comparator<구슬>(){
			@Override
			public int compare(구슬 o1, 구슬 o2){
				if(o1.x < o2.x)
					return -1;
				else if(o1.x > o2.x)
					return 1;
				return 0;
			}
		});
		for(int i=0; i<2; i++){
			구슬 gu = tmpli.get(i);
			int nx = gu.x, ny = gu.y;
			while(true){
				tmpMap[nx][ny] = ".";
				nx += dx[dir];
				ny += dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(tmpMap[nx][ny].equals("."))
						tmpMap[nx][ny] = gu.color;
					else if(tmpMap[nx][ny].equals("#") || tmpMap[nx][ny].equals("R") || tmpMap[nx][ny].equals("B")){
						tmpMap[nx - dx[dir]][ny - dy[dir]] = gu.color;
						tmpli.set(i, new 구슬(nx - dx[dir],ny - dy[dir],gu.color));
						break;
					}
					else if(tmpMap[nx][ny].equals("O")){
						tmpli.set(i, new 구슬(nx,ny, gu.color));
						break;
					}
				}
				else
					break;
			}
		}
	}
	private static void left(int dir){
		Collections.sort(tmpli, new Comparator<구슬>(){
			@Override
			public int compare(구슬 o1, 구슬 o2){
				if(o1.y < o2.y)
					return -1;
				else if(o1.y > o2.y)
					return 1;
				return 0;
			}
		});
		for(int i=0; i<2; i++){
			구슬 gu = tmpli.get(i);
			int nx = gu.x, ny = gu.y;
			while(true){
				tmpMap[nx][ny] = ".";
				nx += dx[dir];
				ny += dy[dir];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(tmpMap[nx][ny].equals("."))
						tmpMap[nx][ny] = gu.color;
					else if(tmpMap[nx][ny].equals("#") || tmpMap[nx][ny].equals("R") || tmpMap[nx][ny].equals("B")){
						tmpMap[nx - dx[dir]][ny - dy[dir]] = gu.color;
						tmpli.set(i, new 구슬(nx - dx[dir],ny - dy[dir],gu.color));
						break;
					}
					else if(tmpMap[nx][ny].equals("O")){
						tmpli.set(i, new 구슬(nx,ny, gu.color));
						break;
					}
				}
				else
					break;
			}
		}
	}
	private static void vm(String [][]ms){
		System.out.println("================================");
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++)
				System.out.print(ms[i][j] + " ");
			System.out.println();
		}
	}

}
