package D2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1974_스도쿠검증 {
	public static int[][] map = new int[9][9];
	public static boolean[] check = new boolean[10];
	public static int[] dx = {0, 3, 6};
	public static int[] dy = {0, 3, 6};
	public static int ans = 0;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1974.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int a= sc.nextInt();
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					map[i][j] = sc.nextInt();
				}
			}
			//			System.out.println(Arrays.toString(check));
			boolean flag = row();
			if(flag == true){
				outline:
				for(int i=0; i<3; i++){
					for(int j=0; j<3; j++){
						flag = box(dx[i],dy[j]);
						if(flag == false){
							flag = false;
							break outline;
						}
					}
				}
			}
			System.out.print("#" + tc + " ");
			if(flag == true){
				System.out.println("1");
			}
			else{
				System.out.println("0");
			}
			flag = true;
		}
	}
	private static boolean box(int x, int y) {
		for(int i=x; i<x+3; i++){
			for(int j=y; j<y+3; j++){
				if(check[map[i][j]]==true){
					check = new boolean[10];
					return false;
				}
				check[map[i][j]]=true;
			}
		}
		check = new boolean[10];
		return true;
	}
	private static boolean row() {
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(check[map[i][j]] == true){
					check = new boolean[10];
					return false;
				}
				check[map[i][j]] = true;
			}
			check = new boolean[10];
		}

		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(check[map[j][i]]== true){
					check = new boolean[10];
					return false;
				}
				check[map[j][i]] = true;
			}
			check = new boolean[10];
		}
		return true;
	}
}
