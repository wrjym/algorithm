package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2805_농작물수확하기_서울9반_김용민 {
	public static int [][]data;
	public static String datastr[];
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("rs/input_2805.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++){
			int N = sc.nextInt();
			data = new int[N][N];

			for(int i=0;i<N;i++){
				String data1 = sc.next();
				for(int j=0;j<N;j++){
					data[i][j] = data1.charAt(j) - '0';
//					System.out.print(data[i][j] + " ");
				}
//				System.out.println();
			}
			
			int count = 1;
			int sum =0;
			int start = N/2;
			for(int i=0; i<N/2; i++)	{
				for(int j=0 ;j<count;j++){
					sum += data[i][j+start];
				}
				count += 2;
				start -= 1;
			}
			
			
			for(int i=(N/2);i<N;i++){
				for(int j=0;j<count;j++){
					sum += data[i][j+start];
				}
				count -= 2;
				start += 1;
			}
			
			System.out.println("#" + (tc+1) +  " " + sum);
			
		}
	}

}
