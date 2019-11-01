package 연습파일들;
import java.util.Arrays;
import java.util.Scanner;

public class 연습 {
	public static int seq[];
	public static int n,r;
	public static int [][]map;
	public static int [][]v;
	public static int []dx = {0,-1,0,1};
	public static int []dy = {-1,0,1,0};
	public static int max;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("rs/1.txt"));
		Scanner sc = new Scanner(System.in);


		r = 3;
//		n = sc.nextInt();
		map = new int[n][n];
		v = new int[n][n];
		for(int i=0 ; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
			}
		}
		max = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(map[i][j] != 1){
					v = new int[n][n];
					dfs(i,j,0);
				}
			}
		}
		dfs(0,0,0);

		seq = new int[r];
		//		nPr(0);
		//		System.out.println("------------------------------");
		//		nCr(0,0);
		//		System.out.println("END POINT");
		System.out.println(max);
		sc.close();
	}
	private static void dfs(int x, int y, int sum) {
		System.out.println(x + " " + y + " " + sum);
		if(map[x][y] == 3){
			max = Math.max(max, sum);
			v[x][y] = 0;
			return ;
		}

		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < n && 0 <= ny && ny < n){
				if(map[nx][ny]!=1 && v[nx][ny] ==0){
					v[nx][ny] = 1;
					dfs(nx,ny,sum+map[nx][ny]);
					System.out.println();
					for(int []a:v) System.out.println(Arrays.toString(a));
				}
			}
		}
	}
	private static void nPr(int cnt) {

		if(cnt==r){
			System.out.println(Arrays.toString(seq));
			return ;
		}
		for(int i=0; i<n; i++){
			seq[cnt] = i;
			nPr(cnt+1);
			seq[cnt] = 0;
		}
	}
	private static void nCr(int idx,int cnt) {
		if(cnt==r){
			System.out.println(Arrays.toString(seq));
			return;
		}

		for(int i=idx;i<n; i++){
			seq[cnt] = i;
			nCr(i+1,cnt+1);
		}
	}

}
