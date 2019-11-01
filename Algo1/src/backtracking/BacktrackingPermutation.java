package backtracking;

public class BacktrackingPermutation {
	
	public static int [] data = {1, 3, 5, 7};
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
					System.out.print(data[a[i]]+" ");
				}
				System.out.println();
			} else {
				int ncands = candidates(a, k, c); // 아직 선택 되지 않은 수들을 c배열에 저장해옴
				for(int i=0; i<ncands; i++) { // 선택되지 않은 수들 중에 하나를 a에 저장하고 함수 호출
					a[k] = c[i];
					backtrack(a, k+1, input); 
				}
			}
	}
	private static int candidates(int[] a, int k, int[] c) {
		boolean [] perm = new boolean[a.length];
		for(int i=0; i<k; i++) {
			perm[a[i]] = true;
		}
		int ncands = 0;
		for(int i=0; i<perm.length; i++) {
			if(perm[i]==false) {
				c[ncands++] = i;
			}
		}
		return ncands;
	}
	
}
