package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution5356_의석이의세로로말해요_서울9반_김용민 {
	public static String []arr = new String[5];

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("rs/input_5356.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt((sc.nextLine()));

		for(int tc = 0; tc < T; tc++){
			
			for(int i=0;i<5;i++){
				arr[i] = sc.nextLine();
			}
			System.out.print("#" + (tc+1) + " ");
			
			for(int i=0;i<15;i++){
				for(int j=0;j<5;j++){
					if(arr[j].length()>i)
						System.out.print(arr[j].charAt(i));
				}
			}
			System.out.println();

		}
	}
}
