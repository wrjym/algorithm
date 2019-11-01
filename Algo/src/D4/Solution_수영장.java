package D4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_수영장 {
	public static int[] price;
	public static int[] year;
	public static int sum;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1111.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		price = new int[4];
		year = new int[13];
		for(int tc=1; tc<=T; tc++){

			for(int i=0; i<4; i++){
				price[i] = sc.nextInt();
			}

			for(int i=1; i<=12; i++){
				year[i] = sc.nextInt();
				year[i] = Math.min(year[i]*price[0], price[1]);
				year[i] = year[i-1] + year[i];
				if(i > 2){
					year[i] = Math.min(year[i], year[i-3] + price[2]);
				}
			}
			sum = year[12];
			sum = Math.min(sum, price[3]);
			System.out.println(sum);
		}

	}


}
