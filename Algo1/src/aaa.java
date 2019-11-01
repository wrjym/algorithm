
public class aaa {
	public static int [] a = {10,30,19,20,15};
	public static int sum=0;
	public static int ans=0;
	public static int cnt=1;
	public static void main(String[] args) {

		
		dfs(0,cnt);
		
		System.out.println(ans);

	}
	private static void dfs(int v,int cnt) {
		if(ans < sum){
			ans = sum;
		}
		sum = a[v];
//		System.out.println(sum);
		for(int i=v+1; i<a.length; i++){
			sum += a[i];
			dfs(i,cnt+1);
		}
	}

}
