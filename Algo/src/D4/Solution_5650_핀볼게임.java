package D4;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

class warmhole{
	public int x;
	public int y;
	public int val;
	public warmhole(int x, int y, int val) {
		super();
		this.x = x;
		this.y = y;
		this.val = val;
	}
	@Override
	public String toString() {
		return "warmhole [x=" + x + ", y=" + y + ", val=" + val + "]";
	}
}
public class Solution_5650_핀볼게임 {
	public static int max;
	public static int [][]map;
	public static ArrayList<warmhole> warm;
	public static int n;
	public static int endX, endY;
	public static boolean endpoint;
	public static int dx[] = {0,-1,0,1};
	public static int dy[] = {-1,0,1,0};
	public static int x,y,direction,score;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/5650.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			max = Integer.MIN_VALUE;
			map = new int[n][n];
			warm = new ArrayList<>();
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					map[i][j] = sc.nextInt();
					if(map[i][j] > 5){
						warm.add(new warmhole(i,j,map[i][j]));
					}
				}
			}

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(map[i][j] == 0){
						for(int dir=0; dir<4; dir++){
							score = 0;
							direction = dir;
							endX = i;
							endY = j;
							endpoint = false;
							//							System.out.println(i+dx[dir] + " " + (j+dy[dir]));
							x = i + dx[direction];
							y = j + dy[direction];
							while(true){
								if(endpoint || (endX == x && endY == y)){
									max = Math.max(max, score);
									endpoint=true;
//									System.out.println("endX : " + i + " endY : " + j + "  dir : " + dir + " max : " + max);
									break;
								}
								if(0 <= x && x < n && 0 <= y && y < n){
									doAction(map[x][y]);
								}
								else{
									switch(direction){
									case 0:
										direction = 2; break;
									case 1:
										direction = 3; break;
									case 2:
										direction = 0; break;
									case 3:
										direction = 1; break;
									}
									x += dx[direction];	y += dy[direction];	score += 1;
								}

							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
	private static void doAction(int mapVal) {
		switch(mapVal){
		case 0:
			x += dx[direction]; y += dy[direction]; break;
		case 1: 
			switch(direction){
			case 1:
				direction = 3;	score += 1;	break;
			case 2:
				direction = 0; score += 1; break;
			case 3:
				direction = 2; score += 1; break;
			case 0:
				direction = 1; score += 1; break;
			}
			x += dx[direction]; y += dy[direction]; break;
		case 2:
			switch(direction){
			case 1:
				direction = 2; score += 1; break;
			case 2:
				direction = 0; score += 1; break;
			case 3:
				direction = 1; score += 1; break;
			case 0:
				direction = 3; score += 1; break;
			}
			x += dx[direction]; y += dy[direction]; break;
		case 3:
			switch(direction){
			case 1:
				direction = 0; score += 1; break;
			case 2:
				direction = 3; score += 1; break;
			case 3:
				direction = 1; score += 1; break;
			case 0:
				direction = 2; score += 1; break;
			}
			x += dx[direction]; y += dy[direction]; break;
		case 4:
			switch(direction){
			case 1:
				direction = 3; score += 1; break;
			case 2:
				direction = 1; score += 1; break;
			case 3:
				direction = 0; score += 1; break;
			case 0:
				direction = 2; score += 1; break;
			}
			x += dx[direction]; y += dy[direction]; break;
		case 5:
			switch(direction){
			case 0:
				direction = 2; score += 1; break;
			case 1:
				direction = 3; score += 1; break;
			case 2:
				direction = 0; score += 1; break;
			case 3:
				direction = 1; score += 1; break;
			}
			x += dx[direction]; y += dy[direction]; break;
		case -1:
			endpoint=true;
			break;
		case 6: case 7: case 8: case 9: case 10:
			for(int i=0; i<warm.size(); i++){
				if(warm.get(i).val == mapVal){
					if(!(x==warm.get(i).x && y == warm.get(i).y)){
						x = warm.get(i).x+dx[direction]; 
						y = warm.get(i).y+dy[direction]; 
						break;
						//						startGame(warm.get(i).x+dx[dir],warm.get(i).y+dy[dir],dir,score);
					}
				}
			}
			break;
		}
	}
}
