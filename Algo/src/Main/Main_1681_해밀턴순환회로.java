package Main;import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1681_해밀턴순환회로 {
	public static int [][]map;
	public static int []visited;
	public static int min;
	public static int n;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1681.txt"));
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n+1][n+1];
		visited = new int[n+1];

		visited[1] = 1;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				map[i][j] = sc.nextInt();
			}
		}
		min = Integer.MAX_VALUE;
		dfs(1,0,0);

		System.out.println(min);
	}

	private static void dfs(int v, int sum, int depth) {
		if(sum > min)
			return ;

		if(depth == n-1 && map[v][1] != 0){
			sum += map[v][1];
			if(sum < min)
				min = sum;
			return ;
		}

		for(int i=2; i<=n; i++){
			if(visited[i] == 0 && map[v][i] != 0){
				visited[i] = 1;
				dfs(i,sum+map[v][i],depth+1);
				visited[i] = 0;
			}

		}



	}

}
