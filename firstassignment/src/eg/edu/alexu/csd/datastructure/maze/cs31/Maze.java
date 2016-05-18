package eg.edu.alexu.csd.datastructure.maze.cs31;
import java.io.File;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
/**.
 * @author Dell
 */
public class Maze implements IMazeSolver  {
	/**.
	 * ;
	 */
	@Override
	public int[][] solveBFS(File maze) {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		readfile appl= new readfile();
		/**.
		 * ;
		 */
		char[][]input= appl.readFile(maze);
		/**.
		 * ;
		 */
		BfsSolver app=new BfsSolver();
		/**.
		*;
		 */
	int[][] arr=app.bfs(input,readfile.n,readfile.m);
		if (arr==null||arr.length==0)
				return null;
			//throw new RuntimeException();
		return arr;
		
	}
/**.
 * ;
 */
	@Override
	public int[][] solveDFS(File maze) {
		// TODO Auto-generated method stub
		/**.
		 * .
		 */
		readfile appl= new readfile();
		/**.
		 * .
		 */
		char[][]input= appl.readFile(maze);
		/**.
		 * .
		 */
		DfsSolver app=new DfsSolver();
		/**. 
		 * .
		 */
		int[][] arr=app.dfs(input,readfile.n,readfile.m);
		if (arr==null||arr.length==0)
				return null;
		return arr;
	}
	/**.
	 * ,
	 * @param args main
	 */
	public static void main(String[] args){
		/**.
		 * .
		 */
	Maze app=new Maze();
	/**.
	 * ;
	 */
	File s = 
	(new File("C:\\Users\\Dell"
			+ "\\Desktop\\mm.txt"));
	/**.
	 * .
	 */
	int[][]arr;
	arr=app.solveDFS(s);
	/**.
	 * .
	 */
	int[][]arr2;
	arr2=app.solveBFS(s);
	System.out.println("DFS:");	
	for(int i=0;i<arr.length;i++){
		for(int j=0;j<arr[0].length;j++){
			System.out.print(arr[i][j]);
			System.out.print(",");
		}
	System.out.print("/// ");
	}
	System.out.println();
	System.out.println("BFS:");	
for(int i=0;i<arr2.length;i++){
	for(int j=0;j<arr2[0].length;j++){
		System.out.print(arr2[i][j]);
		System.out.print(",");
	}
System.out.print("/// ");
}
}
}