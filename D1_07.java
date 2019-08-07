package D1;

import java.util.Scanner;
/*
 *  최대값 구하기
 */
public class D1_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
        int line = input.nextInt();
        int max = 0;
        
        for(int i=0; i<line; i++){
            for(int j=0; j<10; j++){
                int num=input.nextInt();
                if(max<num){
                    max=num;
                }
            }
            System.out.println("#"+(i+1)+" "+max);
            max=0;
        }
	}

}
