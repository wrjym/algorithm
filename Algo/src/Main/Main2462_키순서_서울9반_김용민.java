package Main;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main2462_키순서_서울9반_김용민 {
	public static int []v;
	public static int [][]map;
	public static int ans;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2462.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int check = sc.nextInt();

		v = new int[n];
		map = new int[n+1][n+1];
		for(int i=0; i<check; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y]  = 1;
		}


		for(int k=1; k<=n; k++){
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					if(map[i][k] == 1 && map[k][j]==1){
						map[i][j] = 1;
					}
				}
			}
		}
		for(int i=1; i<=n; i++){
			int cnt=0;
			for(int j=1; j<=n; j++){
				
				if(map[i][j]==1 || map[j][i] ==1){
					cnt++;
				}
			}
			if(cnt == n-1){
				ans++;
			}
		}
		
		System.out.println(ans);
		
//		for(int i=1; i<=n; i++){
//			for(int j=1; j<=n; j++){
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		sc.close();
	}

}
