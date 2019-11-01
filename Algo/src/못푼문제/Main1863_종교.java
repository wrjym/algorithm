package 못푼문제;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 1863 종교
 * 
 * 	제한사항 : 0 < n <= 50,000
 * 	같은 종교를 가지는 사람들끼리 짝짓도록 하는 것.
 * 	쌍의 수는 m(0 <= m <= 100,000)  =>		어떤 종교를 가지는지는 몰라도 *종교의 가지수를 알 수 있다.
 * 	1 <= i,j <= n
 *	
 *	input :	1줄 : n, m
 *			2줄 : i, j
 *				 i,j는 i번 학생과 j번 학생이 같은 종교를 가진 학생의 쌍. 
 *
 *	input ex) 
 *	10 9
 *	1 2
 *	1 3
 *	1 4
 *	1 5
 *	1 6
 *	1 7
 *	1 8
 *	1 9
 *	1 10
 *
 *	Data : 10명의 사람,	9번의 짝짓기 횟수
 *
 *	output : 몇개의 종교를 가지고 있는지 출력.
 *
 *
 * 	해결방법 : 네트워크 형식의 노드 연결하기.
 * 			노드의 시작점 갯수 출력.
 * 			1->2	1->3	1->4	--- 1->10	모두 다 같은 종교를 의미
 * 
 * 	other case:	1
 * 	10	9
 * 	1	2
 * 	1	3
 * 	1	4
 * 	5	6
 * 	5	7
 * 	5	8
 * 	5	9
 * 	8	10
 * 	9	10
 * 	1->2
 * 	 ->3
 * 	 ->4
 * 	5->6
 * 	 	->7
 * 	 	->8->9->10
 * 		   ->10
 */
public class Main1863_종교 {
	public static int [][]map;
	public static boolean [][]v;
	public static int m,n;
	public static int cnt1=0;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1863.txt"));
		Scanner sc = new Scanner(System.in);


		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][n+1];
		v = new boolean[n+1][n+1];
		for(int i=0; i<m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a] = 1;
		}
//		for(int a[] : map) System.out.println(Arrays.toString(a));
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(map[i][j] == 1 && v[i][j] == false){
					System.out.println(i + " " + j);
					cnt1++;
					dfs(i,j);
				}
			}
		}
//		for(boolean a[] : v) System.out.println(Arrays.toString(a));
		for(int a[] : map) System.out.println(Arrays.toString(a));
		System.out.println(cnt1);
	}
	private static void dfs(int x, int y) {
		v[x][y] = v[y][x] = true;
		map[x][y] = map[y][x] = 2;
		int cnt=0;
		for(int i=0; i<=n; i++){
			if(map[x][i] == 1){
				cnt++;
			}
		}
		if(cnt==0)	return;
//		else System.out.println(cnt + " 있다.");
		for(int i=0; i<=n; i++){
			if(map[x][i]==1 && v[x][i] == false){
				dfs(x,i);
			}
		}
	}

}
