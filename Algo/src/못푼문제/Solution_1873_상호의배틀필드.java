package 못푼문제;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1873_상호의배틀필드{
	public static char[][] map;
	public static int[] dx = {-1, 0 , 1 , 0};
	public static int[] dy = {0, -1, 0, 1};
	public static int nx=0, ny=0;
	public static int dir = 0;
	public static int n,m;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1873.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for(int tc=1; tc<=T; tc++){
			n = Integer.parseInt(sc.next());
			m = Integer.parseInt(sc.next());

			sc.nextLine();
			map = new char[n][m];
			for(int i=0; i<n; i++){
				String a = sc.nextLine();
				for(int j=0; j<m; j++){
					map[i][j] = a.charAt(j);
					if(a.charAt(j) == '<'){
						dir = 1;
						nx = i;
						ny = j;
					}
					else if(a.charAt(j)=='^'){
						dir = 2;
						nx = i;
						ny = j;
					}
					else if(a.charAt(j) == '>'){
						dir = 3;
						nx = i;
						ny = j;
					}
					else if(a.charAt(j) == 'v'){
						dir = 4;
						nx = i;
						ny = j;
					}
				}
			}
			for (char b[] : map) {System.out.println(Arrays.toString(b));}
			int move =  Integer.parseInt(sc.nextLine());
			String a = sc.nextLine();
			for(int i=0; i<move; i++){
				char mm = a.charAt(i);
				switch(mm){
				case 'L':{
					dir = 1;
					movefunction();
					break;
				}
				case 'U':{
					dir = 2;
					movefunction();
					break;
				}
				case 'R':{
					dir = 3;
					movefunction();
					break;
				}
				case 'D':{
					dir = 4;
					movefunction();
					break;
				}
				case 'S':{
					shoot();
				}
				}
			}
			for (char b[] : map) {System.out.println(Arrays.toString(b));}
		}
		sc.close();

	}
	private static void shoot() {
		int ndx = nx + dir;
		int ndy = ny + dir;

		if(0 <= ndx && ndx < m && 0 <= ndy && ndy < n ){
			if(map[ndx][ndy] == '#' || map[ndx][ndy]=='-'){
				return ;
			}
			else if(map[ndx][ndy] == '*'){
				map[ndx][ndy] = '.';
			}
			else if(map[ndx][ndy] == '.'){
				while(true){
					System.out.println("while");
					ndx = dx[ndx + dir];
					ndy = dy[ndy + dir];
					if(0 <= ndx && ndx < m && 0 <= ndy && ndy < n ){
						System.out.println(map[ndx][ndy]);
						if(map[ndx][ndy] == '#'){
							break;
						}
						else if(map[ndx][ndy] == '-'){
							break;
						}
						else if(map[ndx][ndy] == '*'){
							map[ndx][ndy] = '.';
							break;
						}
					}
					else{
						break;
					}
				}
			}


		}

	}
	private static void movefunction() {
		map[nx][ny] = '.';
		nx = nx + dir;
		ny = ny + dir;
		if(0 <= nx && nx < n && 0 <= ny && ny < m){
			
		}
		
		
	}
}

