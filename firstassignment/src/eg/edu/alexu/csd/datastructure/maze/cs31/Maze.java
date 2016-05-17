package eg.edu.alexu.csd.datastructure.maze.cs31;
import java.io.File;
import  eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.maze.cs31.BfsSolver;
import eg.edu.alexu.csd.datastructure.maze.cs31.DfsSolver;
import eg.edu.alexu.csd.datastructure.maze.cs31.readfile;



public class Maze implements IMazeSolver  {
	
	@Override
	public int[][] solveBFS(File maze) {
		// TODO Auto-generated method stub
		readfile appl= new readfile();
		char[][]input= appl.readFile(maze);
		BfsSolver app=new BfsSolver();
		int[][] arr=app.bfs(input,readfile.n,readfile.m);
		if (arr.length==0||arr==null)
				throw new RuntimeException();
		return arr;
		
	}



	@Override
	public int[][] solveDFS(File maze) {
		
		
		// TODO Auto-generated method stub
		readfile appl= new readfile();
		char[][]input= appl.readFile(maze);
		throw new RuntimeException( "input");
	/*	DfsSolver app=new DfsSolver();
		int[][] arr=app.dfs(input,readfile.n,readfile.m);
		if (arr.length==0)
				throw new RuntimeException();
		return arr;*/
		
	}
	/*public static void main(String[] args){
	Maze app=new Maze();
	File s = (new File("C:\\Users\\Dell\\Desktop\\mm.txt"));
	int[][]arr;
	arr=app.solveDFS(s);
			
	for(int i=0;i<arr.length;i++){
		for(int j=0;j<arr[0].length;j++){
			System.out.print(arr[i][j]);
		}
	System.out.println();
	}

}*/

}
