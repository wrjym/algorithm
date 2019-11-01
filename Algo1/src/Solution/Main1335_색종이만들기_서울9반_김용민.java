package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main1335_색종이만들기_서울9반_김용민 {
	public static int [][]map;
	public static int blue,white;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/input_색종이.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				map[i][j] = sc.nextInt();
			}
		}
		blue=0;
		white=0;

		for(int []a : map) System.out.println(Arrays.toString(a));

		dfs(0,0,N);

		System.out.println(blue);
		System.out.println(white);
		System.out.println("END POINT");

	}

	private static void dfs(int col,  int row, int size) {	//x row	//y col

		int sum=0;
		for(int j=col; j<col+size; j++){
			for(int i=row; i<row+size; i++){
				sum += map[i][j];
			}
		}

		if(sum == size*size){
			for(int i=col; i<size; i++){
				for(int j=row; j<size; j++){
				}
			}
			blue ++;
			return ;
		}else if(sum==0){
			white++;
			return;
		}

		size /= 2;
		dfs(col ,     row ,     size);
		dfs(col ,     row+size, size);
		dfs(col+size, row,      size);
		dfs(col+size, row+size, size);
	}

}
