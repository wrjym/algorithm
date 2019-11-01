package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_미세먼지 {

	public static int R,C,T;
	public static int []updown;
	public static int [][]map;
	public static int [][]tmpMap;
	public static int []upx = {0,-1,0,1};
	public static int []upy = {1,0,-1,0};
	public static int []downx = {0,1,0,-1};
	public static int []downy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1.txt"));
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		map = new int[R][C];
		updown = new int[2];
		int tmp = 0;
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1){
					updown[tmp] = i;
					tmp++;
				}
			}
		}

		for(int time = 0; time<T; time++){
			dif();
			windUp(updown[0],0,0,0);
			windDown(updown[1],0,0,0);
		}
		
		int ans = 0;
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				ans += map[i][j];
			}
		}
		ans += 2;
		System.out.println(ans);

	}
	private static void windDown(int x, int y, int dir, int val) {
		int nx = x;
		int ny = y;
		while(true){
			nx = nx + downx[dir];
			ny = ny + downy[dir];
			if(updown[1]<= nx && nx < R && 0 <= ny && ny < C){
				int tmp = map[nx][ny];
				map[nx][ny] = val;
				val = tmp;
			}
			else{
				nx = nx - downx[dir];
				ny = ny - downy[dir];
				dir += 1;
			}
			
			if(dir==4){
				break;
			}
		}
		map[updown[1]][0] = -1;
	}
	private static void windUp(int x,int y, int dir, int val) {
		int nx = x;
		int ny = y;
		while(true){
			nx = nx + upx[dir];
			ny = ny + upy[dir];
			if(0<= nx && nx <= updown[0] && 0 <= ny && ny < C){
				int tmp = map[nx][ny];
				map[nx][ny] = val;
				val = tmp;
			}
			else{
				nx = nx - upx[dir];
				ny = ny - upy[dir];
				dir += 1;
			}
			if(dir==4){
				break;
			}
		}
		map[updown[0]][0] = -1;
	}
	private static void dif() {
		tmpMap = new int[R][C];
		int []dx = {0,-1,0,1};
		int []dy = {-1,0,1,0};
		tmpMap[updown[0]][0] = tmpMap[updown[1]][0] = -1;
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				if(map[i][j] > 0){
					int tmp=0;
					for(int dir=0; dir<4; dir++){
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						if(0 <= nx && nx < R && 0 <= ny && ny < C){
							if(map[nx][ny]!=-1){
								tmp++;
								tmpMap[nx][ny] += map[i][j]/5;
							}
						}

					}
					tmpMap[i][j] += map[i][j] - ((map[i][j]/5) * tmp);
				}
			}
		}

		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				map[i][j] = tmpMap[i][j];
			}
		}


	}
	private static void view() {
		System.out.println("--------------------------view---------------------");
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println( );
		}
		System.out.println();
	}
}



