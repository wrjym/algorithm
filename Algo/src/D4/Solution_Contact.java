package D4;

import java.awt.List;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SE{
	public int start;
	public int end;
	public int level;

	public SE(int start, int end, int level) {
		this.start = start;
		this.end = end;
		this.level = level;
	}
	public void addLevel(int level){
		this.level = level+1;
	}

	@Override
	public String toString() {
		return "start=" + start + ", end=" + end + ", level=" + level +"\n";
	}
}

public class Solution_Contact {
	public static int max;
	public static int maxLevel;
	public static Queue<SE> q;
	public static ArrayList<SE> list;
	public static boolean []v = new boolean[101];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1238.txt"));
		Scanner sc = new Scanner(System.in);

		for(int tc=1; tc<=10; tc++){
			int n = sc.nextInt();
			int startNum = sc.nextInt();
			q = new LinkedList<>();
			list = new ArrayList<>();
			v = new boolean[101];
			max = 0;
			maxLevel=0;
			for(int i=0; i<n/2; i++){
				list.add(new SE(sc.nextInt(),sc.nextInt(),1));
			}

			Collections.sort(list, new Comparator<SE>() {
				@Override
				public int compare(SE o1, SE o2) {
					return Integer.compare(o1.start, o2.start);
				}
			});


			q.offer(new SE(startNum,startNum,0));
			v[startNum]=true;
			bfs();
			System.out.println(max);

		}
	}
	private static void bfs() {
		while(!q.isEmpty()){

//			System.out.println("queue="+q);

			SE a = q.poll();
			int end = a.end;
//			System.out.println(a.start + "->" + a.end + "  " + a.level + " " + max);
			if(maxLevel < a.level){
				maxLevel = a.level;
				max = 0;
			}
			if(max < a.end){
				max = a.end;
			}

			for(int i=0; i<list.size(); i++){
				if(a.end == list.get(i).start && v[list.get(i).end]==false){
					//										System.out.println(list.get(i).start + "->" + list.get(i).end + "  " + a.level);
					SE se = list.get(i);
					se.addLevel(a.level);
					q.offer(se);

					v[list.get(i).end] = true;
				}

				//				if(list.get(i).start == a.end && v[list.get(i).start] == false){
				//					q.add(new SE(list.get(i).start, list.get(i).end, a.level+1));
				//					
				//				}
			}
			//			v[a.end] = true;





		}
	}

}
