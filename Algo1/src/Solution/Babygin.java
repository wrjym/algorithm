package Solution;

import java.util.Arrays;

public class Babygin {

	public static int []arr = {1,2,2,2,3,3};
	public static int []cntarr = new int[10];
	public static void main(String[] args) {

		int babygin=0;
		for(int i=0; i<arr.length; i++){
			cntarr[arr[i]]++;
		}
		int cnt=0;
		int cntdata=0;
		System.out.println(Arrays.toString(cntarr));
		for(int i=1; i<arr.length; i++){
			if(cntarr[i]==3){
				System.out.println("run");
				babygin++;
			}
		}
		
		while(cntdata<=6){
			for(int i=1; i<arr.length; i++){
				if(cntarr[i]>0){
					cnt++;
					cntarr[i]--;
					cntdata++;
				}
				else{
					cnt = 0;
					cntdata++;
				}

				if(cnt==3){
					System.out.println("triple");
					babygin++;
					cnt=0;
				}

			}
		}

		if(babygin==2){
			System.out.println("baby-gin!");
		}

	}

}
