package D4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1227_미로2 {
	public static String [][]map;
	public static boolean[][] v;
	public static int[]dx = {0,-1,0,1};
	public static int[]dy = {-1,0,1,0};
	public static int fx, fy;
	public static boolean flag;
	public static int n;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1227.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=1; tc++){
			int T = Integer.parseInt(sc.nextLine());
			n = 16;
			map = new String[n][n];
			v = new boolean[n][n];
			for(int i=0; i<n; i++){
				String a = sc.nextLine();
				map[i] = a.split("");
			}
			int x = 0,y = 0;
			flag = false;
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(map[i][j].equals("2")){
						v[i][j] = true;
						x=i;	y=j;
					}
					if(map[i][j].equals("3")){
						fx=i;	fy=j;
					}
				}
			}
			dfs(x,y);
			if(flag) System.out.println("#" + T + " " + 1);
			else	System.out.println("#" + T + " " + 0);
		}
	}
	private static void dfs(int x, int y) {
		if(x== fx && y == fy){
			flag = true;
			return ;
		}
		int nx=0, ny=0;
		for(int i=0; i<4; i++){
			nx = x + dx[i];
			ny = y + dy[i];
			if(0 <= nx && nx < n && 0 <= ny && ny < n){
				if(!map[nx][ny].equals("1") 
						&& v[nx][ny] == false){
					v[nx][ny] = true;
					dfs(nx,ny);
					v[nx][ny] = false;
				}
			}
			
		}
	}

}
