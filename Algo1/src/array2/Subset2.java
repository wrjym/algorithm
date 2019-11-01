package array2;

public class Subset2 {

	public static int[] data = {1,2,1,2};
	public static int N=4,count;
	public static void main(String[] args) {

		for(int i=0; i<16; /*;i<1<<N;i++*/ i++){
			System.out.printf("%4s i=%2d ",Integer.toBinaryString(i), i);
			int sum = 0;

			for(int j=0;j<N;j++){
				// i 1011 1011 1011 1011
				//   0001 0010 0100 1000
				//&연산	//   0001 0010 0000 1000
				// j    0    1    2    3
				if( (i&1<< j ) != 0){
					//i&1<<j *기억할 필요가 있다.
					System.out.print(data[j] + " ");
					sum += data[j];
				}
			}
			System.out.println("\t sum = " + sum);
		}
		
	}

}


