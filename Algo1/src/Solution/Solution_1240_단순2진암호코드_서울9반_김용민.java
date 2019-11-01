package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_1240_단순2진암호코드_서울9반_김용민 {

	public static String[] map;
	public static String[] pass = {"0001101" , "0011001", "0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("rs/input_1240.txt"));
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		for(int tc=1; tc<=T; tc++){
			int sum=0;

			int N = Integer.parseInt(sc.next());
			int M = Integer.parseInt(sc.nextLine().trim());

			map = new String[N];
			for(int x=0; x<N; x++){
				map[x] = sc.nextLine();
			}

			String []data = new String[8];

			for(int x=0; x<N; x++){
				for(int y=M-1; y>=0; y--){
					//					System.out.print(map[x].charAt(y));
				}
				//				System.out.println();
			}
			int dd=0;
			StringBuilder sb = new StringBuilder();
			for(int x=0; x<N; x++){
				for(int y=M-1; y>=0; y--){
					if(map[x].charAt(y)== '1'){
						for(int i=0; i<7; i++){
							sb.append(map[x].charAt(y--));
						}
						data[dd++] = sb.reverse().toString();
						sb.setLength(0);
						y++;
					}
				}

				if(data[0] != null)
					break;
			}
			int aba[] = new int[8];
			for(int i=0; i<8; i++){
				for(int j=0; j<10; j++){
					if(data[i].equals(pass[j])){
						aba[i] = j;
					}
				}
			}
			sum = (aba[1]+aba[3]+aba[5]+aba[7])*3 + aba[2] + aba[4] + aba[6] + aba[0];
			int sum1=0;
			System.out.print("#" + tc + " " );
			if(sum%10 == 0){
				for(int i=0; i<8; i++){
					sum1 += aba[i];
				}
				System.out.println(sum1);
			}else{
				System.out.println(sum1);
			}
		

		}

	}

}
