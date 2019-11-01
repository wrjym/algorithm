package D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_6485_삼성시의버스노선 {
	public static int[][] AB;
	public static int[] PP;
	public static int[] check;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/6485.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int N = sc.nextInt();
			AB = new int[N][2];
			check = new int[5001];
			for(int i=0; i<N; i++){
				AB[i][0] = sc.nextInt();	//start
				AB[i][1] = sc.nextInt();	//end
			}
			int P = sc.nextInt();
			PP = new int[P];
			System.out.print("#" + tc + " ");
			for(int i=0; i<P; i++){
				int c = sc.nextInt();
				int cnt=0;
				for(int j=0; j<N; j++){
					if(AB[j][0] <= c && c <= AB[j][1]){
						cnt++;
					}
				}
				System.out.print(cnt + " ");
			}
			System.out.println();
		}
		
	}

}
