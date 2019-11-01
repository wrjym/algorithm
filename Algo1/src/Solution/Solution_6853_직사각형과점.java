package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_6853_직사각형과점 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/input_6853.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int []count = new int[3];
			int x,y;
			int x1,x2,y1,y2;
			x1=sc.nextInt();	y1=sc.nextInt();
			x2=sc.nextInt();	y2=sc.nextInt();

			if (x1 > x2)
			{
				int tmp = x1;
				x1 = x2;
				x2 = tmp;
			}
			if (y1 > y2)
			{
				int tmp = y1;
				y1 = y2;
				y2 = tmp;
			}

			int N = sc.nextInt();

			for(int i=0; i<N; i++){
				x = sc.nextInt();
				y = sc.nextInt();

				if (x1 <= x && x <= x2 && y1 <= y && y <= y2)
				{
					if (x == x1 || x == x2 || y == y1 || y == y2)
						count[1]++;
					else
						count[0]++;
				}
				else
					count[2]++;
			}

			System.out.print("#" + tc);
			for(int i=0; i<3; i++){
				System.out.print(" " + count[i]);
			}
			System.out.println();
		}
	}
}
