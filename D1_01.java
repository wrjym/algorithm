package D1;

import java.util.Scanner;
/*
 *  2072. 홀수만 더하기
 */
import java.util.*;

public class D1_01 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int line = input.nextInt();
        int result = 0;
        for(int i=0; i<line; i++){
            for(int j=0; j<10; j++){
                int num=input.nextInt();
                if(num % 2==1){
                    result+=num;
                }
            }
            System.out.println("#"+(i+1)+" "+result);
            result=0;
        }
    }
}