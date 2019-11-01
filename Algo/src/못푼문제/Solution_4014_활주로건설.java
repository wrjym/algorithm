package 못푼문제;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_4014_활주로건설 {
	static int n, k;
	static int [][]map;
	static int max;
	static int ans;
	static boolean b;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/16236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//		int T = Integer.parseInt(br.readLine());
		//		for(int tc = 1; tc<=T; tc++){
		String tmp = br.readLine();
		String []nk = tmp.split(" ");
		n = Integer.parseInt(nk[0]);
		k = Integer.parseInt(nk[1]);
		map = new int[2*n][n];
		ans = 0;
		for(int i=0; i<n; i++){
			tmp = br.readLine();
			nk = tmp.split(" ");
			for(int j=0; j<n; j++){
				map[i][j] = Integer.parseInt(nk[j]);
			}
		}

		for(int i=n; i< 2*n ; i++){
			for(int j=0; j<n; j++){
				map[i][j] = map[j][i-n];
			}
		}

		for(int i=0; i<n*2; i++){
			int cnt = 1;
			int j;
			for(j=0; j<n-1; j++){
				if(map[i][j] == map[i][j+1]){
					cnt++;
				}
				else if(map[i][j] < map[i][j+1] && cnt >= k){
					cnt = 1;
				}
				else if(map[i][j] > map[i][j+1] && cnt >= 0){
					cnt = 1-k;
				}
				else{
					break;
				}
			}

			if(j == n-1 && cnt >= 0){
				ans++;
			}

		}

		System.out.println(ans);
		//			System.out.println("#" + tc + " " + ans);

		//		}

	}

	private static void viewMap() {
		for(int i=0; i<2*n; i++){
			for(int j=0; j<n; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
