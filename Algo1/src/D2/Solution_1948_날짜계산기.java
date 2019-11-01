package D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1948_날짜계산기 {
	public static int[] a = new int[2];
	public static int[] b = new int[2];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1948.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int ans=0;
			for(int i=0; i<2; i++){
				a[i] = sc.nextInt();
			}
			for(int i=0; i<2; i++){
				b[i] = sc.nextInt();
			}

			if(a[0] == b[0]){
				ans = b[1]-a[1]+1;
			}
			else if(a[0] < b[0]){
				int c = b[0];
				while(c!= (a[0])){
					c = c -1;
					switch(c){
					case 1: case 3: case 5: case 7: case 8: case 10: case 12:{
						ans += 31;
						break;
					}
					case 4: case 6: case 9: case 11:{
						ans += 30;
						break;
					}
					case 2:{
						ans += 28;
						break;
					}
					}
				}
				
				if(a[1] < b[1]){
					ans += b[1] - a[1] + 1;
				}
				else if(a[1] > b[1]){
					ans = ans-a[1] + b[1] + 1;
				}
				
			}
			
			
			System.out.println("#" + tc + " " + ans);
			ans = 0;

		}
	}

}
