package 못푼문제;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2112_보호필름 {

	static int d,c,k;
	static int [][]map;
	static int [][]tmpMap;
	static int []seq;
	static boolean []v;
	static int ans;
	static Boolean ansB;

	static int nPr;
	static int []check;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/2112.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			d = sc.nextInt();
			c = sc.nextInt();
			k = sc.nextInt();
			ans = 0;
			ansB = false;
			map = new int[d][c];
			tmpMap = new int[d][c];
			check = new int[c];
			v = new boolean[d];
			for(int i=0; i<d; i++){
				for(int j=0; j<c; j++){
					map[i][j] = sc.nextInt();
				}
			}
			if(k==1){
				System.out.println("#" + tc + " " + 0);
			}
			else{
				ans = k;
				for(int i=0; i<k; i++){
					seq = new int[i];
					
					nPr = i;
					dfs(0,0);
					if(ansB){
						break;
					}
				}
				System.out.println("#" + tc + " " + ans);
			}
		}

		sc.close();
	}
	private static void dfs(int idx, int cnt) {
		if(ansB){
			return ;
		}
		if(nPr == cnt){
			for(int i=0; i<d; i++){
				for(int j=0; j<c; j++){
					tmpMap[i][j] = map[i][j];
				}
			}
			for(int num=0; num<2; num++){
				for(int i=0; i<cnt; i++){
					for(int j=0; j<c; j++){
						tmpMap[seq[i]][j] = num;
					}
				}
				for(int i=0; i<c; i++){
					 for(int j=0; j<d-k+1; j++){
						int count = 0;
						for(int m=j; m <j+k; m++)
							count += tmpMap[m][i];
						if(count==k || count == 0){
							check[i] = 1;
							break;
						}
 					}
					if(check[i] == 0)
						break;
				}
				int sum = 0;
				for(int i=0; i<c; i++){
					if(check[i] == 1){
						sum++;
					}
					check[i] = 0;
				}
				if(sum == c){
					ans = cnt;
					ansB = true;
					break;
				}
			}
			return ;
		}
		for(int i=1; i<d-1; i++){
			if(!v[i]){
				v[i] = true;
				seq[cnt] = i;
				dfs(i+1, cnt+1);
				v[i] = false;
			}
		}
	}
}
