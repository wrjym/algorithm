package Main;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_9328_열쇠 {
	static class xy{
		public int x;
		public int y;

		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}



		@Override
		public String toString() {
			return "xy [x=" + x + ", y=" + y + "]";
		}
	}
	public static int [][]v;
	public static int ans;
	public static int h,w;
	public static int []key;
	public static String [][]map;
	public static Queue<xy> q;
	public static int []dx = {-1,1,0,0};
	public static int []dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/9328.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for(int tc=1; tc<=T; tc++){
			h = sc.nextInt();
			w = sc.nextInt();
//			System.out.println((h+2) + " " + (w+2));
			sc.nextLine();
			key = new int[26];
			map = new String[h+2][w+2];
			ans = 0;
			q = new LinkedList<>();
			
			
			for(String []a : map) Arrays.fill(a, ".");
			for(int i=1; i<=h; i++){
				String a = sc.nextLine();
				for(int j=1; j<=a.length(); j++){
					map[i][j] = a.charAt(j-1)+"";
				}
			}

			String text = sc.nextLine();
			if(!text.equals("0")){
				for(int i=0; i<text.length(); i++){
					key[text.charAt(i)-97] = 1;
				}
			}
			v = new int[h+2][w+2];
			v[0][0] = 1;
			q.offer(new xy(0,0));
			bfs();

			System.out.println(ans);
		}
	}
	private static void bfs() {
		while(!q.isEmpty()){
			xy a = q.poll();
			for(int i=0; i<4; i++){
				int nx = a.x + dx[i];
				int ny = a.y + dy[i];
				if(0 <= nx && nx <= h+1 && 0 <= ny && ny <= w+1){
//					System.out.println(nx + " " + ny);
					if(map[nx][ny].equals(".") && v[nx][ny] == 0){
						q.offer(new xy(nx,ny));
						v[nx][ny]=1;
					}
					else if( 65 <= map[nx][ny].charAt(0) && map[nx][ny].charAt(0) <= 90 && v[nx][ny] == 0){	//대문자 처리
						if(key[map[nx][ny].toLowerCase().charAt(0)-97]==1){
							v = new int[h+2][w+2];
							map[nx][ny] = ".";
							v[nx][ny] = 1;
							q = new LinkedList<>();
							q.offer(new xy(nx,ny));
						}
					}
					else if( 97 <= map[nx][ny].charAt(0) && map[nx][ny].charAt(0) <= 122 && v[nx][ny] == 0){
						v = new int[h+2][w+2];
						key[map[nx][ny].charAt(0)-97] = 1;
						map[nx][ny] = ".";
						q = new LinkedList<>();
						q.offer(new xy(nx,ny));
						v[nx][ny] = 1;
						
						
					}
					else if(map[nx][ny].equals("$") && v[nx][ny] == 0){
						map[nx][ny] = ".";
						q.offer(new xy(nx,ny));
						v[nx][ny] = 1;
						ans+=1;
					}
				}
			}
		}
	}
	private static void view() {
		for(int i=0; i<=h+1; i++){
			for(int j=0; j<=w+1; j++){
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}

}