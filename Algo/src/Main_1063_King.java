import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main_1063_King {

	static class KS{
		int x,y,num;

		public KS(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public String toString() {
			return "KS [x=" + x + ", y=" + y + ", num=" + num + "]";
		}

	}
	static ArrayList<KS> ks;
	static int [][]map;
	static int n,move;
	/*
	 * R : 한칸 오른쪽. 		 0 ,  1
	 * L : 한칸 왼쪽. 			 0 , -1
	 * B : 한칸 아래로.		 1 ,  0
	 * T : 한칸 위로.			-1 ,  0
	 * RT: 오른쪽 위 대각선		-1 ,  1
	 * LT: 왼쪽 위 대각선		-1 , -1
	 * RB: 오른쪽 아래 대각선	 1 ,  1
	 * LB: 왼쪽 아래 대각선		 1 , -1
	 */
	//R L B T RT LT RB LB
	//
	static int []dx = {0,  0, 1, -1, -1, -1, 1, 1};
	static int []dy = {1, -1, 0,  0,  1, -1, 1,-1};
	static HashMap<String, Integer> hm;
	static HashMap<String, Integer> moveText;
	static HashMap<Integer, String> hmre;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1063.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		setMap();
		String tmp = br.readLine();
		String []tmps = tmp.split(" ");

		String king = tmps[0];	//1
		String stone = tmps[1];		//2
		move = Integer.parseInt(tmps[2]);
		n = 9;
		map = new int[n][n];
		ks = new ArrayList<>();

		mapset(king,stone);
		vm();

		for(int i=0; i<move; i++){
			String m = br.readLine();
			int dir = moveText.get(m);
			for(int j=0; j<ks.size(); j++){
				int nx = ks.get(j).x + dx[dir];
				int ny = ks.get(j).y + dy[dir];

				map[ks.get(j).x][ks.get(j).y] = 0;
				if(1 <= nx && nx < n && 1 <= ny && ny < n){
					
					map[nx][ny] = ks.get(j).num;
					ks.set(j, new KS(nx, ny, ks.get(j).num));
				}
			}
			System.out.println(m);
			System.out.println(ks);
			vm();
		}
		for(int i=0; i<ks.size(); i++){
			String ans = hmre.get(ks.get(i).y);
			System.out.println(ans+(n-ks.get(i).x+""));
		}


	}
	private static void vm() {
		System.out.println();
		for(int i=1; i<n; i++){
			for(int j=1; j<n; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
	private static void mapset(String king, String stone) {
		int kx = n-Integer.parseInt(king.charAt(1)+"");
		int ky = hm.get(king.charAt(0)+"");
		int sx = n-Integer.parseInt(stone.charAt(1)+"");
		int sy = hm.get(stone.charAt(0)+"");

//		System.out.println(kx + " " + ky);
//		System.out.println(sx + " " + sy);

		map[kx][ky] = 1;
		map[sx][sy] = 2;
		ks.add(new KS(kx, ky, 1));
		ks.add(new KS(sx, sy, 2));

	}
	private static void setMap() {
		hm = new HashMap<>();
		moveText = new HashMap<>();
		hmre = new HashMap<>();
		hm.put("A", 1);
		hm.put("B", 2);
		hm.put("C", 3);
		hm.put("D", 4);
		hm.put("E", 5);
		hm.put("F", 6);
		hm.put("G", 7);
		hm.put("H", 8);
		hmre.put(1, "A");
		hmre.put(2, "B");
		hmre.put(3, "C");
		hmre.put(4, "D");
		hmre.put(5, "E");
		hmre.put(6, "F");
		hmre.put(7, "G");
		hmre.put(8, "H");
		moveText.put("R", 0);
		moveText.put("L", 1);
		moveText.put("B", 2);
		moveText.put("T", 3);
		moveText.put("RT", 4);
		moveText.put("LT", 5);
		moveText.put("RB", 6);
		moveText.put("LB", 7);

	}

}
