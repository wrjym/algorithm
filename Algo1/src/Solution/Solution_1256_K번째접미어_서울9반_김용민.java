package Solution;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution_1256_K번째접미어_서울9반_김용민 {
	public static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/input_1256.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		int T = Integer.parseInt(sc.nextLine());	
		for(int tc=1; tc<=T; tc++){
			int c = Integer.parseInt(sc.nextLine());
			String a = sc.nextLine();
			for(int i=0; i<a.length(); i++){
				String b = a.substring(i);
				list.add(b);
			}
			
			Collections.sort(list);
			System.out.println("#" + tc + " " + list.get(c-1));
			list = new ArrayList<>();
		}
	}
}
