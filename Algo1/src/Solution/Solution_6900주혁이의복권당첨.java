package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_6900주혁이의복권당첨 {

	public static String[][] lotto;
	public static String[] val;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/input_6900.txt"));

		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());

		int sum=0;
		for(int tc=1; tc<=T; tc++){

			int N = Integer.parseInt(sc.next());
			int M = Integer.parseInt(sc.next());

			lotto = new String[N][2];
			val = new String[M];
			sum = 0;
			for(int i=0; i<N; i++){
				lotto[i][0] = sc.next();
				lotto[i][1] = sc.nextLine();
			}
			for(int i=0; i<M; i++){
				val[i] = sc.nextLine();
			}
			for(int i=0; i<N; i++){
				int count=0;
				int count1=0;
				
				for(int k=0; k<lotto[i][0].length(); k++){
					if(lotto[i][0].charAt(k) != '*'){
						count++;
					}
				}
				for(int j=0; j<M; j++){
					
					for(int z=0; z<val[j].length(); z++){
						if(val[j].charAt(z) == lotto[i][0].charAt(z)){
							count1++;
						}
					}
					
					if(count==count1){
						sum += Integer.parseInt(lotto[i][1].trim());
					}
					count1=0;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}

}
