package backtracking;

public class BacktrackingPowerset {
	
	public static int [] data = {1, 3, 5};
	public static int cnt;
	
	public static void main(String [] args) {
		int [] a = new int[data.length];
		backtrack(a, 0, a.length);
		System.out.println(cnt);
	}

	private static void backtrack(int[] a, int k, int input) {//input == N
		int [] c = new int [a.length];
			if(k==input) {
				cnt++;
				for(int i=0; i<input; i++) {
					if(a[i]==1) System.out.print(data[i]+" ");
				}
				System.out.println();
			} else {
				int ncands = candidates(a, k, c);
				for(int i=0; i<ncands; i++) {
					a[k] = c[i];
					backtrack(a, k+1, input);
				}
			}
	}

	private static int candidates(int[] a, int k, int[] c) {
		c[0] = 0;
		c[1] = 1;
		return 2;
	}
	
}
