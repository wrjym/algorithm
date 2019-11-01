package Solution;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution_1257_K번째문자열_서울9반_김용민 {
	public static HashSet<String> set = new HashSet<>();
	public static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/input_1257.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for(int tc=1; tc<=T; tc++){
			int num = Integer.parseInt(sc.nextLine());

			String a = sc.nextLine();
			int j=1;
			set.add(a);
			while(j != a.length()){
				for(int i=0; i<a.length()+1-j; i++){
					set.add(a.substring(i, i+j));
				}
				j++;
			}
			list = new ArrayList(set);
			set = new HashSet<>();
			Collections.sort(list);			
			System.out.println("#" + tc + " " + list.get(num-1));

		}

		System.out.println("END POINT");
	}

}
