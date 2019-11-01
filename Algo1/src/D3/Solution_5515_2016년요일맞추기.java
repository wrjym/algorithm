package D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_5515_2016년요일맞추기 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int month = sc.nextInt();
			int day = sc.nextInt();

			month = month - 1;
			int tmp = 0;
			for(int i=month; i>=0; i--){
				switch(i){
				case 0 :
					tmp += day;
					break;
				case 1 : case 3: case 5: case 7: case 8: case 10: case 12:
					tmp += 31;
					break;
				case 2 :
					tmp += 29;
					break;
				case 4 : case 6 : case 9 : case 11 :
					tmp += 30;
					break;
				}
			}
			System.out.println("#" + tc + " " + (tmp+3)%7);

		}
	}
}

