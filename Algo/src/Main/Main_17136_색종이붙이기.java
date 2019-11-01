package Main;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main_17136_색종이붙이기 {
	static int [][]map;
	static int n;
	static int min;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/17136.txt"));
		Scanner sc = new Scanner(System.in);
		n = 10;
		map = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++)
				map[i][j] = sc.nextInt();
		}
		min = Integer.MAX_VALUE;
		dfs(0,0, 5,5,5,5,5,0);
		if(min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
		sc.close();
	}
	private static void dfs(int x, int y, int p5, int p4, int p3, int p2, int p1, int sum) {
		if(sum >= min)
			return;
		if(p5 < 0 || p4 < 0 || p3 < 0 || p2 < 0 || p1 < 0)
			return;
		if(x >= n){
			min = Math.min(min, sum);
			return;
		}
		if(map[x][y] != 1){
			if(y+1 < n)
				dfs(x,y+1,p5,p4,p3,p2,p1,sum);
			else
				dfs(x+1,0,p5,p4,p3,p2,p1,sum);
		}
		else{
			for(int a = 5; a>=1; a--){
				boolean b = true;
				for(int i=0; i<a; i++){
					for(int j=0; j<a; j++){
						if(0 <= x+i && x+i < n && 0 <= y+j && y+j < n){
							if(map[x+i][y+j] != 1)
								b = false;
						}
						else
							b = false;
					}
				}
				if(b){
					for(int i=0; i<a; i++){
						for(int j=0; j<a; j++)
							map[x+i][y+j] = 6;
					}
					switch(a){
					case 5:
						p5-=1;
						break;
					case 4:
						p4-=1;	
						break;
					case 3:
						p3-=1;
						break;
					case 2:
						p2-=1;
						break;
					case 1:
						p1-=1;
						break;
					}

					if(y+1 < n)
						dfs(x,y+1,p5,p4,p3,p2,p1,sum+1);
					else
						dfs(x+1,0,p5,p4,p3,p2,p1,sum+1);
					switch(a){
					case 5:
						p5+=1;
						break;
					case 4:
						p4+=1;	
						break;
					case 3:
						p3+=1;
						break;
					case 2:
						p2+=1;
						break;
					case 1:
						p1+=1;
						break;
					}
					for(int i=0; i<a; i++){
						for(int j=0; j<a; j++){
							map[x+i][y+j] = 1;
						}
					}
				}


			}


		}

	}

}
