package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_CCTV {
	static class xy{
		public int x;
		public int y;
		public int start;
		public xy(int x, int y, int start) {
			super();
			this.x = x;
			this.y = y;
			this.start = start;
		}
		@Override
		public String toString() {
			return "xy [x=" + x + ", y=" + y + ", start=" + start + "]";
		}



	}
	public static int min;
	public static int [][]map;
	public static int [][]tmpMap;
	public static int []seq;
	public static int size;
	public static int n,m;
	public static ArrayList<xy>	list;
	public static ArrayList<xy> liFive;
	public static int [][] onex = {{0},{-1},{0},{1}};
	public static int [][] oney = {{-1},{0},{1},{0}};
	public static int [][] twox = {{0,0},{-1,1}};
	public static int [][] twoy = {{-1,1},{0,0}};
	public static int [][] thrx = {{0,-1},{-1,0},{0,1},{1,0}};
	public static int [][] thry = {{-1,0},{0,1},{1,0},{0,-1}};
	public static int [][] foux = {{0,-1,0},{-1,0,1},{0,1,0},{1,0,-1}};
	public static int [][] fouy = {{-1,0,1},{0,1,0},{1,0,-1},{0,-1,0}};
	public static int []dx = {0,-1,0,1};
	public static int []dy = {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1.txt"));
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		size = 0;
		min = Integer.MAX_VALUE;
		list = new ArrayList<>();
		liFive = new ArrayList<>();
		map = new int[n][m];
		tmpMap = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				map[i][j] = sc.nextInt();
				if(0 < map[i][j] && map[i][j] <5){
					size++;
					list.add(new xy(i,j,0));
				}
				else if(map[i][j]==5){
					liFive.add(new xy(i,j,0));
				}
			}
		}
		for(int i=0; i<liFive.size(); i++){
			move5(liFive.get(i).x,liFive.get(i).y);
		}
		//		int sum =0;
		//		for(int i=0; i<n; i++){
		//			for(int j=0; j<m; j++){
		//				if(map[i][j] == 0){
		//					sum++;
		//				}
		//			}
		//		}
		//		min = Math.min(min, sum);
		seq = new int[size];	
		dfs(0);
		System.out.println(min);


	}
	private static void move1(int x, int y,int start) {
		for(int i=0; i<onex[start].length; i++){
			int nx = x;
			int ny = y;
			while(true){
				nx = nx + onex[start][i];
				ny = ny + oney[start][i];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(tmpMap[nx][ny]==6)
						break;
					else{ 
						if(tmpMap[nx][ny] == 0)tmpMap[nx][ny] = 9;
					}
				}
				else break;
			}
			//			for(int []a : tmpMap)	System.out.println(Arrays.toString(a));
			//			System.out.println();
		}
	}
	private static void move2(int x, int y,int start) {
		for(int i=0; i<twox[start].length; i++){
			int nx = x;
			int ny = y;
			while(true){
				nx = nx + twox[start][i];
				ny = ny + twoy[start][i];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(tmpMap[nx][ny]==6)break;
					else if(tmpMap[nx][ny] == 0)tmpMap[nx][ny] = 9;
				}
				else break;
			}
		}
		//		for(int []a : tmpMap)	System.out.println(Arrays.toString(a));
		//		System.out.println();
	}
	private static void move3(int x, int y,int start) {
		for(int i=0; i<thrx[start].length; i++){
			int nx = x;
			int ny = y;
			while(true){
				nx = nx + thrx[start][i];
				ny = ny + thry[start][i];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(tmpMap[nx][ny]==6)
						break;
					else {
						if(tmpMap[nx][ny] == 0)
							tmpMap[nx][ny] = 9;
					}
				}
				else 
					break;
			}
		}
	}
	private static void move4(int x, int y,int start) {
		for(int i=0; i<foux[start].length; i++){
			int nx = x;
			int ny = y;
			while(true){
				nx = nx + foux[start][i];
				ny = ny + fouy[start][i];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(tmpMap[nx][ny]==6)
						break;
					else {
						if(tmpMap[nx][ny] == 0)
							tmpMap[nx][ny] = 1;
					}
				}
				else 
					break;
			}
		}
	}
	private static void move5(int x, int y){
		for(int i=0; i<4; i++){
			int nx = x;
			int ny = y;
			while(true){
				nx = nx + dx[i];
				ny = ny + dy[i];
				if(0 <= nx && nx < n && 0 <= ny && ny < m){
					if(map[nx][ny]==6)
						break;
					else if(map[nx][ny] == 0){
						map[nx][ny] = 9;
					}
				}
				else 
					break;
			}
		}
		//		for(int []a : tmpMap)	System.out.println(Arrays.toString(a));
		//		System.out.println();
	}

	private static void dfs(int cnt) {
		if(cnt==size){
//			System.out.println(Arrays.toString(seq));
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					tmpMap[i][j] = map[i][j];
				}
			}
			for(int i=0; i<seq.length; i++){
				list.set(i, new xy(list.get(i).x,list.get(i).y,seq[i]));
			}

			//맵의 숫자로 switch하고 그 숫자의 시점으로 값변환.
			for(int i=0; i<seq.length; i++){
				int tmpX = list.get(i).x;
				int tmpY = list.get(i).y; 
				int dir = list.get(i).start;
				switch(map[tmpX][tmpY]){
				case 1:
					move1(tmpX,tmpY,dir);
					break;
				case 2:
					move2(tmpX,tmpY,dir%2);
					break;
				case 3:
					move3(tmpX,tmpY,dir);
					break;
				case 4:
					move4(tmpX,tmpY,dir);
					break;
				}
			}

			//			for(int []a : tmpMap)	System.out.println(Arrays.toString(a));
			//			System.out.println();

			int sum =0;
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(tmpMap[i][j] == 0){
						sum++;
					}
				}
			}
			//			System.out.println(sum);
			min = Math.min(min, sum);
			//여기서 데이터 위치들의 좌표에 순서를 붙여준다.
			//일단 1~5까지의 좌표를 불러온다.
			return ;
		}
		for(int i=0; i<4; i++){
			seq[cnt] = i;
			dfs(cnt+1);
			seq[cnt] = 0;
		}
	}

}











