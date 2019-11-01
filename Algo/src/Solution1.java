import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1 {
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine().trim());
      System.out.println(Arrays.toString(solution(N)));
      
      
   }
   public static int[] solution(int N) {
      int[] answer = new int[2];
      int[] arr = new int[11];
      int max = 0;
      int maxIdx = 0;
      for(int i=2;i<11;i++) {
         int num = N;
         arr[i] = 1;
         while(num>0) {
            if(num%i!=0)arr[i] *=num%i;
            num /= i;
         }
         if(max<=arr[i]) {
            max = arr[i];
            maxIdx = i;
         }
         
      }
      
      answer[0] = maxIdx;
      answer[1] = max;
      System.out.println(Arrays.toString(arr));
      
      
      
      return answer;
   }
   
   
}