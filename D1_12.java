
package D1;
import java.util.*;
/*
 *  서랍의 비밀번호
 */

public class D1_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();
        int count=0;
        for(int i=0; i<input1-input2+1;i++)
        {
        	count++;
        }
        System.out.println(count);
    }
}















