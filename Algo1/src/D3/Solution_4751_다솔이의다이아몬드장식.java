package D3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_4751_다솔이의다이아몬드장식 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/4751.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for(int tc=1; tc<=T; tc++){
			String a = sc.nextLine();
			String []word = new String[a.length()];
			int col = a.length()*4+1;
			String [][]map = new String[5][col];
			for(int i=0; i<5; i++) Arrays.fill(map[i], ".");
			for(int i=0; i<word.length; i++){
				word[i] = a.charAt(i)+"";
			}

			for(int j=1; j<col; j=j+4){
				map[0][j] = map[4][j] = ".";
				map[0][j+1] = map[4][j+1] = "#";
				map[0][j+2] = map[4][j+2] =".";
				map[0][j+3] = map[4][j+3] = ".";
				
			}
			for(int j=1; j<col-1; j=j+2){
				map[1][j] = map[3][j] = "#";
			}
			for(int j=0; j<col; j=j+4){
				map[2][j] = "#";
			}
			int cnt=0;
			for(int j=2; j<col; j=j+4){
				map[2][j] = word[cnt++];
			}
			for(int i=0; i<5; i++){
				for(int j=0; j<col; j++){
					System.out.print(map[i][j]);
				}
				System.out.println();
			}


		}
	}

}
