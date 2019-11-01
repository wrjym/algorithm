package D3;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 문제해석
 * 문제가 있고, 그것을 푼 학생들이 있는데, 가장 많은 문제를 푼 학생을 찾고,
 * 만약 가장 많은 문제를 푼 사람이 다수라면 그 인원을 보여줘라.
 * 
 * 입력
 * testcase
 * N,M이 주어진다. (문제풀이 여부 N*M)
 * N*M의 문제를 풀었으면 1 못 풀었으면 0
 * 
 * 해결
 * 한 줄씩 입력 받을때, 인원마다 푼 문제의 수를 하나의 배열에 저장해둔다.
 * 이 후 배열마다 가장 많은 수를 max값을 초기화 해주고
 * max와 같은 문제를 푼 people값을 찾는다.
 * 
 */
public class Solution_6913_동철이의프로그래밍 {
	public static int [] d;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/6913.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			d = new int[n];
			int max=0;
			for(int i=0 ; i<n; i++){
				for(int j=0; j<m; j++){
					if(sc.nextInt() == 1){
						d[i]++;
					}
				}
			}
			for(int i=0; i<d.length; i++){
				max = Math.max(max, d[i]);
			}
			int people=0;
			for(int i=0; i<d.length; i++){
				if(d[i] == max){
					people++;
				}
			}
			System.out.println("#" + tc + " " + people + " " + max);
			
		}
	}

}
