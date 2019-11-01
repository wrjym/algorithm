package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main_16235_나무재테크 {
	static class Tree{
		int x,y,treeAge;
		boolean life;
		public Tree(int x, int y, int treeAge, boolean life){
			this.x = x;
			this.y = y;
			this.treeAge = treeAge;
			this.life = life;
		}
		@Override
		public String toString(){
			return "[ {" + x + "," + y + "} treeAge :" + treeAge + " " + life + "]";
		}
	}

	static int n,m,k,year;
	static int [][]양분, map;
	static int []dx = {-1,-1,-1,0,0,1,1,1};
	static int []dy = {-1,0,1,-1,1,-1,0,1};
	static Queue<Tree> q;
	static ArrayList<Tree> tree;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/16235.txt"));
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();

		양분 = new int[n+1][n+1];
		map = new int[n+1][n+1];
		q = new LinkedList<>();
		tree = new ArrayList<>();
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				양분[i][j] = sc.nextInt();
				map[i][j] = 5;
			}
		}
		for(int i=0; i<m; i++)
			tree.add(new Tree(sc.nextInt(), sc.nextInt(), sc.nextInt(), true));
		compareFunction();	// 정렬하는 함수.
		for(int i=0; i<m; i++)
			q.offer(tree.get(i));
		for(year=1; year<=k; year++){
			봄();
			여름();
			가을();
			겨울();
		}
		System.out.println(q.size());
		sc.close();
	}

	private static void 봄() {
		/*
		 * 전체 queue에 있는 나무들 양분 먹이고 생존여부 확인.
		 * size = queue의 사이즈만큼 돌린다.
		 * 결국 queue 자기 자신 한번 돈다.
		 */
		int size = q.size();
		for(int i=0; i<size; i++){
			Tree t = q.poll();
			if(map[t.x][t.y] >= t.treeAge){	//양분을 먹을 수 있을때. 생존.
				map[t.x][t.y] -= t.treeAge;
				q.offer(new Tree(t.x, t.y, t.treeAge+1, true));
			}
			else							//양분 먹을 수 없을때 죽음.(여름에서 양분을 주기 위해서 바로 지우지 않고 죽음만 처리해둠)
				q.offer(new Tree(t.x,t.y,t.treeAge, false));
		}
	}
	private static void 여름(){		//죽은애들을 양분처리.
		int size = q.size();
		for(int i=0; i<size; i++){
			Tree t = q.poll();
			if(!t.life)
				map[t.x][t.y] = map[t.x][t.y] + (t.treeAge/2);
			else
				q.offer(new Tree(t.x, t.y, t.treeAge, t.life));		//죽지 않았을경우 바로 큐에 다시 넣기.
		}
	}
	private static void 가을() {
		/*
		 * queue 사이즈만큼 쭉 돌면서 8방향 탐색을 한다.
		 * 확산이 되는 애들은 바로 queue에 넣고
		 * 원래 있는 값들은 ArrayList에 넣는다.
		 * 확산이 끝나고 queue뒤에다 원래 있는 값들을 넣어준다.
		 * 이렇게 되면 정렬할 필요가 없음.
		 */
		int size = q.size();
		ArrayList<Tree> adds = new ArrayList<>();
		for(int i=0; i<size; i++){
			Tree t = q.poll();
			adds.add(new Tree(t.x, t.y, t.treeAge, t.life));
			if(t.treeAge%5 == 0){
				for(int dir=0; dir<8; dir++){
					int nx = t.x + dx[dir];
					int ny = t.y + dy[dir];
					if(0 < nx && nx <= n && 0 < ny && ny <= n){
						q.offer(new Tree(nx, ny, 1, true));
					}
				}
			}
		}
		for(int i=0; i<adds.size(); i++)
			q.offer(adds.get(i));
	}
	private static void 겨울() {
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++)
				map[i][j] += 양분[i][j];
		}
	}
	private static void compareFunction(){
		Collections.sort(tree, new Comparator<Tree>() {
			@Override
			public int compare(Tree o1, Tree o2){
				if(o1.treeAge > o2.treeAge)
					return -1;
				else if(o1.treeAge < o2.treeAge)
					return 1;
				else
					return 0;
			}
		});
	}
}
