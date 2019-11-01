package D4;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_13458_시험감독 {
	static int n;
	static int b,c;
	static int []room;
	static long ans;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("rs/13458.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		room = new int[n];
		ans = 0;
		for(int i=0; i<n; i++)
			room[i] = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();;

		for(int i=0; i<n; i++)
			room[i]-= b;
		for(int i=0; i<n; i++){
			if(room[i] > 0)
				ans += (room[i]%c==0) ? room[i]/c : (room[i]/c)+1 ;
		}
		System.out.println(ans+n);
		sc.close();
	}
}

