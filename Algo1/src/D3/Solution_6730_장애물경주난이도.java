package D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_6730_장애물경주난이도 {
	public static int d[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/6730.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			d = new int[n];
			for(int i=0; i<n; i++){
				d[i] = sc.nextInt();
			}
			int up=0;
			int down=0;
			for(int i=0; i<n-1; i++){
				int v = d[i] - d[i+1];
				if(v < 0){
					if(up > v){
						up = v;
					}

				}
				else{
					if(down < v){
						down = v;
					}
					
				}
			}
			
			System.out.println("#" + tc +" " + Math.abs(up) + " "+down);
		}
	}

}
