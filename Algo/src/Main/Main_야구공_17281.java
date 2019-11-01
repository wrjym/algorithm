package Main;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_야구공_17281 {
	static int ining;
	static int[][] map;
	static int[] bestbetter;
	static int[] seq;
	static int[] v;
	static int max;
	static int sum;
	static int count;
	static int out;
	static int base[];
	static boolean b;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/17281.txt"));
		Scanner sc = new Scanner(System.in);

		count = 0;
		ining = sc.nextInt();
		map = new int[ining][8];
		bestbetter = new int[ining];
		seq = new int[8];
		v = new int[8];
		max = 0;
		for (int i = 0; i < ining; i++) {
			bestbetter[i] = sc.nextInt();
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Permitation(0);
		System.out.println(max);
	}

	private static void Permitation(int cnt) {
		if(cnt == seq.length){
			count++;
			sum = 0;
			base = new int[3];
			int start = 1;
			int now = 0;

			for(int i=0; i<ining; i++){
				b = true;
				out = 0;

				while(b){
					if(start == 4){
						movebetter(bestbetter[i]);
					}
					else {
						movebetter(map[i][seq[now++]]);
					}
					start++;
					if(start == 10 && now == 8){
						start = 1;
						now = 0;
					}
				}
			}
			max = Math.max(max, sum);
			return ;
		}
		for(int i=0; i<seq.length; i++){
			if(v[i] == 0){
				v[i] = 1;
				seq[cnt] = i;
				Permitation(cnt+1);
				v[i] = 0;
			}
		}

	}


	private static void movebetter(int val) {
		switch(val){
		case 1: case 2: case 3: 
			for(int i=0; i<val; i++){
				if(base[2] == 1){
					sum += 1;
				}
				base[2] = base[1];
				base[1] = base[0];
				base[0] = 0;
			}
			base[val-1] = 1;
			break;
		case 4:
			for(int i=0; i<val; i++){
				if(base[2] == 1){
					sum += 1;
				}
				base[2] = base[1];
				base[1] = base[0];
				base[0] = 0;
			}
			sum += 1;
			break;
		case 0:
			out++;
			if(out == 3){
				base = new int[3];
				max = Math.max(max, sum);
				b = false;
			}
			break;
		}


	}



}
