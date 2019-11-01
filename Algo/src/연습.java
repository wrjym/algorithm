import java.util.ArrayList;

public class 연습 {
	static ArrayList<Integer> li;
	static int max, k;
	static int []seq,visited;
	public static void main(String[] args) {
		int []v = {20,8,10,1,4,15};
		int v_len = v.length;
		max = 0;
		k = v_len;
		li = new ArrayList<>();
		seq = new int[v_len];
		visited = new int[v_len];
		for(int i=0; i<v_len; i++)
			li.add(v[i]);
		dfs(0,0);
		System.out.println(max);
	}
	private static void dfs(int idx, int cnt) {
		if(cnt == k){
			int []tmp = new int[k];
			for(int i=0; i<k; i++)
				tmp[i] = li.get(seq[i]);
			int sum = 0;
			for(int i=1; i<k; i++)
				sum += Math.abs(tmp[i] - tmp[i-1]);
			max = Math.max(max, sum);
			return ;
		}
		
		for(int i=0; i<k; i++){
			if(visited[i] == 0){
				visited[i] = 1;
				seq[cnt] = i;
				dfs(i+1, cnt+1);
				visited[i] = 0;
			}
		}
	}

}
