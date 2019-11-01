package Permutation;

public class Permutation {

	public static void main(String[] args) {
		int[] data = {1,2,3};
		int count=0;
		for(int i1=1;i1<=3;i1++){			
			for(int i2=1;i2<=3;i2++){
				if(i1 == i2) continue;
				for(int i3=1;i3<=3;i3++){
					if(i1 == i3) continue;
					if(i2 == i3) continue;
					
					System.out.println(i1 + " " + i2 + " " + i3 );
					count++;
				}

			}
		}
		System.out.println(count);
		

//		int [] ib = {1,2,3,4,5,6,7};
//		int [][] ii = new int[7][7];
//		for(int n:ib) //ib대신 collection이 온다.
//			System.out.println(n);

//		for(int [] a:ii)
//			System.out.println(Arrays.toString(ii));
	}

}
