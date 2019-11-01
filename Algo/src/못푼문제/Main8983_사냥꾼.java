package 못푼문제;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
 * 문제 해석
 * KOI이라는 사냥터가 있는데, N마리의 동물들이 있고, 그들은 모두 양수의 좌표위에 살고 있다.
 * 사냥꾼은 일직선 상에 위치한 M개의 사대에서만 사격 가능. (사대 : 총을 쏠 수 있는 위치)
 * 동물이 사는 위치 (a1,b1) (a2,b2) ... 과 같이 x,y좌표로 나타낸다.
 * 총의 사정거리 L
 * 사대와 동물의 위치 = |X - a| + b	X사대의 좌표
 * 
 * 
 * 
 * 입력
 * 1. 사대의 갯수(M), 동물의 수(N), 사정거리 (L)
 * 2. 사대의 좌표 * M (x좌표)
 * 3. 동물의 x,y좌표 * N
 * 
 * 풀이방법
 * 2차원 배열을 통해 map을 생성해준다.
 * 사대의 값을 -1로 초기화해준다.
 * 동물의 좌표를 1로 만들어준다.
 * 사대에서 닳을 수 있는 동물의 좌표값을 ++ 해준다.
 * 
 * 
 * 
 */


public class Main8983_사냥꾼 {
	static class rc_8983{
		public long x;
		public long y;
		public rc_8983(long y, long x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	static int ans;
	static ArrayList<rc_8983> li;
	static ArrayList<rc_8983> animal;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/8983.txt"));
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();		//사대의 수
		int N = sc.nextInt();		//동물의 수
		int L = sc.nextInt();		//사정거리
		ans = 0;
		li = new ArrayList<>();
		animal = new ArrayList<>();
		for(int i=0; i<M; i++){
			li.add(new rc_8983(sc.nextLong(),0));
		}

		for(int i=0; i<N; i++){
			animal.add(new rc_8983(sc.nextLong(), sc.nextLong()));
		}
		
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				long tmp = Math.abs(animal.get(j).x) + Math.abs(animal.get(j).y - li.get(i).y);
			}
			
			
			System.out.println();
		}
		


	}

}

