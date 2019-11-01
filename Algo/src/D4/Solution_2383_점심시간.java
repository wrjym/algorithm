package D4;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2383_점심시간 {

	static class person{
		public int x;
		public int y;
		public int stair1;
		public int stair2;
		public int num;
		public int b;
		public person(int x, int y, int stair1, int stair2,int num, int b) {
			super();
			this.x = x;
			this.y = y;
			this.stair1 = stair1;
			this.stair2 = stair2;
			this.num = num;
			this.b = b;
		}
		public int getB() {
			return b;
		}
		public void setB(int b) {
			this.b = b;
		}
		@Override
		public String toString() {
			return "person"+num+": ["+x+"]["+y+"] stair1:"+stair1 + " starti2:"+stair2 +" " + b;
		}
	}

	static class Stair{
		public int num;
		public int endTime;
		public Stair(int num, int endTime) {
			super();
			this.num = num;
			this.endTime = endTime;
		}
		@Override
		public String toString() {
			return "Stair [num=" + num + ", endTime=" + endTime + "]";
		}

	}

	public static int n;
	public static ArrayList<person> per;
	public static ArrayList<person> tmpPer;
	public static ArrayList<person> sta;
	public static int []seq;
	public static int size;
	public static int ans;
	public static int min;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/2383.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			per = new ArrayList<>();
			tmpPer = new ArrayList<>();
			sta = new ArrayList<>();
			size = 0;
			ans = 0;
			min = Integer.MAX_VALUE;
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					int a = sc.nextInt();
					if(a == 1)
						per.add(new person(i,j,0,0,size++,1));
					else if(a!=0)
						sta.add(new person(i,j,a,a,0,1));
				}
			}
			seq = new int[size];
			sortSta();
			for(int i=0; i<per.size(); i++){
				int R = Math.abs(per.get(i).x-sta.get(0).x) + Math.abs(per.get(i).y-sta.get(0).y);
				int C = Math.abs(per.get(i).x-sta.get(1).x) + Math.abs(per.get(i).y-sta.get(1).y);
				per.set(i, new person(per.get(i).x, per.get(i).y, R, C, per.get(i).num,1));
			}

			sortPer();
			seq = new int[size];
			for(int i=0; i< (1<<size); i++){
				for(int j=0; j<size; j++){
					if(((1<<j)&i) != 0){
						seq[size-1-j] = 1;
					}
					else{
						seq[size-1-j] = 0;
					}
				}
				int time = 0;
				//					System.out.println("----------------------");
//				System.out.println(Arrays.toString(seq));
				Queue<Stair> sta1 = new LinkedList<>();
				Queue<Stair> sta2 = new LinkedList<>();
				tmpPer = new ArrayList<>();
				for(int k=0; k<per.size(); k++){
					tmpPer.add(per.get(k));
				}
				time=0;
				ans = 0;
				while(true){
					while(!sta1.isEmpty()){
						if(sta1.peek().endTime == time){
							ans = Math.max(ans, time);
							sta1.poll();
						}
						else
							break;
					}
					while(!sta2.isEmpty()){
						if(sta2.peek().endTime == time){
							ans = Math.max(ans, time);
							sta2.poll();
						}
						else
							break;
					}
					for(int k=tmpPer.size()-1; k>=0; k--){
						person p = tmpPer.get(k);
						if(time >= p.stair1 && seq[p.num]==0){
							if(sta1.size()<3 ){
								if(p.b == 1){
									sta1.offer(new Stair(p.num, (time+ sta.get(0).stair1+1)));
									tmpPer.remove(k);
								}
								else{
									sta1.offer(new Stair(p.num, (time+ sta.get(0).stair1)));
									tmpPer.remove(k);
								}
							}
							else{
//								tmpPer.get(k).setB(0);
								tmpPer.set(k, new person(p.x, p.y, p.stair1, p.stair2, p.num, 0));
							}
						}
						else if(time >= p.stair2 && seq[p.num]==1){
							if(sta2.size()<3){
								if(p.b == 1){
									sta2.offer(new Stair(p.num, time + sta.get(1).stair2+1));
									tmpPer.remove(k);
								}
								else{
									sta2.offer(new Stair(p.num, time + sta.get(1).stair2));
									tmpPer.remove(k);
								}
							}
							else{
								tmpPer.set(k, new person(p.x, p.y, p.stair1, p.stair2, p.num, 0));
							}
						}
					}
					time++;
					//					System.out.println();
					//					System.out.println(time);
					//					System.out.println("======================");
					//					System.out.println(per);

//					System.out.println("1 : " + sta1 + " 2 : " + sta2);
					if(tmpPer.size()==0 && sta1.isEmpty() && sta2.isEmpty()){
						break;
					}

				}
				min = Math.min(min, ans);
				//				}
			}

			System.out.println("#" + tc + " " + min);
		}
	}

	private static void sortPer() {
		Collections.sort(per, new Comparator<person>() {
			@Override
			public int compare(person o1, person o2) {
				if(o1.stair1 < o2.stair1)
					return 1;
				else if(o1.stair1 > o2.stair1){
					return -1;
				}
				else{
					if(o1.stair2 < o2.stair2)
						return 1;
					else
						return -1;
				}
			}
		});
	}
	private static void sortSta() {
		Collections.sort(sta, new Comparator<person>() {

			@Override
			public int compare(person o1, person o2) {
				if(o1.stair1 < o2.stair1){
					return -1;
				}
				else if(o1.stair1 > o2.stair1){
					return 1;
				}
				else{
					if(o2.stair2 < o2.stair2){
						return -1;
					}
					else {
						return 1;
					}
				}
			}
		});
	}


}










