package eg.edu.alexu.csd.datastructure.iceHockey.cs31;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
import java.awt.Point;
import java.util.Comparator;
import java.util.Arrays;
 class myComparator implements Comparator <Point>{
	 
	@Override
	public int compare(Point o1, Point o2) {
		// TODO Auto-generated method stub
		  int x1=o1.x;
		  int x2=o2.x;
		  int y1=o1.y;
		  int y2=o2.y;
	
	 if (x2>x1)
		 return 1;
	 else if (x1>x2)
		 return-1;
	 else
	 {
		 if (y2>y1)
			 return 1;
		 else 
			 return -1;
	 }
	
	

 }
 }
 public class IceHockey implements IPlayersFinder {
 
 char[][] photos ;
 boolean [][]visited;
 Point[] coordinates;
 
 int n,m,index=0,counter=0,team,area;
 int min_row = 50 , min_col=50, max_row=0, max_col=50; 
 Point center;
 
 
 
 
 public Point DFS(int i, int j, int v){
	   
	 v=team;
		if (can_move (i,j, team)){
			visited[i][j] = true;
			 counter++;
			 
			 if (i>max_row)
				 i=max_row;
			 if (i<min_row)
				 min_row=i;
			 if(j>max_col)
				 max_col=j;
			 if(j<min_col)
				 min_col=j;
			 
			DFS(i-1,j, v); // up
			DFS(i+1,j, v); // down
			DFS(i,j-1, v); // left
			DFS(i,j+1, v); // right
		}
		 int A=counter;
		 counter=0;
		
		if (A*4>=area){
			center=new Point(min_col+max_col+1,min_row+max_row+1);
		 
         
}	 
		else
			center=null;
		min_row = 50 ;
        min_col=50;
        max_row=0;
        max_col=50;
	
        return center;
			 
	}
 public boolean can_move (int x,int y,int v ){
	 v=team;
	 if (x<0 || y<0 || x>=m || y>=n) 
		 return false;
		if ((!isVisited(x,y)) && photos[x][y]==v)
			return true;
		return false;
 }
 
 private boolean isVisited(int i, int j) {
		return visited[i][j];
	}
 
	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		// TODO Auto-generated method stub
		this.team=team;
		area=threshold;
		if (photo !=null){
		n=photo[0].length();
		m=photo.length;
		
		photos=new char[m][n];
		visited=new boolean[m][n];
      
		for (int i=0;i<photo.length;i++){
			photos[i]=photo[i].toCharArray();	
		}
		
		for (int i=0;i<m;i++){
	    	   for (int j=0;j<n;j++){
	    		   if (DFS(i,j,team)!=null)
		     coordinates[index++]=new Point (DFS(i,j,team));
		          
	    	   }
		}
		myComparator c =new myComparator();
		
		
		
		Arrays.sort(coordinates, c);
		return coordinates;
		}
		return null;
		
		
		}
		
 }
 
 


 

	
 
 
