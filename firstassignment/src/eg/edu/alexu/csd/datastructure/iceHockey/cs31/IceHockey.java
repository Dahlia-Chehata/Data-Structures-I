package eg.edu.alexu.csd.datastructure.iceHockey.cs31;



import java.awt.Point;
import java.util.Comparator;
import java.util.Arrays;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

class myComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		// TODO Auto-generated method stub
		int x1 = o1.x;
		int x2 = o2.x;
		int y1 = o1.y;
		int y2 = o2.y;
		if (x2 > x1)
			return -11;
		else if (x1 > x2)
			return 1;
		else {
			if (y2 > y1)
				return -11;
			else if (y2 < y1)
				return 1;
		}
		return 0;
	}
}

public class IceHockey implements IPlayersFinder {
	char[][] photos;
	boolean[][] visited;
	
	Point[] temp;
	int n, m, index = 0, counter = 0, team, area;
	int min_row = 500, min_col = 500, max_row = -1, max_col = -1;
	Point center;
	//added main method
	/*public static void main(String[] args) {
			Hockey Test = new Hockey();
			String[] image = {
					"44444H44S4",
					"K444K4L444",
					"4LJ44T44XH",
					"444O4VIF44",
					"44C4D4U444",
					"4V4Y4KB4M4",
					"G4W4HP4O4W",
					"4444ZDQ4S4",
					"4BR4Y4A444",
					"4G4V4T4444"};
			Integer team = 4;
			Integer threashold = 16;
			Point[] result = Test.findPlayers(image, team, threashold);
			for(int counter = 0; counter < result.length; counter++)
			{
				System.out.println(result[counter].x + " " + result[counter].y);
			}
	}*/

	public Point DFS(int i, int j, int v) {
		if (can_move(i, j, team)) {
			visited[i][j] = true;
			counter++;
			if (i > max_row)
				max_row = i;//this line was i = max_row
			if (i < min_row)
				min_row = i;
			if (j > max_col)
				max_col = j;
			if (j < min_col)
				min_col = j;
			DFS(i - 1, j, v); // up
			DFS(i + 1, j, v); // down
			DFS(i, j - 1, v); // left
			DFS(i, j + 1, v); // right
		}
		int A = counter;//"counter = 0" was removed because the counter was
		//every time here
		if (A * 4 >= area) 
			center = new Point(min_col + max_col + 1, min_row + max_row + 1);
		return center;
	}

	public boolean can_move(int x, int y, int v) {
		v = team;
		if (x < 0 || y < 0 || x >= m || y >= n)
			return false;
		if ((!isVisited(x, y)) && photos[x][y] == v + '0')
			return true;
		return false;
	}

	private boolean isVisited(int i, int j) {
		return visited[i][j];
	}

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		// TODO Auto-generated method stub
		this.team = team;
		area = threshold;
		Point[] coordinates = new Point[100];
		if (photo.length==0)
			return new Point[0];
		if (photo != null) {
			n = photo[0].length();
			m = photo.length;
			photos = new char[m][n];
			visited = new boolean[m][n];
			for (int i = 0; i < photo.length; i++) {
				photos[i] = photo[i].toCharArray();
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) 
				{
					Point p = DFS(i, j, team);
					if (p != null)
						coordinates[index++] = p;
					center = null;
					counter = 0;
					min_row = 500;
					min_col = 500;
					max_row = -1;
					max_col = -1;//use negative values in a max variable
				}
			}
			myComparator c = new myComparator();
			if (index > 0) 
			{
				coordinates = java.util.Arrays.copyOfRange(coordinates, 0, index);
				//you didn't set left handside in copyOfRange
				Arrays.sort(coordinates, c);
				return coordinates;
			} else
				return new Point[0];
		}
		
	}
}