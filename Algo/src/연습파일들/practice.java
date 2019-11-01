package 연습파일들;
import java.util.Arrays;

public class practice {
	public static int []seq;
	public static int []v;
	public static int r,n;
	public static void main(String[] args) {
		n = 10;
		r = 5;
		seq = new int[r];

		// 조합.
		nCr(0,0);

		System.out.println();
		r = 3;
		seq = new int[r];
		// 비트마스크
		ddfs();

		System.out.println();
		//순열
		r = 3;
		seq = new int[r];
		nPIr(0);

		System.out.println();
		r = 3;
		seq = new int[r];
		v = new int[n];
		nPr(0);
		
		System.out.println();
		r = 3;
		seq = new int[r];
		v = new int[n];
		nHr(0);

	}
	

	private static void nCr(int idx, int cnt) {
		if(cnt == r	){
			System.out.println(Arrays.toString(seq));
			return ;
		}
		else{
			for(int i=idx; i<n; i++){
				seq[cnt]  = i;
				nCr(i+1, cnt+1);
			}
		}
	}


	private static void nPIr(int cnt) {
		if(cnt == r){
			System.out.println(Arrays.toString(seq));
			return ;
		}

		for(int i=0; i<n; i++){
			seq[cnt] = i;
			nPIr(cnt+1);
		}
	}
	
	private static void nPr(int cnt) {
		if(cnt == r){
			System.out.println(Arrays.toString(seq));
			return;
		}	
		for(int i=0; i<n; i++){
			if(v[i] == 0){
				v[i] = 1;
				seq[cnt] = i;
				nPr(cnt+1);
				v[i] = 0;
			}
		}
	}

	private static void nHr(int cnt) {
		if(cnt == r){
			System.out.println(Arrays.toString(seq));
			return ;
		}
		
		for(int i=0; i<r; i++){
			if(v[i] == 0){
				v[i] = 1;
				seq[cnt] = i;
				nHr(cnt+1);
				v[i] = 0;
			}
		}
	}

	public static void ddfs(){
		for(int i=0; i< (1<<r); i++){
			for(int j=0; j<r; j++){
				if(((1<<j)&i) != 0){
					seq[r-1-j] = 1;
				}
				else{
					seq[r-1-j] = 0;
				}
			}
			System.out.println(Arrays.toString(seq));
		}
	}


}
