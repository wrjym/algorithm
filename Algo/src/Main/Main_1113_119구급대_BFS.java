package Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 

public class Main_1113_119구급대_BFS {
	
	static class Point{
		int x,y,dirType,count;

		public Point(int x, int y, int dirType, int count) {
			this.x = x;
			this.y = y;
			this.dirType = dirType;
			this.count = count;
		}
	}
	
    static int N, M;
    static int dX, dY;
    static int[][] map;
    
    static int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
    static int minDrift=Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine().trim());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
         
        st=new StringTokenizer(br.readLine().trim());
        dX=Integer.parseInt(st.nextToken());
        dY=Integer.parseInt(st.nextToken());
         
        for(int i=0;i<N;i++){                 
            st=new StringTokenizer(br.readLine().trim());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                	map[i][j]=Integer.MAX_VALUE;
                }
            }
        }
         
        System.out.println(ambulance()); 
    }
     
    public static int ambulance() {
        map[0][0] = 0;
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(0,0,1,0));
        queue.offer(new Point(0,0,3,0));
        
        Point current = null;
        int min = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()) {
        	int newX, newY;
        	current = queue.poll();

        	if(current.x == dX && current.y == dY) {
        		min = Math.min(min, current.count);
        		continue;
        	}
        	
            for(int d=0;d<4;d++){
                newX=current.x+direction[d][0];
                newY=current.y+direction[d][1];
                 
                if(newX>=0 && newX<N && newY>=0 && newY<M && map[newX][newY] != 0){
                    if(current.dirType!=d){
                    	if(map[newX][newY]>=current.count+1) {
    	                	map[newX][newY]=current.count+1;
    	                	queue.offer(new Point(newX,newY,d,current.count+1));
                    	}
                    }else{

                        
                    	if(map[newX][newY]>=current.count) {
                    		map[newX][newY]=current.count;
                    		queue.offer(new Point(newX,newY,d,current.count));
                    	}
                    }
                }
            }
        }
     
    	return min;
    }
}
