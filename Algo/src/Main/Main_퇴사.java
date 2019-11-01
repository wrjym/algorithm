package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_퇴사 {
	static class Work{
		int day,reward;

		public Work(int day, int reward) {
			super();
			this.day = day;
			this.reward = reward;
		}

		@Override
		public String toString() {
			return "Work [day=" + day + ", reward=" + reward + "]";
		}
	}

	static int max;
	static int n,k;
	static int []seq;
	static int []check;
	static ArrayList<Work> work;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/14501.txt"));
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		work = new ArrayList<>();
		check = new int[n];
		max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++)
			work.add(new Work(sc.nextInt(), sc.nextInt()));

		for(int i=1; i<=n; i++){
			k = i;
			//			System.out.println(k);
			seq = new int[k];
			nCr(0,0);
		}

		System.out.println(max);
		sc.close();
	}
	private static void nCr(int idx, int cnt) {
		if(k == cnt){
			check = new int[n];
			int rewardTotal = 0;

			for(int i=0; i<k; i++){
				Work w = work.get(seq[i]);
				int start = seq[i];
				int end = seq[i] + w.day;
				if(0 > start || end > n)
					continue;

				int sum = 0;
				for(int j=start; j<end; j++){
					if(check[j] == 0)
						sum++;
				}
				if(sum == end-start){
					for(int j=start; j<end; j++)
						check[j] = seq[i]+1;
					rewardTotal += w.reward;
				}

			}
//			System.out.println(Arrays.toString(seq));
//			System.out.println(Arrays.toString(check));
//			System.out.println(rewardTotal);
			max = Math.max(max, rewardTotal);

			return ;
		}


		for(int i=idx; i<n; i++){
			seq[cnt] = i;
			nCr(i+1, cnt+1);
		}

	}

}
