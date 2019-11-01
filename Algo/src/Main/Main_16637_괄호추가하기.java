package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_16637_괄호추가하기 {
	static int n,k,max,count;
	static int []seq;
	static ArrayList<Integer> num;
	static ArrayList<String> opertor;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/16637.txt"));
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		String tmp = sc.next();
		num = new ArrayList<>();
		opertor = new ArrayList<>();
		count = 0;
		for(int i=0; i<n; i++){
			if(i%2 == 0){
				num.add(Integer.parseInt(tmp.charAt(i)+""));
			}
			else{
				opertor.add(tmp.charAt(i)+"");
			}
		}
		max = Integer.MIN_VALUE;
		for(k=0; k<=opertor.size();k++){
			seq = new int[k];
			dfs(0,0);
		}
		System.out.println(max);
	}
	private static void dfs(int idx, int cnt) {
		if(cnt == k){
			ArrayList<Integer> tmpNum = new ArrayList<>();
			ArrayList<String> tmpOpertor = new ArrayList<>();
			for(int i=0; i<num.size(); i++)
				tmpNum.add(num.get(i));
			for(int i=0; i<opertor.size(); i++)
				tmpOpertor.add(opertor.get(i));
			for(int i=1; i<k; i++){
				if(seq[i] - seq[i-1] < 2)
					return;
			}
			if(seq.length > 0){
				for(int i=seq.length-1; i>=0; i--){
					int a = tmpNum.get(seq[i]);
					int b = tmpNum.get(seq[i]+1);
					int sum = 0;
					tmpNum.remove(seq[i]+1);
					switch(tmpOpertor.get(seq[i])){
					case "+":
						sum = a + b;
						break;
					case "-":
						sum = a - b;
						break;
					case "*":
						sum = a * b;
						break;
					}
					tmpOpertor.remove(seq[i]);
					tmpNum.set(seq[i], sum);
				}
			}
			int sum = tmpNum.get(0);
			for(int i=0; i<tmpOpertor.size(); i++){
				switch(tmpOpertor.get(i)){
				case "+":
					sum += tmpNum.get(i+1);
					break;
				case "-":
					sum -= tmpNum.get(i+1);
					break;
				case "*":
					sum *= tmpNum.get(i+1);
					break;
				}
			}
			max = Math.max(sum, max);
			return ;
		}

		for(int i=idx; i<opertor.size(); i++){
			seq[cnt] = i;
			dfs(i+1, cnt+1);
		}
	}

}
