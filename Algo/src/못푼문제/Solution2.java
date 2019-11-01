package 못푼문제;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
	static class won{
		public int x;
		public int y;
		public int dir;
		public int power;
		public int cnt;
		public won(int x, int y, int dir, int power, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.power = power;
			this.cnt = cnt;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
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
		public int getCnt() {
			return cnt;
		}
		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "won [" + x + "] [" + y + "] dir=" + dir + ", power=" + power + ", cnt=" + cnt
					+ "]";
		}

	}
	public static ArrayList<won> list;
	public static int cnt;
	public static int ans;
	public static int reminer;
	public static int []dx = {0,0,-1,1};
	public static int []dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/5648.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int wonSize = sc.nextInt();
			ans = 0;
			reminer = 0;
			cnt = 0;
			list = new ArrayList<>();
			for(int i=0; i<wonSize; i++){
				list.add(new won(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),0));
			}
			while(list.size()>1){
				cnt++;
				boolean c = true;
				for(int i=0; i<list.size(); i++){
					if(!list.isEmpty()){
						c = checkWon(list.get(i),i);
						i-=reminer;
						reminer = 0;
					}
					if(!list.isEmpty() && c){
						moveDir(list.get(i), i);
						i-=reminer;
						reminer = 0;
					}
				}
				
				for(int i=0; i<list.size(); i++){
					won w = list.get(i);
					boolean b = false;
					for(int j=list.size()-1; j>i; j--){
						won cWon = list.get(j);
						if(w.x == cWon.x && w.y == cWon.y){
							ans+=cWon.power;
							list.remove(j);
							b = true;
						}
					}
					if(b){
						ans+=w.power;
						list.remove(i);
						i--;
					}
				}

			}

			System.out.println("#" + tc + " " + ans);
		}
	}
	private static boolean checkWon(won won, int now) {
		boolean b = true;
		for(int i=list.size()-1; i>=0; i--){
			if(i!=now){
				won cWon = list.get(i);
				if(won.x == cWon.x && won.y == cWon.y){
					if(won.cnt == cWon.cnt){
						
						ans += cWon.power;
						list.remove(i);
						if(i<now){
							now--;
							reminer++;
						}
						b = false;
					}
					else {
						switch(won.dir){
						case 0:
							if(cWon.dir==1){
								ans += cWon.power;
								list.remove(i);
								b = false;
								if(i<now){
									now--;
									reminer++;
								}
							}
							break;
						case 1:
							if(cWon.dir==0){
								ans += cWon.power;
								list.remove(i);
								b = false;
								if(i<now){
									now--;
									reminer++;
								}
							}
							break;
						case 2:
							if(cWon.dir==3){
								ans += cWon.power;
								list.remove(i);
								if(i<now){
									now--;
									reminer++;
								}
								b = false;
							}
							break;
						case 3:
							if(cWon.dir==2){
								ans += cWon.power;
								list.remove(i);
								if(i<now){
									now--;
									reminer++;
								}
								b = false;
							}
							break;
						}
					}
				}
			}
		}
		if(!b){
			ans += won.power;
			list.remove(now);
			reminer++;
		}
		return b;
	}
	private static boolean moveDir(won w,int num) {
		int nx, ny;
		int dir = w.dir;
		boolean b = true;
		switch(dir){
		case 0:
			nx = w.x + dx[dir];
			ny = w.y + dy[dir];
			b = checkArea(nx,ny);
			if(b)
				list.set(num, new won(nx,ny,w.dir,w.power, cnt));
			else
				list.remove(num);
			break;
		case 1:
			nx = w.x + dx[dir];
			ny = w.y + dy[dir];
			b = checkArea(nx,ny);
			if(b)
				list.set(num, new won(nx,ny,w.dir,w.power, cnt));
			else
				list.remove(num);
			break;
		case 2:
			nx = w.x + dx[dir];
			ny = w.y + dy[dir];
			b = checkArea(nx,ny);
			if(b)
				list.set(num, new won(nx,ny,w.dir,w.power, cnt));
			else
				list.remove(num);
			break;
		case 3:
			nx = w.x + dx[dir];
			ny = w.y + dy[dir];
			b = checkArea(nx,ny);
			if(b)
				list.set(num, new won(nx,ny,w.dir,w.power, cnt));
			else
				list.remove(num);
			break;
		}

		return b;
	}
	private static boolean checkArea(int nx, int ny) {
		if(-1000 <= nx && nx <= 1000 && -1000 <= ny && ny <= 1000){
			return true;
		}
		return false;
	}


}
