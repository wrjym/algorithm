package Main;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_톱니바퀴 {
	public static int [][]tb;
	public static int [][]change;
	public static int [][]ctb;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1.txt"));
		Scanner sc = new Scanner(System.in);
		tb = new int[5][8];
		for(int i=1; i<=4; i++){
			String a = sc.nextLine();
			for(int j=0; j<8; j++){
				tb[i][j] = Integer.parseInt(a.charAt(j)+"");
			}
		}
		int k = sc.nextInt();
		change = new int[k][2];
		for(int i=0; i<k; i++){
			change[i][0] = sc.nextInt();
			change[i][1] = sc.nextInt();
		}

		//////////시작////////////
		for(int i=0; i<k; i++){
			//			view();
			//			move(change[i][0], change[i][1]);
			//			view();
			find(change[i][0], change[i][1]);
		}
//		view();
		int ans = 0;
		for(int i=1; i<5; i++){
			if(tb[i][0]==1){
				switch(i){
				case 1:
					ans+=1;
					break;
				case 2:
					ans += 2;
					break;
				case 3:
					ans += 4;
					break;
				case 4:
					ans += 8;
					break;
				}
			}
		}
		System.out.println(ans);
	}
	private static void find(int n, int dir) {
		ctb = new int[5][2];
		if(n!=1){
			left(n,dir);
		}
		if(n!=4){
			right(n,dir);
		}

		//		for(int []a : ctb) System.out.println(Arrays.toString(a));

		for(int i=1; i<ctb.length; i++){
			if(ctb[i][0]==1){
				//				System.out.println("-------------------------------");
				//				view();
				move(i,ctb[i][1]);
				//				view();
				//				System.out.println("-------------------------------");
			}
		}


	}

	private static void left(int n, int dir) {
		int tmpDir = dir;
		ctb[n][0] = 1;
		ctb[n][1] = dir;
		for(int i=n; i>1; i--){
			int l = tb[i][6];
			int r = tb[i-1][2];
			//			System.out.println("tb["+i+"][6] "+l + " : tb["+(i-1)+"][2] "+ r);
			if(l==r){
				return ;
			}
			else {
				if(tmpDir==1){
					tmpDir = -1;
				}
				else{
					tmpDir = 1;
				}
				ctb[i-1][0] = 1;
				ctb[i-1][1] = tmpDir;
			}
		}
	}
	private static void right(int n, int dir) {
		int tmpDir = dir;
		ctb[n][0] = 1;
		ctb[n][1] = dir;
		for(int i=n; i<4; i++){
			int l = tb[i][2];
			int r = tb[i+1][6];
			//			System.out.println("tb["+i+"][2] "+l + " : tb["+(i+1)+"][6] "+ r);
			if(l==r){
				return ;
			}
			else {
				if(tmpDir==1){
					tmpDir = -1;
				}
				else{
					tmpDir = 1;
				}
				ctb[i+1][0] = 1;
				ctb[i+1][1] = tmpDir;
			}
		}
	}

	private static void view() {
		System.out.println("-v-i-e-w");
		for(int i=1; i<=4; i++){
			for(int j=0; j<8; j++){
				System.out.print(tb[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void move(int n, int dir) {
		int tmp;
		switch(dir){
		case 1:
			tmp = tb[n][7];
			for(int i=7; i>0; i--){
				tb[n][i] = tb[n][i-1];
			}
			tb[n][0] = tmp;
			break;

		case -1:
			tmp = tb[n][0];
			for(int i=0; i<7; i++){
				tb[n][i] = tb[n][i+1];
			}
			tb[n][7] = tmp;
			break;
		}
	}

}
