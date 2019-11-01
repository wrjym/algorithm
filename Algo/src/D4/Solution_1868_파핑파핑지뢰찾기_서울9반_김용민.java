package D4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1868_파핑파핑지뢰찾기_서울9반_김용민 {
	public static int map[][];
	public static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1 };
	public static int dy[] = {-1,-1, 0, 1, 1, 1,0, -1};
	public static int a=0;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1868.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			a = sc.nextInt();
			sc.nextLine();
			int cnt=0;
			map = new int[a][a];
			for(int i=0; i<a; i++){
				String b = sc.nextLine();
				for(int j=0; j<a; j++){
					char c = b.charAt(j);
					if(c == '*'){
						map[i][j] = -1;
					}
				}
			}
			for(int i=0; i<a; i++){
				for(int j=0; j<a; j++){
					if(map[i][j] == -1){
						change(i,j);
					}
				}
			}
			for(int i=0; i<a; i++){
				for(int j=0; j<a; j++){
					if(map[i][j] == 0){
						cnt++;
						map[i][j] = -1;
						change1(i,j);
					}
				}
			}
			
			
			
			for(int i=0; i<a; i++){
				for(int j=0; j<a; j++){
					if(map[i][j] != -1){
						cnt++;
					}
				}
			}
			System.out.println("#" + tc  + " " + cnt);
		

		}
	}
	
	private static void change1(int x, int y) {
		map[x][y] = -1;
		int nx=0,ny=0;
		for(int i=0; i<8; i++){
			nx = x + dx[i];
			ny = y + dy[i];
			if(0 <= nx && nx < a && 0 <= ny && ny < a){
				if(map[nx][ny] == 0){
					change1(nx,ny);
				}
				else{
					map[nx][ny] = -1;
				}
			}
		}		
	}




	private static void change(int x, int y) {
		int nx=0,ny=0;
		for(int i=0; i<8; i++){
			nx = x + dx[i];
			ny = y + dy[i];
			if(0 <= nx && nx < a && 0 <= ny && ny < a){
				if(map[nx][ny] == -1){
					continue;
				}
				else{
					map[nx][ny]++;
				}
			}
		}
	}

}
