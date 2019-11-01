package Main;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_14501_퇴사 {

	static class Schedule{
		int T,P;
		public Schedule(int t, int p) {
			super();
			T = t;
			P = p;
		}
		@Override
		public String toString() {
			return "Schedule [T=" + T + ", P=" + P + "]";
		}
	}
	static int max,n,k;
	static int []seq;
	static ArrayList<Schedule> schedule;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/14501.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();
		String []tmps;
		n = Integer.parseInt(tmp);
		max = 0;
		schedule = new ArrayList<>();
		for(int i=0; i<n; i++){
			tmp = br.readLine();
			tmps = tmp.split(" ");
			schedule.add(new Schedule(Integer.parseInt(tmps[0]), Integer.parseInt(tmps[1])));
		}
		for(k=1; k<=n; k++){
			seq = new int[k];
			dfs(0,0);
		}
		System.out.println(max);
	}
	private static void dfs(int idx, int cnt) {
		if(cnt == k){
			boolean []checking = new boolean[n];
			int sum = 0;
			for(int i=0; i<k; i++){
				int now = seq[i];
				int T = schedule.get(now).T;
				int P = schedule.get(now).P;
				if(!checking[now] && now+T <= n){
					sum += P;
					for(int j=now; j<now+T; j++)
						checking[j] = true;
				}
				else
					return ;
			}
			max = Math.max(max, sum);
			return ;
		}
		for(int i=idx; i<n; i++){
			seq[cnt] = i;
			dfs(i+1, cnt+1);
		}
	}
}
