package Main;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17143_낚시왕 {

	static class rc_17143{
		public int x;
		public int y;
		public int s;
		public int d;
		public int z;

		public rc_17143() {
			super();
		}
		public rc_17143(int x, int y, int s, int d, int z) {
			super();
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public String toString() {
			return "rc_17143 [x=" + x + ", y=" + y + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
	}


	static int r,c,m;
	static Queue<rc_17143> q;
	static rc_17143 [][]map;
	static rc_17143 rc;
	static int ans;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/17143.txt"));
		Scanner sc = new Scanner(System.in);


		r = sc.nextInt();
		c = sc.nextInt();
		m = sc.nextInt();
		ans = 0;
		q = new LinkedList<>();
		map = new rc_17143[r][c];
		for(int i=0; i<m; i++){
			int Sr = sc.nextInt()-1;
			int Sc = sc.nextInt()-1;
			int Ss = sc.nextInt();
			int Sd = sc.nextInt();
			int Sz = sc.nextInt();
			map[Sr][Sc] = new rc_17143(Sr, Sc, Ss, Sd, Sz);
		}
		for(int z=0; z<c; z++){
			for(int i=0; i<r; i++){
				if(map[i][z] != null){
					ans += map[i][z].z;
					map[i][z] = null;
					break;
				}
			}
			
//			viewMap();
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					if(map[i][j] != null){
						q.offer(map[i][j]);
						map[i][j] = null;
					}
				}
			}
			move();
		}
		System.out.println(ans);
		sc.close();
	}
	private static void viewMap() {
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(map[i][j] != null){
					System.out.print(map[i][j].z + " ");
				}
				else{
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
		System.out.println();		
	}

	private static void move() {
		while(!q.isEmpty()){
			rc = q.poll();

			switch(rc.d){
			case 1:
				checkup(r);
				break;
			case 2:
				checkdown();
				break;
			case 3:
				checkright();
				break;
			case 4:
				checkleft();
				break;
			}
			
			if(map[rc.x][rc.y] != null){
				map[rc.x][rc.y] = map[rc.x][rc.y].z > rc.z ? map[rc.x][rc.y] : rc ;
			}
			else{
				map[rc.x][rc.y] = rc;
			}

		}
	}

	private static void checkright() {
		int cl = c-1;
		int a = cl - rc.y;
		int b = a + cl;
		int val = rc.s % (cl*2);
		int y = 0;

		if(0 < val && val <= a){
			y = rc.y + val;
			rc = new rc_17143(rc.x, y, rc.s, rc.d, rc.z);
		}
		else if(a < val && val <= b) {
			y = ((cl*2) - val - rc.y);
			rc = new rc_17143(rc.x, y, rc.s, 4, rc.z);
		}
		else if(b <= val){
			y = Math.abs(((cl*2) - val - rc.y));
			rc = new rc_17143(rc.x, y, rc.s, rc.d, rc.z);
		}
	}
	private static void checkdown() {
		int cl = r-1;
		int a = cl-rc.x;
		int b = a + cl;
		int val = rc.s% (cl*2);
		int x = 0;
		if(0 < val && val <= a){
			x = rc.x+val;
			rc = new rc_17143(x, rc.y, rc.s, rc.d, rc.z);
		}
		else if(a < val && val <= b) {
			x = ((cl*2) - val - rc.x);
			rc = new rc_17143(x, rc.y, rc.s, 1, rc.z);
		}
		else if(b <= val){
			x = Math.abs(((cl*2) -val - rc.x));
			rc = new rc_17143(x, rc.y, rc.s, rc.d, rc.z);
		}
	}
	private static void checkup(int rowcol) {
		int cl = rowcol-1;
		int a = rc.x;
		int b = a + cl;
		int val = rc.s% (cl*2);
		int x = 0;	
		int dir = rc.d;
		if(0 < val && val <= a){
			x = rc.x - val;
		}
		else if(a < val && val <= b) {
			x = (val - rc.x);
			dir = 2;
		}
		else if(b <= val){
			x = Math.abs(((cl*2) -val + rc.x));
		}
		rc = new rc_17143(x, rc.y, rc.s, dir, rc.z);

	}
	private static void checkleft() {
		int cl = c-1;
		int a = rc.y;
		int b = a + cl;
		int val = rc.s% (cl*2);
		int y = 0;
		if(0 < val && val <= a){
			y = rc.y - val;
			rc = new rc_17143(rc.x, y, rc.s, rc.d, rc.z);
		}
		else if(a < val && val <= b) {
			y = (val - rc.y);
			rc = new rc_17143(rc.x, y, rc.s, 3, rc.z);
		}
		else if(b <= val){
			y = Math.abs(((cl*2) - val + rc.y));
			rc = new rc_17143(rc.x, y, rc.s, rc.d, rc.z);
		}
	}
}












