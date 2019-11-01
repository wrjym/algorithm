package D4;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_5215_햄버거다이어트 {
	static class Hambuger{
		int score, cal;

		public Hambuger(int score, int cal) {
			super();
			this.score = score;
			this.cal = cal;
		}

		@Override
		public String toString() {
			return "Hambuger [score=" + score + ", cal=" + cal + "]";
		}
	}
	static int n,k;
	static int 칼로리;
	static int []seq;
	static ArrayList<Hambuger> ham;
	static Hambuger h;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/5215.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			칼로리 = sc.nextInt();
			ham = new ArrayList<>();
			h = new Hambuger(Integer.MIN_VALUE, Integer.MIN_VALUE);
			for(int i=0; i<n; i++){
				ham.add(new Hambuger(sc.nextInt(), sc.nextInt()));
			}

			ddfs(0,0,0);

			//			for(k=0; k<=n; k++){
			//				seq = new int[k];
			//				dfs(0,0);
			//			}
			System.out.println("#" + tc + " " + h.score);
		}
	}
	private static void ddfs(int cal, int score, int idx) {
		if(idx == ham.size()){
			if(cal <= 칼로리 ){
				if(score >= h.score)
					h = new Hambuger(score, cal);
			}
			return ;
		}

		ddfs((cal + ham.get(idx).cal), score + ham.get(idx).score, idx+1);
		ddfs(cal,score,idx+1);
	}
	private static void dfs(int idx, int cnt) {
		if(cnt == k){
			int sumScore = 0;
			int sumCal = 0;
			for(int i=0; i<k; i++){
				sumScore += ham.get(seq[i]).score;
				sumCal += ham.get(seq[i]).cal;
			}
			if(sumCal <= 칼로리){
				if(sumScore > h.score){
					h = new Hambuger(sumScore, sumCal);
				}
			}

			return;
		}

		for(int i=idx; i<n; i++	){
			seq[cnt] = i;
			dfs(i+1, cnt+1);
		}

	}

}
