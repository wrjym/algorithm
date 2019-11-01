package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main_나무재테크 {
	static class xyr{
		public int x;
		public int y;
		public int year;
		public xyr(int x, int y, int year) {
			super();
			this.x = x;
			this.y = y;
			this.year = year;
		}
		@Override
		public String toString() {
			return "xyr [x=" + x + ", y=" + y + ", year=" + year + "]";
		}
	}
	public static int []dx = {0,-1,-1,-1,0,1,1,1};
	public static int []dy = {-1,-1,0,1,1,1,0,-1};
	public static int [][]map;
	public static int [][]riceMap;
	public static int n,m,k;
	public static ArrayList<xyr> list;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		map = new int[n+1][n+1];
		riceMap = new int[n+1][n+1];
		list = new ArrayList<>();
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				map[i][j] = sc.nextInt();
				riceMap[i][j] = 5;
			}
		}
		for(int i=0; i<m; i++){
			list.add(new xyr(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		sortList();
		for(int year=0; year<k; year++){
			spring();
			fall();
			sortList();
			winter();
		}
		System.out.println(list.size());
	}
	private static void sortList() {
		Collections.sort(list, new Comparator<xyr>() {
			@Override
			public int compare(xyr o1, xyr o2) {
				if(o1.year < o2.year){
					return -1;
				}
				else if(o1.year > o2.year){
					return 1;
				}
				else{
					return 0;
				}
			}
		});	
	}
	private static void winter() {
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				riceMap[i][j] += map[i][j];
			}
		}
	}
	private static void fall() {
		for(int i=0; i<list.size(); i++){
			int x = list.get(i).x;
			int y = list.get(i).y;
			int year = list.get(i).year;
			if(year%5 == 0){
				for(int k=0; k<dx.length; k++){
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(1 <= nx && nx <= n && 1 <= ny && ny <= n){
						list.add(new xyr(nx,ny,1));
					}
				}
			}
		}
//		System.out.println(list);
	}
	private static void spring() {
		ArrayList<xyr> li = new ArrayList<>();
		ArrayList<Integer> removeNum = new ArrayList<>();
		for(int i=0; i<list.size(); i++){ //봄에 양분 확인하고 양분없으면 죽이기 위해 removeNum에 데이터 넣는다.
			int x =list.get(i).x;
			int y = list.get(i).y;
			int year = list.get(i).year;
			if(riceMap[x][y] >= year){
				riceMap[x][y] -= year;
				list.set(i, new xyr(x,y,year+1));
			}
			else{
				removeNum.add(i);
				li.add(list.get(i));
			}
		}
		
		Collections.reverse(removeNum);	//remove값 바꿔서 데이터 넣기.
		for(int i=0; i<removeNum.size(); i++){
			int x = li.get(i).x;
			int y = li.get(i).y;
			int year = li.get(i).year;
			riceMap[x][y] += (year/2);
			list.remove(removeNum.get(i).intValue());
		}
		
		
	}

}
