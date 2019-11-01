package D3;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_4613_러시아국기같은깃발 {
	public static int []seq;
	public static int [][]wbr;
	public static String []line;
	public static int r,n,m;
	public static int ans;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/4613.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			m = sc.nextInt();
			r = 3;
			ans = Integer.MAX_VALUE;
			wbr = new int[n+1][3];
			line = new String[m];
			seq = new int[n];
			sc.nextLine();
			for(int i=0; i<n; i++){
				String a = sc.nextLine();
				line = a.split("");
//				System.out.println(Arrays.toString(line));
				for(int j=0; j<m; j++){
					switch(line[j]){
					case "W":{
						wbr[i][0]++;
						break;
					}
					case "B":{
						wbr[i][1]++;
						break;
					}
					case "R":{
						wbr[i][2]++;
						break;
					}
					}
				}

			}
//						for(int []bb: wbr)System.out.println(Arrays.toString(bb));
			nCr(0,0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void nCr(int cnt, int idx) {
		if(cnt == r){
//			System.out.println(Arrays.toString(seq));
			int max=0, min=Integer.MAX_VALUE;
			for(int i=0; i<seq.length; i++){
				if(seq[i]==1){
					if(i < min){
						min = i;
					}
					if(i > max){
						max = i;
					}
				}
			}
			findMin(min,max);
		}
		else{
			for(int i=idx; i<n; i++){
				seq[i]++;
				nCr(cnt+1, i+1);
				seq[i]--;
			}
		}
	}
	private static void findMin(int min, int max) {
		int sum=0;
		for(int i=0; i<=min; i++){
			sum += m-wbr[i][0];
		}
		
		for(int i=min+1; i<max; i++){
			sum += m-wbr[i][1];
		}
		for(int i=max; i<n; i++){
			sum += m-wbr[i][2];
		}
		if(ans > sum){
			ans = sum;
		}
	}

}
