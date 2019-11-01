package 못푼문제;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
	static class won{
		public double x;
		public double y;
		public int dir;
		public int power;
		public won(double x, double y, int dir, int power) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.power = power;
		}

		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getDir() {
			return dir;
		}
		public void setDir(int dir) {
			this.dir = dir;
		}
		public int getPower() {
			return power;
		}
		public void setPower(int power) {
			this.power = power;
		}
		@Override
		public String toString() {
			return "w[" + x + "] [" + y + "] dir=" + dir + ", power=" + power + "]";
		}

	}
	public static ArrayList<won> list;
	public static int ans;
	public static int reminer;
	public static double []dx = {0,0, -0.5 ,0.5};
	public static double []dy = {0.5, -0.5 ,0,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/5648.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int wonSize = sc.nextInt();
			ans = 0;
			reminer = 0;

			list = new ArrayList<>();
			for(int i=0; i<wonSize; i++){
				list.add(new won(sc.nextDouble(),sc.nextDouble(),sc.nextInt(),sc.nextInt()));
			}
			int cnt = 0;
			while(true){
				cnt++;
				ArrayList<Integer> removeNum = new ArrayList<>();
				for(int i=list.size()-1; i>=0; i--){
					won w = list.get(i);
					double nx = w.x + dx[w.dir];
					double ny = w.y + dy[w.dir];
					if(-1000 <= nx && nx <= 1000 && -1000 <= ny && ny <= 1000){
						list.set(i, new won(nx,ny, w.dir, w.power));
					}
					else {
						removeNum.add(i);
					}
				}
				for(int k=0; k<removeNum.size(); k++){
					list.set(removeNum.get(k), list.get(list.size()-1));
					list.remove(list.size()-1);
				}
				for(int i=0; i<list.size(); i++){
					won w = list.get(i);
					boolean b = true;
					removeNum = new ArrayList<>();

					for(int j=list.size()-1; j>i; j--){
						won cw = list.get(j);
						if(w.x == cw.x && w.y == cw.y){
							b = false;
							removeNum.add(j);
						}
					}
					if(!b){
						removeNum.add(i);
					}

					for(int k=0; k<removeNum.size(); k++){
						ans += list.get(removeNum.get(k)).power;
						int a = removeNum.get(k);
						list.set(a, list.get(list.size()-1));
						list.remove(list.size()-1);
					}
				}
				if(cnt > 4000 || list.size()<2){
					break;
				}
			}
			System.out.println("#" + tc + " " +ans);
		}
	}

}







