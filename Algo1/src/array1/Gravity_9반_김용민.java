package array1;


import java.io.FileInputStream;
import java.util.Scanner;


public class Gravity_9반_김용민 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("rs/Gravity_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case=0; test_case<T; test_case++){
			int N = sc.nextInt(); //방의 크기.
			int []data = new int [N];
			int []count = new int[N];

			for(int i=0;i<N;i++)
				data[i] = sc.nextInt();
			int max;
			int index=0;

			for(int i=0;i<9;i++){
				max = data[i];
				for(int j=i+1;j<9;j++){
					if(data[j] >= max){
						continue;
					}
					else
						count[i]+=1;
				}
			}


			max = count[0];
			for(int i=1;i<N;i++){
				if(count[i] >= max){
					max = count[i];
				}
			}

			System.out.println("낙차는 " + max + "입니다.");
		}	
		System.out.println("End Point");



	}



}

