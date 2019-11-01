package 못푼문제;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_7830_마름모  {
	static class rc_7830{
		public int x;
		public int y;
		public rc_7830(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "rc_7830 [x=" + x + ", y=" + y + "]";
		}

	}
	public static int [][]map;
	public static int r,c;
	public static int []dx = {1,1,-1,-1};
	public static int []dy = {1,-1,-1,1};
	public static int max;
	public static rc_7830 rc;
	public static boolean check;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/7830.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			max = 0;
			check = true;
			r = sc.nextInt();
			c = sc.nextInt();
			sc.nextLine();
			map = new int[r][c];
			for(int i=0; i<r; i++){
				String a = sc.nextLine();
				for(int j=0; j<c; j++){
					map[i][j] = Integer.parseInt(a.charAt(j)+"");
				}
			}

			//			for(int []a: map)System.out.println(Arrays.toString(a));
			for(int i=0; i< r - max ; i++){	
				for(int j=0; j< c-max; j++){
					if(map[i][j] == 1){
						int maxsize = 0;
						if(i < j){
							maxsize = (c - j)/2 + 1;
							findMaxMa(i,j,maxsize);
						}
						else{
							maxsize = (r - i)/2 + 1;
							findMaxMa(i,j,maxsize);
						}
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}


	private static void findMaxMa(int x, int y, int maxsize) {
		int size = max + 1;

		for(int i=size; i<=maxsize; i++){
			int nx = x + (dx[0]*size);
			int ny = y + (dy[0]*size);
			if(0 <= nx && nx < r && 0 <= ny && ny < c && map[nx][ny] == 1){
				rc = new rc_7830(x, y);
				check = checkFun(x, y, i);
//				System.out.println(check + " " + x + " " + y + " " + i);
				if(!check)
					return;
			}
			else{
				return ;
			}
//			rc = new rc_7830(nx, ny);
//			System.out.println("--------------");
//			System.out.println(rc);
			for(int dir=1; dir<4; dir++){
				check = checkFun(rc.x, rc.y, i, dir);
				if(!check)
					break;
			}
			if(check){
				max = Math.max(max, i+1);
			}
		}

	}


	private static boolean checkFun(int x, int y ,int size) {
		int nx = x;
		int ny = y;
		for(int i=1; i<=size; i++){
			nx = nx + dx[0];
			ny = ny + dy[0];
			if(0 <= nx && nx < r && 0 <= ny && ny < c){
				if(map[nx][ny] == 0)
					return false;
			}
			else{

				return false;
			}
		}
		rc.x = nx;
		rc.y = ny;
		return true;
	}

	private static boolean checkFun(int x, int y ,int size, int dir) {
		int nx = x;
		int ny = y;
		for(int i=0; i<size; i++){
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			if(0 <= nx && nx < r && 0 <= ny && ny < c){
				if(map[nx][ny] == 0){
					return false;
				}
			}
			else{
				return false;
			}
		}
		rc.x = nx;
		rc.y = ny;
		return true;
	}


}
