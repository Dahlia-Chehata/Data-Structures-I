package eg.edu.alexu.csd.datastructure.maze.cs31;
import eg.edu.alexu.csd.datastructure.queue.cs31.Queue;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
public class BfsSolver {
	Point source ;
	 boolean[][] visit;
	  Point[] result;
	  int[][]sol;
	private Point[][] parent;
	//char[][] filearray;
	
	public int[][] finalPath(Point[][] arr, Point e) {
		int i = 0;
		int j = 0;
		//point e is the indices of the target
		result[i] = new Point(e);
		for (i = 1; !arr[result[i - 1].x][result[i - 1].y].equals(source); i++) {
			result[i] = new Point(arr[result[i - 1].x][result[i - 1].y]);
		//	filearray[result[i].x][result[i].y] = '*'; 

		}
		result[i] = new Point(source);
		i++;
		Point[] finalResult = new Point[i];
		int[][]ans=new int[i][2];
		
		for (i = i - 1; i >= 0; i--) {
			finalResult[j] = new Point(result[i]);
			j++;
		}
		/*for( i=0;i<finalResult.length;i++){
			System.out.print(finalResult[i]);	
		}*/
		//ans=new int[finalResult.length][2];
		for(int k=0;k<finalResult.length;k++){
			ans[k][0]=finalResult[k].x;
			ans[k][1]=finalResult[k].y;
		}
		/*for( i=0;i<ans.length;i++){
			for( j=0;j<2;j++){
			System.out.print(ans[i][j]);	}
			System.out.println();
		}*/
		return ans;
	}
	public int[][]bfs(char[][]input,int n,int m)
			throws RuntimeException{
		Queue q =new Queue();
		boolean flag=false;
		visit=new boolean[n][m];
		parent = new Point[n][m];
		result = new Point[n * m];
		//filearray=input;

		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		    	if (flag==true && input[i][j]=='S')
		    		throw new RuntimeException();
		        if (input[i][j]=='S'){
		        	source=new Point(i,j);
		        flag=true;
		           
		    }
		   }
		}
		if (!flag)
			throw new RuntimeException();
		
		boolean stop=false;
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		    	if (stop==true && input[i][j]=='E')
		    		throw new RuntimeException();
		        if (input[i][j]=='E'){
		        stop=true;
		           
		    }
		   }
		}
		if (!stop)
			throw new RuntimeException();
		
		
		
		q.enqueue(source);
		while(!q.isEmpty()){
			Point top = (Point)q.dequeue();
			if (input[top.x][top.y] == 'E'){
				if (parent==null)
					throw new RuntimeException();
				sol = finalPath(parent, top);
				return sol;
			}
			else if ((input[top.x][top.y] == '#') || (visit[top.x][top.y])){
				continue;
			}
			else {
				visit[top.x][top.y] = true;
				if ((top.y + 1 < input[0].length) && (!visit[top.x][top.y + 1])){
					Point h = new Point(top.x, top.y + 1);
					q.enqueue(h);
					parent[top.x][top.y + 1] = new Point(top.x, top.y);
				}
				if ((top.x + 1 < input.length) && (!visit[top.x + 1][top.y])){
					Point h = new Point(top.x + 1, top.y);
					q.enqueue(h);
					parent[top.x + 1][top.y] = new Point(top.x, top.y);
				}
				if ((top.y - 1 >= 0) && (!visit[top.x][top.y - 1])){
					Point h = new Point(top.x, top.y - 1);
					q.enqueue(h);
					parent[top.x][top.y - 1] = new Point(top.x, top.y);
				}
				if ((top.x - 1 >= 0) && (!visit[top.x - 1][top.y])){
					Point h = new Point(top.x - 1, top.y);
					q.enqueue(h);
					parent[top.x - 1][top.y] = new Point(top.x, top.y);
				}
			}
		}
		//throw new RuntimeException("ll");
		return null;
	}
	
}
