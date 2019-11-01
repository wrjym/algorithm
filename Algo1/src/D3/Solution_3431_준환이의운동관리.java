package D3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_3431_준환이의운동관리 {
	public static int[] lu;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/3431.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			lu = new int[3];
			for(int i=0 ; i<3; i++){
				lu[i] = sc.nextInt();
			}

			System.out.print("#" + tc + " ");
			if(lu[2] > lu[1]){	//큰경우
				System.out.print(-1);
			}
			else if(lu[0] > lu[2]){ //작은 경우
				System.out.print(lu[0] - lu[2]);
			}
			else if(lu[0] <= lu[2] && lu[2] <= lu[1]){
				System.out.print(0);
			}
			System.out.println();
		}
	}

}
