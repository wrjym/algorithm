package 못푼문제;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_4676_늘어지는소리만들기 {
	public static ArrayList<String> li ;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/4676.txt"));
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		for(int tc=1; tc<=T; tc++){
			li = new ArrayList<>();
			String text = sc.nextLine();
			li.add("");
			for(int i=0; i<text.length(); i++){
				li.add(text.charAt(i) + "");
			}
			System.out.println(li);
			int n = Integer.parseInt(sc.nextLine());
			String []putN = sc.nextLine().split(" ");
			for(int j=0; j<n; j++){
				int a = Integer.parseInt(putN[j].charAt(0) + "");
				li.set(a , li.get(a) + "-");
				System.out.println(li);
				
			}

			System.out.print("#" + tc + " ");
			for(int i=0 ; i<li.size(); i++){
				System.out.print(li.get(i));
			}
			System.out.println();

		}

	}


}
