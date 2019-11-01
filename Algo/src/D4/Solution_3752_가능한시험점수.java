package D4;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
 * 입력
 * 첫 줄에 점수가 될 수 있는 횟수가 주어진다.
 * 점수가 될 수 있는 값들 연속으로 주어진다.
 * 
 * 해결방법
 * 1. 점수가 될 수 있는 값이 들어올 때마다 Set에 저장한다.
 * 2. 새로운 수가 들어오면 이전에 들어왔던 값들과 전부 연산을 하고 다시 set에 추가해준다.
 * 3. set의 값을 출력하면 원하는 값이 나온다.
 * 
 * 첫번째 해결하려 했던 모습
 * 1. 모든 값들을 조합으로 만들어서 해당되는 값들을 전부 구한다.
 * 2. 구한값들의 횟수를 모두 구해서 중복되는 것을 빼고, 갯수를 출력한다.
 * -> 시간초과 문제가 발생함.
 * 
 * 출력
 * 점수가 될 수 있는 값들의 방법이 출력된다.
 * 
 */
public class Solution_3752_가능한시험점수 {
	public static HashSet<Integer> set = new HashSet();
	public static int[] sset;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/3752.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int a = sc.nextInt();
			set = new HashSet<>();
			set.add(0);
			for(int i=0; i<a; i++){
				int d = sc.nextInt();
//				System.out.println(d);
				sset = new int[set.size()];
				int cnt=0;
				for (Integer b : set) {
					sset[cnt++] = b;
				}
				
				for(int j=0; j<sset.length; j++){
					set.add(sset[j]+d);
				}
			}			
			System.out.println("#" + tc + " " + set.size());
		}
		
		
	}
}
