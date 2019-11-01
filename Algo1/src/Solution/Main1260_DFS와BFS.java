package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main1260_DFS와BFS {
	public static int [][]map;
	public static int rear = 0, front = 0; // 전단과 후단을 나타내는 변수
	public static int  queue[] = new int[10];
	public static int []search;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/main1260.txt"));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();

		map = new int[N+1][N+1];
		search = new int [N+2];
		for(int i=0; i<M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;

		}

		dfs(1);
		search = new int[10];
		System.out.println();
		BFS(1);
	}
	public static void BFS(int s){
		search[s] = 1;
		queue[rear++] = s;
		//큐에서 다 빼낼때까지
		while (front < rear){
			s = queue[front++];
			for(int i = 1; i <=4; i++){
				if(map[s][i] == 1 && search[i] != 1){
					search[i] = 1;
//					System.out.println(s + "에서 " + i + "로 이동!");
					queue[rear++] = i;
				}
			}
			System.out.print(s + " ");
		}
	}

	public static void dfs(int v) { 
		int n = map.length - 1;
		search[v] = 1;
		System.out.print(v + " "); 
		for (int i = 1; i <= n; i++) {
			if (map[v][i] == 1 && search[i] != 1) {
//				System.out.println("v : " + v + " dfs in ");
				dfs(i);
			}
		}
	}

}
