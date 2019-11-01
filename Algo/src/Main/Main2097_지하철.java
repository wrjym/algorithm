package Main;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2097_지하철 {
	public static  int[][]map;
	public static int[]dist;
	public static int[]path;
	public static int[]visit;
	public static int n,LM;
	public static ArrayList<Integer> list;
	public static Queue<Integer> q;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2097.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		LM = sc.nextInt();
		map = new int[n+1][n+1];
		dist = new int[n+1];
		path = new int[n+1];
		visit = new int[n+1];

		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				map[i][j] = sc.nextInt();
			}
		}
		Dijkstra();		
		q = new LinkedList<>();
		
//		q.offer(n);
		list= new ArrayList<>();
		int a = LM;
		list.add(LM);
		while(true){
			list.add(path[a]);
			a = path[a];
			if(a==1){
				break;
			}
		}
		Collections.reverse(list);
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i) + " ");
		}
	}

	public static void Dijkstra(){
		for(int i=1; i<=n; i++){ //Initialize dist[]
			dist[i] = Integer.MAX_VALUE;
		}
		dist[1] = 0;//initialize dist[start] = 시작점 초기화
		for(int i=1; i<=n; i++){
			int minNode = Integer.MAX_VALUE, minVal = Integer.MAX_VALUE;
			for(int j=1; j<=n; j++){ // extract min
				if(visit[j]==0 && minVal>dist[j]){
					minNode=j;
					minVal = dist[j];
				}
			}
			visit[minNode]=1; //check min node
			for(int j=1; j<=n; j++){ //relaxation
				if(dist[j]>minVal + map[minNode][j]){
					dist[j] = minVal + map[minNode][j];
					path[j] = minNode;
				}
			}
		}
	}
}
