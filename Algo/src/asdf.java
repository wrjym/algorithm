import java.util.Arrays;
import java.util.Comparator;

public class asdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] solution(String[] strings, int n) {
	      String[] answer = new String[strings.length];
	      Arrays.sort(answer, new Comparator<String>(){
	          
	          @Override
	          public int compare(String o1, String o2){
	              if(o1.charAt(1) < o2.charAt(1)){
	                  return 1;
	              }
	              else if(o1.charAt(1) > o2.charAt(1)){
	                  return -1;
	              }
	              else return 0;             
	          }

	      });
	      System.out.println(Arrays.toString(answer));
	      return answer;
	  }
}
