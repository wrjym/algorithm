package stack2;

import java.util.Arrays;

public class Maze {
	public static int[][] maze={
			{0,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,1,1,0,1,1,1,1},
			{1,1,1,0,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,0}
	};
	
	public static int N=maze.length;
	public static int cnt;
	//우 하 좌 상
	public static int []di = {-1,1,0,0};
	public static int []dj = {0,0,-1,1};
	public static int top = -1;
	public static int[] stack;


	public static void main(String[] args) {
		stack = new int[N*N];
		top = -1;
		cnt = 0;
		maze[0][0] = -1;
		solve(0,0);
//		solver(0,0);
		System.out.println();
		for(int[] a:maze)System.out.println(Arrays.toString(a));


	}


	private static void solve(int i, int j) {
		stack[++top]=i*N+j;
		while(top!=-1){
			int curr=stack[top--];
			i=curr/N;
			j=curr%N;
			if(maze[i][j]<=0){
				maze[i][j]=--cnt;
				System.out.println();
				for(int [] a :maze) System.out.println(Arrays.toString(a));
				if(i==N-1 && j==N-1) return ; //미로의 끝
				
				for(int d=0; d<4; d++){
					int ii=i+di[d];
					int jj=j+dj[d];
					if((0<=ii && ii<N) && (0<=jj && jj<N) && maze[ii][jj]==0){
//						maze[ii][jj] = maze[i][j]-1;
						stack[++top] = ii*N+jj;
					}
				}
			}
			
		}
	}


	private static void solver(int i, int j) {
		maze[i][j] = --cnt;
		System.out.println();
		for(int [] a :maze) System.out.println(Arrays.toString(a));
		if(i==N-1 && j==N-1) return ;

		for(int d=0; d<4; d++){
			int ii=i+di[d];
			int jj=j+dj[d];
			if((0<=ii && ii<N) && (0<=jj && jj<N) && maze[ii][jj]==0){
				maze[ii][jj] = maze[i][j]-1;
				solver(ii,jj);
			}
		}

	}

}
