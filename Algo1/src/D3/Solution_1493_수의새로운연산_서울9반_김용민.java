package D3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1493_수의새로운연산_서울9반_김용민 {
	public static int [][]map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1493.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		map = new int[600][600];
		int cnt=1;
		for(int i=1; i<600; i++){
			for(int j=i; j>=1; j--){
				map[i-j+1][j] = cnt++;
			}
		}
		for(int tc=1; tc<=T; tc++){
			int p = sc.nextInt();
			int q = sc.nextInt();
			int px=0, py=0;
			int qx=0, qy=0;
			int count=0;
			loop : for(int i=1; i<1000; i++){
				for(int j=i; j>=1; j--){
					if(map[i-j+1][j] == p){
						px = i-j+1;
						py = j;
						count++;
					}
					if(map[i-j+1][j] == q){
						qx = i-j+1;
						qy = j;
						count++;
					}
					if(count==2){
						break loop;
					}
				}
			
			}
			System.out.println("#" + tc + " " + (map[px+qx][py+qy]));
		}
	}

}
