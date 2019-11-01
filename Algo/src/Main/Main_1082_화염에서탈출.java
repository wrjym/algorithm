package Main;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main_1082_화염에서탈출 {
	public static String [][]map;
	public static int [][]mapFire;
	public static int [][]mapMan;
	public static Queue<xy> qFire;
	public static Queue<xy> qMan;
	public static int R,C;
	public static int [] dx = {0,-1,0,1};
	public static int [] dy = {-1,0,1,0};
	static class xy{
		public int x;
		public int y;
		public int cnt;
		public xy(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "xy [x=" + x + ", y=" + y + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1082.txt"));
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		mapFire = new int[R][C];
		mapMan = new int[R][C];
		map = new String[R][C];
		qFire = new LinkedList<>();
		qMan = new LinkedList<>();
		int fx=0,fy=0;
		for(int i=0; i<R; i++){
			String a = sc.nextLine();
			for(int j=0; j<C; j++){
				map[i][j] = a.charAt(j)+"";
				if(map[i][j].equals("*")){
					qFire.offer(new xy(i,j,1));
					mapFire[i][j] = 1;
				}
				if(map[i][j].equals("S")){
					qMan.offer(new xy(i,j,1));
					mapMan[i][j] = 1;
				}
				if(map[i][j].equals("D")){
					fx = i;
					fy = j;
				}
			}
		}
		bfsFire();
		bfsMan();

		if(mapMan[fx][fy] == 0){
			System.out.println("impossible");
		}
		else{
			System.out.println(mapMan[fx][fy]);
		}
		
	}
	private static void bfsMan() {
		while(!qMan.isEmpty()){
			xy a = qMan.poll();
			int x = a.x;
			int y = a.y;
			int cnt = a.cnt;
			for(int i=0; i<4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < R && 0 <= ny && ny < C){
					if(mapMan[nx][ny]==0 && map[nx][ny].equals(".") && (mapFire[nx][ny]==0 || mapFire[nx][ny] > cnt )){
						mapMan[nx][ny] = cnt;
						qMan.offer(new xy(nx,ny,cnt+1));
					}
					else if(mapMan[nx][ny] == 0 && map[nx][ny].equals("D")){
						mapMan[nx][ny] = cnt;
						return ;
					}
				}
			}
		}
	}
	private static void bfsFire() {
		while(!qFire.isEmpty()){
			xy a = qFire.poll();
			int x = a.x;
			int y = a.y;
			int cnt = a.cnt;
			
			for(int i=0; i<4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < R && 0 <= ny && ny < C){
					if(mapFire[nx][ny] == 0 && !map[nx][ny].equals("X") && !map[nx][ny].equals("S") && !map[nx][ny].equals("D")){
						mapFire[nx][ny] = cnt;
						qFire.offer(new xy(nx,ny,cnt+1));
					}
				}
			}
			
		}
	}




}

























