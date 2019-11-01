package D2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1976_시각덧셈 {
	public static String []timeA = new String[4];
	public static int []time = new int[4];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1976.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int tc=1; tc<=T; tc++){
			String a = sc.nextLine();
			timeA = a.split(" ");
			for(int i=0; i<4; i++){
				time[i] = Integer.parseInt(timeA[i]);
			}
			
			int hour = time[0] + time[2];
			int min = time[1] + time[3];
			
			if(min > 60){
				hour++;
				min-=60;
			}
			if(hour > 12){
				hour -= 12;
			}
			
			System.out.println("#" + tc + " " + hour + " " + min);
			
			timeA = new String[4];
		}
	}

}
