package Solution;

import java.io.FileInputStream;
import java.sql.Time;
import java.util.Scanner;

public class Solution_1219_길찾기_서울9반_김용민 {
	public static int [][]map;
	public static int []search = new int[100];
	public static boolean bol = false;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/input_1219.txt"));
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			map = new int[100][100];
			for(int i=0; i<end; i++){
				int x=sc.nextInt();
				int y=sc.nextInt();
				map[x][y] = 1;
			}
			
			double a = System.nanoTime();
			dfs(0);
			double b = System.nanoTime();
//			System.out.println("dfs : " + (b-a));
			
			System.out.print("#" + start + " ");
			if(bol == true){
				System.out.println("1");
			}else
				System.out.println("0");
			bol = false;
			search = new int[100];
		}

	}
	public static void ddfs(int v) {
		if(bol == true){
			return ;
		}
		int n = map.length - 1;
		
		if(v == 99){
			bol = true;
			return ;
		}
		
		search[v] = 1;
		for (int i = 1; i <= n; i++) {
			if (map[v][i] == 1 && search[i] != 1) {
				dfs(i);
			}
		}
	}
	
	
	public static void dfs(int v) {
		if(bol == true){
			return ;
		}
		int n = map.length - 1;
		
		if(v == 99){
			bol = true;
			return ;
		}
		search[v] = 1;
		for (int i = 1; i <= n; i++) {
			if (map[v][i] == 1 && search[i] != 1) {
				dfs(i);
			}
		}
		
		
	}
}
