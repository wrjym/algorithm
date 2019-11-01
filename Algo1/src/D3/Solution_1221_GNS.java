package D3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1221_GNS {
	public static String []f = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	public static ArrayList<String> list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1221.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int tc=1; tc<=T; tc++){
			String a = sc.nextLine();
			list = new ArrayList();
			String []testCase = a.split(" ");
			String b = sc.nextLine();
			String []data = b.split(" ");
			for(int k=0; k<f.length; k++){
				for(int i=0; i<data.length; i++){
					if(data[i].equals(f[k])){
						list.add(data[i]);
					}
				}
			}
			System.out.print(testCase[0] + " ");
			for(int i=0; i<list.size(); i++){
				System.out.print(list.get(i) +" ");
			}
			System.out.println();
		}
	}

}
