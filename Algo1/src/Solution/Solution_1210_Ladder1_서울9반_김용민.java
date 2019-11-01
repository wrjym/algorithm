package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1210_Ladder1_서울9반_김용민 {
	public static int [][]map = new int[100][100];
	public static int startx, starty;
	public static int []dx = { 0, 0};
	public static int []dy = {-1,1};
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("rs/input_1210.txt"));
		Scanner sc = new Scanner(System.in);
		
		int i,j;
		for(int tc = 0; tc < 10; tc++){
			int dir = 0;
			sc.nextInt();
			for(int x=0;x<map.length;x++){
				for(int y=0;y<map[x].length;y++){
					map[x][y] = sc.nextInt();
					if(map[x][y] == 2){ startx = x; starty = y; }
				}
			} i = startx; j = starty;

			while (startx >= 1){
//				System.out.println("starty : " + starty);

				if(starty == 0){
					dir = 1;
				}
				dir = direation(dir);
				if(dir == 2){
					map[startx][starty] = 3;
					startx -= 1;
					dir = 0;
				}

			}
//			for(int x=0;x<100;x++){
//				for(int y=0;y<100;y++){
//					System.out.print(map[x][y] + " ");
//				}
//				System.out.println();
//			}

			System.out.println("#"+ (tc+1) + " " + starty);
		}
	}

	private static int direation(int dir) {
		int nx = startx + dx[dir];
		int ny = starty + dy[dir];
		if(nx == 0)
			return 2;


		if(ny >= 0 && ny < 100){
			
			if(map[nx][ny] == 1){
				map[nx][ny] = 3;
				startx = nx;
				starty = ny;
				return dir;
			}
			else{
				return ++dir;
			}
			

		}
		return 2;

		//		return 2;
	}

}

