package array1;

public class Sum {

	public static int sum(int N) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=1;i<=N;i++){
			sum +=i;
		}
		return sum;
	}
	public static int sumR(int N) {
		if(N==1){
			return 1;
		}
		return N*sumR(N-1);
	}
	public static void main(String[] args) {
		
		System.out.println(sum(100));
		System.out.println(sumR(7));
	}

}
