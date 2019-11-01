package Main;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_리모컨{
	static String channelStr;
	static int channel;
	static int n;
	static int []tmp;
	static int []seq;
	static int []num;
	static int count = 0;
	static int ans = 0;
	static boolean b = false;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1107.txt"));
		Scanner sc = new Scanner(System.in);

		channelStr = sc.nextLine();
		channel = Integer.parseInt(channelStr);
		n = sc.nextInt();
		tmp = new int[10];
		ans = Integer.MAX_VALUE;
		num = new int[tmp.length-n];
		seq = new int[channelStr.length()+1];
		for(int i=0; i<n; i++) {
			tmp[sc.nextInt()] = 1;
		}
		int cnt = 0;
	
		for(int i=0; i<tmp.length; i++) {
			if(tmp[i] == 0) {
				num[cnt++] = i;
			}
		}
		for(int i=0; i<=250000; i++) {
			checks((channel-i));
			checks((channel+i));
			if(b){
				break ;
			}
		}

		ans = Math.min(ans, Math.abs(channel-100));
		System.out.println(ans);
		sc.close();
	}
	private static void checks(int now) {
//		System.out.println(now);
		if(now < 0){
			return ;
		}
		String tmp = now+"";
		for(int i=0; i<num.length; i++) {
			tmp = tmp.replace((num[i]+""), "");
		}
		if(tmp.equals("")) {
			ans = Math.min(ans, Math.abs(channel-now)+(now+"").length());
//			System.out.println("함수 : " + ans);
			b = true;
		}
	}

}
