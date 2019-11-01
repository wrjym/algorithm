package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_14888_연산자끼워넣기 {

	public static int min,max;
	public static int n;
	static int []seq;
	static int []v;
	static int []calnum;
	static ArrayList<Integer> num;
	static ArrayList<Integer> cal;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/14888.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new ArrayList<>();
		cal = new ArrayList<>();
		calnum = new int[4];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		for(int i=0; i<n ;i++)
			num.add(sc.nextInt());
		for(int i=0; i<4; i++)
			calnum[i] = sc.nextInt();
		for(int i=0; i<4; i++){
			for(int j=0; j<calnum[i]; j++)
				cal.add(i);
		}
		seq = new int[cal.size()];
		v = new int[cal.size()];
		nCr(0);
		System.out.println(max + "\n" + min);
		sc.close();
	}
	private static void nCr(int cnt) {
		if(cnt == cal.size()){
			ArrayList<Integer> tmpCal = new ArrayList<>();
			ArrayList<Integer> tmpNum = new ArrayList<>();
			for(int i=0; i<cal.size(); i++){
				tmpCal.add(cal.get(seq[i]));
				tmpNum.add(num.get(i));
			}
			tmpNum.add(num.get(num.size()-1));
			int sum = 0;
			for(int i=0; i<tmpCal.size(); i++){
				sum = calFunction(tmpNum.get(i),tmpNum.get(i+1), tmpCal.get(i), i);
				tmpNum.set(i+1 ,sum);
				tmpNum.remove(i);
				tmpCal.remove(i);
				i--;
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return ;
		}

		for(int i=0; i<cal.size(); i++){
			if(v[i] == 0){
				v[i] = 1;
				seq[cnt] = i;
				nCr(cnt+1);
				v[i] = 0;
			}
		}

	}
	private static int calFunction(Integer a, Integer b, Integer calData, int index) {
		int sum = 0;
		/*
		 * 0 : +
		 * 1 : -
		 * 2 : *
		 * 3 : /
		 */
		switch(calData){
		case 0:
			sum = a + b;
			break;
		case 1:
			sum = a - b;
			break;
		case 2:
			sum = a * b;
			break;
		case 3:
			if(a < 0){
				a = Math.abs(a);
				sum = a / b;
				sum *= -1;
			}
			else{
				sum = a / b;
			}
			break;
		}
		return sum;
	}
}
