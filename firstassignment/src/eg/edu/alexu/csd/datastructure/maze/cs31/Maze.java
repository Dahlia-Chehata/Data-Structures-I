package eg.edu.alexu.csd.datastructure.maze.cs31;
import  eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.stack.cs31.Stack;
import eg.edu.alexu.csd.datastructure.queue.cs31.Queue;

import java.io.File;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Maze implements IMazeSolver  {
	String[] arr1;
		char[][] arr2;
		String str;
		int n,m;
		char[] dim;
	//.......//
		Point source ;
	 boolean[][] visit;
	  Point[] result;
	  int[][]sol;
	private Point[][] parent;
	//char[][] filearray;
	//..........//
	
	/**
	 * readfile
	 * @param maze
	 * @return
	 */
	public char[][] readfile(File maze){
		
		
		if (maze.length() == 0) {
		    throw new RuntimeException();
		} 
		try{
		FileReader fr=new FileReader(maze);
		BufferedReader textReader=new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
	    String line = textReader.readLine();
	    String dimensions=line;
	    dim=dimensions.toCharArray();
	   // String[] splited = dimensions.split("\\s+");
	    n=Character.getNumericValue(dim[0]);
	     m=Character.getNumericValue(dim[1]);
	   // arr1=new String[m];
	    arr2=new char[n][m];
	    while (line!= null) {
	    	line = textReader.readLine();
	    	sb.append(line);
	    	//sb.append(" ");

	    	sb.append("\n");
	        
	    }
	    str = sb.toString();
	    textReader.close( );
		}catch(IOException e){
			System.out.println("not found");
		};
		arr1=str.split("\n");
		 for (int i=0; i<n; i++) {
		    arr2[i] = arr1[i].toCharArray();
		    }
		/* for (int i=0;i<n;i++){
			 for (int j=0;j<m;j++){
				 System.out.print(arr2[i][j]);
			 }
			 System.out.println(); 
		 }*/
		 return arr2;
	}
	@Override
	public int[][] solveBFS(File maze)  {
		// TODO Auto-generated method stub
		char[][]input= readfile(maze);
		Queue queue=new Queue();
		return null;
	}
	
	
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
		for( i=0;i<ans.length;i++){
			for( j=0;j<2;j++){
			System.out.print(ans[i][j]);	}
			System.out.println();
		}
		return ans;
	}
	@Override
	public int[][] solveDFS(File maze) {
		// TODO Auto-generated method stub
		boolean flag=false;
		char[][]input= readfile(maze);
		Stack stack=new Stack();
		visit=new boolean[n][m];
		parent = new Point[n][m];
		result = new Point[n * m];
		//filearray=input;

		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        if (input[i][j]=='S')
		        	source=new Point(i,j);
		        flag=true;
		        break;
		           
		    }
		    if(flag)
		    	break;
		}
		
		stack.push(source);
		while (!stack.isEmpty()) {
			Point top = (Point) stack.pop();
			if (input[top.x][top.y] == 'E') {
				sol = finalPath(parent, top);
				return sol;
				/*for(int i=0;i<parent.length;i++)
					for(int j=0;j<parent[0].length;j++)
						System.out.println(parent[i][j]);*/

			} else if ((input[top.x][top.y] == '#') || (visit[top.x][top.y])) {
				continue;
			} else {
				visit[top.x][top.y] = true;
				if ((top.y + 1 < input[0].length) && (!visit[top.x][top.y + 1])) {
					Point h = new Point(top.x, top.y + 1);
					stack.push(h);
					parent[top.x][top.y + 1] = new Point(top.x, top.y);
				}
				if ((top.x + 1 < input.length) && (!visit[top.x + 1][top.y])) {
					Point h = new Point(top.x + 1, top.y);
					stack.push(h);
					parent[top.x + 1][top.y] = new Point(top.x, top.y);
				}
				if ((top.y - 1 >= 0) && (!visit[top.x][top.y - 1])) {
					Point h = new Point(top.x, top.y - 1);
					stack.push(h);
					parent[top.x][top.y - 1] = new Point(top.x, top.y);
				}
				if ((top.x - 1 >= 0) && (!visit[top.x - 1][top.y])) {
					Point h = new Point(top.x - 1, top.y);
					stack.push(h);
					parent[top.x - 1][top.y] = new Point(top.x, top.y);
				}
			}
		}
		return null;
		
	}
	/*public static void main(String[] args){
		Maze app=new Maze();
		File s = (new File("C:\\Users\\Dell\\Desktop\\mm.txt"));
		int[][]arr;
		arr=app.solveDFS(s);
				
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr[0].length;j++)
				System.out.print(arr[i][j]);

	}*/
}