package array2;

import java.util.Arrays;

public class Array2Test {
	public static int[][] data = {{1,2,3},{4,5,6},{7,8,9}};
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int N = data.length;
	public static int M = data.length;
	public static void main(String[] args){
		//		System.out.println(Arrays.deepToString(data));
		for(int [] a:data) System.out.println(Arrays.toString(a));

		System.out.println();
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[i].length;j++){
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for(int j=0;j<data.length;j++){
			for(int i=0;i<data[j].length;i++){
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for(int j=0;j<N;j++){
			for(int i=0;i<M;i++){
				System.out.print(data[i][j+(M-1-2*j)*(i%2)] + " ");
			}
			System.out.println();
		}
		System.out.println("hhhhh");
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(data[i][j+(M-1-2*j)*(i%2)] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				int sum=0;
				for(int d=0;d<4;d++){
					int ii=i+di[d];
					int jj=j+dj[d];
					if((0<=ii & ii<N) && 0<=jj && jj<M){
						sum += data[ii][jj];
					}
				}
				System.out.print(sum + " ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[i].length;j++){
				if(i<j){
					int tmp = data[i][j];
					data[i][j] = data[j][i];
					data[j][i] = tmp;
				}
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		for(int a[] : data) System.out.println(Arrays.toString(a));
		
		
		
	}

}
