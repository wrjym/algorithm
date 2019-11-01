package queue;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BfsTest {
	public static int V;
	public static int E;
	public static int [][] graph;
	public static int [] queue;
	public static int rear = -1;
	public static int front = -1;
	public static int top = -1;
	public static boolean[] visit;


	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/inputdfs.txt"));
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		graph = new int[V][V];
		visit = new boolean[V];
		front=0;
		rear=0;

		queue = new int[100];
		top = -1;
		for(int i=0; i<E ; i++){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = graph[v2][v1] = 1;
		}
		//		dfsr(0);
		//		dfs(0);
		bfs(0);
		System.out.println();
		for(int [] a : graph) System.out.println(Arrays.toString(a));

	}

	public static void bfs(int node) {
		//		visit = new boolean[V];
		//		top = -1;

		queue[(++rear)%V] = node;
		while(front!=rear){
			int curr = queue[(++front)%V];	//pop();
			if(visit[curr]==false){
				visit[curr] = true;
				System.out.print(curr + " ");
				for(int next=0; next<V; next++){
					//				for(int next=V-1; next>=0; next--){
					if(visit[next]==false && graph[curr][next]==1){
						queue[(++rear)%V] = next;
					}
				}
			}
		}

	}
//
//	public static void dfsr(int node) {
//		visit[node] = true;
//		System.out.print(node + " ");
//
//		for(int next=0; next<V; next++){
//			if(!visit[next] && graph[node][next] == 1){
//				dfsr(next);
//			}
//		}
//
//	}

}
