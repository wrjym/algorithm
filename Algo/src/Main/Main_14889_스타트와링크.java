package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_14889_스타트와링크 {

	static int n, k;
	static int [][]map;
	static int []seq;
	static int min;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/14889.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++)
				map[i][j] = sc.nextInt();
		}
		k = n/2;
		seq = new int[k];
		nCr(0,0);
		System.out.println(min);
		sc.close();
	}
	private static void nCr(int idx, int cnt) {
		if(cnt == k){
			int []check = new int[n];
			for(int i=0; i<k; i++)
				check[seq[i]] = 1;
//			System.out.println(Arrays.toString(check));
			ArrayList<Integer> left = new ArrayList<>(),right = new ArrayList<>();
			for(int i=0; i<n; i++){
				if(check[i] == 0)
					left.add(i);
				else
					right.add(i);
			}
			int lTeam = 0, lfirst = 0, lsecond = 0;
			int rTeam = 0, rfirst = 0, rsecond = 0;
			for(int i=0; i<left.size(); i++){
				lfirst = left.get(i);
				rfirst = right.get(i);
				for(int j=0; j<left.size(); j++){
					lsecond = left.get(j);
					rsecond = right.get(j);
					if(i == j)
						continue;
					lTeam += map[lfirst][lsecond];
					rTeam += map[rfirst][rsecond];
				}
			}
//			System.out.println(lTeam + " " + rTeam);
//			System.out.println(left);
//			System.out.println(right);
			min = Math.min(min, Math.abs(lTeam-rTeam));
			
			return ;
		}
		
		for(int i=idx; i<n; i++){
			seq[cnt] = i;
			nCr(i+1,cnt+1);
		}
	}

}
