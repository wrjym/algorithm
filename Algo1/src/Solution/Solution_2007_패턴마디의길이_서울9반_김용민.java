package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

import javax.xml.ws.EndpointReference;

public class Solution_2007_패턴마디의길이_서울9반_김용민 {
	public static String data;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("rs/input_2007.txt"));

		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int tc = 0; tc < T; tc++){
			data = sc.nextLine();
			int count=0;
			for(int i=1;i<=data.length();i++){
				String start = data.substring(0, i);
				String end = data.substring(i,i*2);
				if(start.equals(end)){
					count = i;
					break;
				}
			}
			System.out.println("#" + (tc+1) + " "  + count);
		}
	}
}
