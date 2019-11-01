package D2;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_1984_중간평균값구하기 {
	public static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1984.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			list = new ArrayList<>();
			for(int i=0; i<10; i++){
				list.add(sc.nextInt());
			}
			Collections.sort(list);
			
			double sum = 0;
			for(int i=1; i<9; i++){
				sum += list.get(i);
			}
			System.out.println("#" + tc + " " + Math.round(sum/8));
		}
		
		
		
	}
}
