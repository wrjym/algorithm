package 연습파일들;
import java.util.Arrays;

public class test {
	public static int seq[];
	public static int ch[] = {1,2,3,4,5};
	public static int r;
	public static int n;
	public static int cncn=0;
	public static int aaa = 30;
	public static int []a = {1,2,3,4,5,6};
	public static void main(String[] args) {
		
		for(int i=1; i<(1<<a.length); i++){
			for(int j=0; j<a.length;j++){
				if((1&i>>j)>0){
					System.out.print(a[j] + " ");
				}
			}
			System.out.println();
		}
		
		
		n=9;
		r=3;
		seq = new int[n];
//		dfs(0,0);
		nCr(0,0);
	}
	private static void nCr(int cnt, int idx) {
		// TODO Auto-generated method stub
		if (cnt == r) {
//			System.out.println(Arrays.toString(seq));
		} else {
			for (int i = idx; i < n; i++) {
				seq[i] = 1;
				nCr(cnt + 1, i+1);
				seq[i] = 0;
			}
		}
	}

	static void dfs(int cnt){
		if(cnt == r){
			System.out.println(Arrays.toString(seq));
		}else{
			for(int i=0; i<n; i++){
				if(seq[i]==1){
				}else{
					seq[i] = 1;
					dfs(cnt++);
					seq[i] = 0;
				}
			}
		}
	}
}
