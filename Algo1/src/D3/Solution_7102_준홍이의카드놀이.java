package D3;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_7102_준홍이의카드놀이 {

	public static int d[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/7102.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			d = new int [n+m+1];
			for(int i=1; i<=n; i++){
				for(int j=1; j<=m; j++){
					d[i+j]++;
				}
			}
			int max=0;
			for(int i=0; i<n+m+1; i++){
				max = Math.max(max, d[i]);
			}
			System.out.print("#" + tc + " ");
			for(int i=0; i<n+m+1; i++){
				if(d[i]==max){
					System.out.print(i+ " ");
				}
			}
			System.out.println();
		}
	}


}
