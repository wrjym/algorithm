package Main;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_단지번호붙이기_DFS {
	public static int[] ans = new int[10];
	public static int[][] map;
	public static int cnt=2;
	public static int a;
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/main.txt"));
		Scanner sc = new Scanner(System.in);


		for(int tc=1; tc<=1; tc++){
			a = Integer.parseInt(sc.nextLine());

			map = new int[a][a];
			for(int i=0; i<a; i++){
				String b = sc.nextLine();
				for(int j=0; j<a; j++){
					map[i][j] = Integer.parseInt(b.substring(j,j+1));
				}
			}


			for(int i=0; i<a; i++){
				for(int j=0; j<a; j++){
					if(map[i][j] == 1){
						map[i][j] = cnt;
						ans[cnt]++;
						check(i,j);
						cnt++;
						for(int[]c : map) System.out.println(Arrays.toString(c));
						System.out.println();
					}

				}
			}
			System.out.println(cnt-2);
			for(int i=0; i<10; i++){
				if(ans[i]!=0){
					System.out.println(ans[i]);
				}
			}

		}
	}
	private static void check(int x, int y) {
		int count=0;
		int xx = 0, yy = 0;
		for(int i=0; i<4; i++){
			xx = x + dx[i];
			yy = y + dy[i];
			if(0 <= xx && xx < a && 0 <= yy && yy < a){

				if(map[xx][yy] == 1){
					map[xx][yy] = cnt;
					ans[cnt]++;
					check(xx,yy);
					count++;
//										for(int[]c : map) System.out.println(Arrays.toString(c));
//										System.out.println();
				}
			}
		}

	}

}
