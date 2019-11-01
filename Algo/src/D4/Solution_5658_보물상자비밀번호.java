package D4;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Solution_5658_보물상자비밀번호 {
	static int n,k, quater;
	static String auth;
	static ArrayList<String> li;
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/5658.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mapSet();
		String T = br.readLine();
		for(int tc=1; tc<=Integer.parseInt(T); tc++){
			String nk = br.readLine();
			String nks[] = nk.split(" ");
			n = Integer.parseInt(nks[0]);
			k = Integer.parseInt(nks[1]);
			auth = br.readLine();
			quater = auth.length()/4;
			li = new ArrayList<>();
			for(int i=0; i<auth.length(); i++){
				li.add(auth.charAt(i)+"");
			}
			HashSet<String> set = new HashSet<String>();

			for(int p=0; p<n; p++){
				for(int i=0; i<4; i++){	//0,1,2,3
					String tmp = "";
					for(int j= i*quater; j<(i+1)*quater; j++){
						tmp += li.get(j);
					}
					set.add(tmp);
				}
				String a = li.get(li.size()-1);
				li.add(0,a);
				li.remove(li.size()-1);
			}
			ArrayList<Integer> t = new ArrayList<>();
			for(String s : set){
				int sum = 0;
				for(int i=0; i<s.length(); i++){
					sum += map.get(s.charAt(i)+"") * Math.pow(16, s.length()-i-1); 
				}
				t.add(sum);
			}
			Collections.sort(t, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					if(o1 < o2){
						return 1;
					}
					else {
						return -1;
					}
				}
			});
			System.out.println("#" + tc + " " + t.get(k-1));
		}
	}

	private static void mapSet() {
		map.put("F", 15);
		map.put("E", 14);
		map.put("D", 13);
		map.put("C", 12);
		map.put("B", 11);
		map.put("A", 10);
		for(int i=0; i<10; i++){
			map.put(i+"", i);
		}


	}

}
