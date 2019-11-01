import java.util.Arrays;

public class PermTest {
	public static int[] a = {1,2,3};
	public static int N = a.length;
	
	public static void swap(int i,int k){
		int T = a[i];
		a[i] = a[k];
		a[k] = T;
	}
	public static void perm(int n, int k){
		if(k==n){
			System.out.println(Arrays.toString(a));
			return ;
		}
		for(int i=k; i<n; i++){
			swap(k,i);
			perm(n,k+1);
			swap(k,i);
		}
	}
	
	public static void main(String[] args) {
		perm(N,0);
	}

}
