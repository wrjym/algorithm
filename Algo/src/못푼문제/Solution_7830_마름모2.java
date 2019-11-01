package 못푼문제;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_7830_마름모2 {
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

			for(int i=0; i<c; i++){
				for(int j=0; j<r; j++){
					System.out.print(map[j][i] + " ");
				}
				System.out.println();
			}
			

			System.out.println("#" + tc + " " + max);


		}
	}
	private static boolean checkFun(int x, int y ,int size, int dir) {
		int nx = x;
		int ny = y;
		for(int i=0; i<size-1; i++){
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
