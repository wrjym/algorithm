package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_2005_파스칼의삼각형_서울9반_김용민 {
	public static int [][]pas;
	public static void main(String[] args) throws Exception {
		//		System.setIn(new FileInputStream("rs/txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int a = sc.nextInt();
			int start, end;
			start = 0;
			end = 1;
			pas = new int[a][a];
			for(int i=0; i<a; i++){
				for(int j=start; j<end; j++){
					if(start == j || (end-1) == j){
						pas[i][j] = 1;
						//						System.out.print("1" + " ");
					}
					else{
						pas[i][j] = 0;
						//						System.out.print("0" + " ");
					}					
				}
				end++;
			}
			
			start =0;
			end =1;
			for(int i=1; i<a; i++){
				for(int j=start; j<end; j++){
					if(start < j && (end) > j){
						pas[i][j] = pas[i-1][j-1] + pas[i-1][j];
					}
				}
				end++;
			}
			start =0;
			end =1;
			System.out.println("#" + tc);
			for(int i=0; i<a; i++){
				for(int j=start; j<end; j++){
					System.out.print(pas[i][j] + " ");
				}
				System.out.println();
				end++;
			}
		}
	}

}
