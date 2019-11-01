package D2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1940_RC카 {
	public static int []a = new int[2];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1940.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int ans = 0;
		sc.nextLine();
		for(int tc=1; tc<=T; tc++){
			int N = Integer.parseInt(sc.nextLine());
			int v = 0;
			for(int i=0; i<N; i++){
				String ab = sc.nextLine();
				String[] cc = ab.split(" ");

				switch(cc[0]){
				case "0":{	//현재 속도 유지
					ans += v;
					break;			
				}
				case "1":{	///가속

					v = v + Integer.parseInt(cc[1]);
					ans += v;
					break;
				}
				case "2":{	//감속
					if(v < Integer.parseInt(cc[1])){
						v = 0;
					}
					else{
						v = v - Integer.parseInt(cc[1]);
					}
					ans += v;
					break;
				}
				}
			}
			System.out.println("#" + tc + " " + ans);
			ans = 0;
		}
		System.out.println("END POINT");
	}

}
