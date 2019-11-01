package D4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_5656_벽돌깨기 {
	public static int w,h,n;
	public static int dx[] = {0,-1,0,1};
	public static int dy[] = {-1,0,1,0};
	public static int []data;
	public static int [][]map;
	public static int [][]tmp;
	public static int cnt;
	public static int min;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/5656.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			w = sc.nextInt();
			h = sc.nextInt();
			data = new int[n];
			map = new int[h][w];
			tmp = new int[h][w];
			for(int i=0; i<h; i++){
				for(int j=0; j<w; j++){
					map[i][j] = sc.nextInt();
				}
			}
			min = Integer.MAX_VALUE;
			per(0);
			System.out.println("#" + tc  + " " + min);

		}
	}
	public static void per(int count) {
		if(count==n) {
			int ccnt=0;
			for(int i=0; i<h; i++){
				for(int j=0; j<w; j++){
					tmp[i][j] = map[i][j];
				}
			}
			for(int k=0; k<n; k++){
				for(int i=0; i<h; i++){
					if(tmp[i][data[k]] != 0){
						bom(i,data[k],tmp[i][data[k]]);
						break;
					}
				}
				fullMap();
			}
			for(int i=0; i<h; i++){
				for(int j=0; j<w; j++){
					if(tmp[i][j] > 0){
						ccnt++;
					}
				}
			}
			min = Math.min(min, ccnt);
			
			return;
		}
		for(int i=0;i<w;i++) {
			data[count]=i;
			per(count+1);
		}

	}
	private static void fullMap() {
		for(int i=0; i<w; i++){
			int t[] = new int[h];
			int cnt=h-1;
			
			for(int j=h-1; j>=0; j--){
				if(tmp[j][i] != 0){
					t[cnt--] = tmp[j][i];
				}
			}
			for(int j=h-1; j>=0; j--){
				tmp[j][i] = t[j];
			}
		}		
	}
	private static void bom(int x, int y, int num) {
		tmp[x][y]=0;
		for(int i=0; i<4; i++){
			int nx = x;
			int ny = y;
			for(int k=1; k<num; k++){
				nx = nx + dx[i];
				ny = ny + dy[i];
				if(0 <= nx && nx < h && 0 <= ny && ny < w){
					if(tmp[nx][ny]!=0){
						if(tmp[nx][ny] > 1){
							bom(nx,ny,tmp[nx][ny]);
						}
						tmp[nx][ny] = 0;
					}
				}
			}
		}
	}
}
















