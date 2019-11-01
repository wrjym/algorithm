package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_2048_Easy {
	public static int M;
	public static int [][]map;
	public static int [][]tmpMap;
	public static int []seq = {0,3,0,1,0};
	public static int max;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1.txt"));
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		map = new int[M][M];
		max = 0;
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				map[i][j] = sc.nextInt();
			}
		}
		seq = new int[5];
		dfs(0);
		System.out.println(max);
		
	}
	private static void view() {
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				System.out.print(tmpMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void dfs(int cnt) {
		if(cnt == 5){
			tmpMap = new int[M][M];
			for(int i=0; i<M; i++){
				for(int j=0; j<M; j++){
					tmpMap[i][j] = map[i][j];
				}
			}
			
			for(int i=0; i<seq.length; i++){
				changeMap(seq[i]);
			}

			for(int i=0; i<M; i++){
				for(int j=0; j<M; j++){
					max = Math.max(max, tmpMap[i][j]);
				}
			}
			
			return ;
		}
		
		for(int i=0; i<4; i++){
			seq[cnt] = i;
			dfs(cnt+1);
			seq[cnt] = 0;
		}
	}
	private static void changeMap(int dir) {
		switch(dir){
		case 0:
//			System.out.println("left");
			left();
			break;
		case 1:
//			System.out.println("up");
			up();
			break;
		case 2:
//			System.out.println("right");
			right();
			break;
		case 3:
//			System.out.println("down");
			down();
			break;
		}
		
	
		
	}
	private static void down() {
		for(int i=0; i<M; i++){
			ArrayList<Integer> li = new ArrayList<>();
			int cnt = 0;
			for(int j=M-1; j>=0; j--){
				if(tmpMap[j][i] != 0){
					li.add(tmpMap[j][i]);
					tmpMap[j][i] = 0;
					cnt++;
				}
			}
			int tmpCnt=0;
			for(int j=M-1; j>=0; j--){
				if(tmpCnt == cnt){
					break;
				}
				tmpMap[j][i] = li.get(tmpCnt++);
			}
		}
		for(int i=0; i<M; i++){
			for(int j=M-2; j>=0; j--){
				if(tmpMap[j+1][i] == tmpMap[j][i] ){
					tmpMap[j+1][i] = tmpMap[j][i]*2;
					tmpMap[j][i] = 0;
				}
			}
		}
		
		for(int i=0; i<M; i++){
			ArrayList<Integer> li = new ArrayList<>();
			int cnt = 0;
			for(int j=M-1; j>=0; j--){
				if(tmpMap[j][i] != 0){
					li.add(tmpMap[j][i]);
					tmpMap[j][i] = 0;
					cnt++;
				}
			}
			int tmpCnt=0;
			for(int j=M-1; j>=0; j--){
				if(tmpCnt == cnt){
					break;
				}
				tmpMap[j][i] = li.get(tmpCnt++);
			}
		}
		
	}
	private static void right() {
		for(int i=0; i<M; i++){
			ArrayList<Integer> li = new ArrayList<>();
			int cnt = 0;
			for(int j=M-1; j>=0; j--){
				if(tmpMap[i][j] != 0){
					li.add(tmpMap[i][j]);
					tmpMap[i][j] = 0;
					cnt++;
				}
			}
			int tmpcnt=0;
			for(int j=M-1; j>=0; j--){
				if(tmpcnt==cnt){
					break;
				}
				tmpMap[i][j] = li.get(tmpcnt++);
				
			}
		}
		
		for(int i=0; i<M; i++){
			for(int j=M-2; j>=0; j--){
				if(tmpMap[i][j]==tmpMap[i][j+1]){
					tmpMap[i][j+1] = tmpMap[i][j+1]*2;
					tmpMap[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<M; i++){
			ArrayList<Integer> li = new ArrayList<>();
			int cnt = 0;
			for(int j=M-1; j>=0; j--){
				if(tmpMap[i][j] != 0){
					li.add(tmpMap[i][j]);
					tmpMap[i][j] = 0;
					cnt++;
				}
			}
			int tmpcnt=0;
			for(int j=M-1; j>=0; j--){
				if(tmpcnt==cnt){
					break;
				}
				tmpMap[i][j] = li.get(tmpcnt++);
			}
		}
		
		
	}
	private static void up() {
		for(int i=0; i<M; i++){
			ArrayList<Integer> li = new ArrayList<>();
			int cnt=0;
			for(int j=0; j<M; j++){
				if(tmpMap[j][i]!=0){
					li.add(tmpMap[j][i]);
					tmpMap[j][i] = 0;
					cnt++;
				}
			}
			for(int j=0; j<cnt; j++){
				tmpMap[j][i] = li.get(j);
			}
		}
		
		for(int i=0; i<M; i++){
			for(int j=1; j<M; j++){
				if(tmpMap[j][i]== tmpMap[j-1][i]){
					tmpMap[j-1][i] = tmpMap[j][i]*2;
					tmpMap[j][i] = 0;
				}
			}
		}
		
		for(int i=0; i<M; i++){
			ArrayList<Integer> li = new ArrayList<>();
			int cnt=0;
			for(int j=0; j<M; j++){
				if(tmpMap[j][i]!=0){
					li.add(tmpMap[j][i]);
					tmpMap[j][i] = 0;
					cnt++;
				}
			}
			for(int j=0; j<cnt; j++){
				tmpMap[j][i] = li.get(j);
			}
		}
	}
	
	private static void left() {
		for(int i=0; i<M; i++){
			ArrayList<Integer> li = new ArrayList<>();
			for(int j=0; j<M; j++){
				if(tmpMap[i][j]!=0){
					li.add(tmpMap[i][j]);
					tmpMap[i][j] = 0;
				}
			}
			for(int j=0; j<li.size(); j++){
				tmpMap[i][j] = li.get(j);
			}
		}
		
		for(int i=0; i<M; i++){
			for(int j=1; j<M; j++){
				if(tmpMap[i][j]==tmpMap[i][j-1]){
					tmpMap[i][j-1] = tmpMap[i][j]*2;
					tmpMap[i][j] = 0;
				}
			}
		}

		for(int i=0; i<M; i++){
			ArrayList<Integer> li = new ArrayList<>();
			for(int j=0; j<M; j++){
				if(tmpMap[i][j]!=0){
					li.add(tmpMap[i][j]);
					tmpMap[i][j] = 0;
				}
			}
			for(int j=0; j<li.size(); j++)
				tmpMap[i][j] = li.get(j);
		}
		
	}
	
	
}
