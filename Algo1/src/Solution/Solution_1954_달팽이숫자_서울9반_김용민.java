package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1954_달팽이숫자_서울9반_김용민 {
	public static int [][]arr;
	public static int []dx = {0,1,0,-1};
	public static int []dy = {1,0,-1,0};
	public static int count = 1;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("rs/input_1954.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cx = 0 , cy = 0;

		
		for(int tc = 0; tc < T; tc++){
			int N = sc.nextInt();

			arr = new int[N][N];
			int dir = 0;
			arr[0][0] = 1;
			count = 2;
			while(count<(N*N+1)){
				int nx = cx+dx[dir];
				int ny = cy+dy[dir];
				if(nx<N && ny<N && nx>=0 && ny>=0 && arr[nx][ny] == 0){
					arr[nx][ny] = count++;
					cx = nx;
					cy = ny;
				}
				else {
					dir++;
				}

				if(dir==4){
					dir = 0;
				}
				
			}

			cx = 0;
			cy = 0;
			System.out.println("#"+ (tc+1));
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}


		}
	}
}
