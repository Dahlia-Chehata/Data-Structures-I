package eg.edu.alexu.csd.datastructure.iceHockey.cs31;
import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
import java.util.Arrays;
import java.util.Comparator;
import java.awt.Point;


class myCOMP implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		// TODO Auto-generated method stub
		 if (o2.x > o1.x) {
			return -1;    
		 } else if (o1.x > o2.x) {
			return 1;              
		 } else {
			if (o2.y > o1.y) {
				return -1;
			} else if (o2.y <o1.y) {
				return 1;
			}
		}
		return 0;
	}
}
		

public class IceHockey implements IPlayersFinder {
	char[][] photos;
	boolean[][] visited;
	Point[] temp;
	int n, m, index = 0, counter = 0, team, area;
	int minRow = 500, minCol = 500, maxRow = -1, maxCol = -1;
	Point center;

	public Point dfs(int i, int j, int v) {
		if (can_move(i, j, team)) {
			visited[i][j] = true;
			counter++;
			if (i > maxRow) {
				maxRow = i;
			}
			if (i < minRow) {
				minRow = i;
			}
			if (j > maxCol) {
				maxCol = j;
			}
			if (j < minCol){
				minCol = j;
			}
			dfs(i - 1, j, v); // up
			dfs(i + 1, j, v); // down
			dfs(i, j - 1, v); // left
			dfs(i, j + 1, v); // right
		}
		int AA = counter;
		if (AA * 4 >= area) {
			int xx = minCol + maxCol + 1;
			int yy = minRow + maxRow + 1;
			center = new Point(xx,yy);
		}
		return center;
	}

	public boolean can_move(int xx, int yy, int vv) {
		vv = team;
		if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
			return false;
		}
		if ((!isVisited(xx, yy)) && photos[xx][yy] == vv + '0') {
			return true;
		}
		return false;
	}

	private boolean isVisited(int i, int j) {
		return visited[i][j];
	}

	@Override
	public Point[] findPlayers(String[]photo,int team,int threshold) {
		// TODO Auto-generated method stub
		this.team = team;
		area = threshold;
		Point[] coor = new Point[100];
		
		if (photo.length == 0) {
			return new Point[0];
		}
		if (photo != null) {
			n = photo[0].length();
			m = photo.length;
			photos = new char[m][n];
			visited = new boolean[m][n];

			for (int i = 0; i < photo.length; i++) {
				photos[i] = photo[i].toCharArray();
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					Point p = dfs(i, j, team);
					if (p != null) {
						coor[index++] = p;
					}
					center = null;
					counter = 0;
					minRow = 500;
					minCol = 500;
					maxRow = -1;
					maxCol = -1;
				}
			}
			myCOMP c = new myCOMP();
			if (index > 0) {
				coor = Arrays.copyOfRange(coor, 0, index);
				Arrays.sort(coor, 0, index, c);
				index = 0;
				return coor;
			} else {
				index = 0;
				return new Point[0];
			}
		}
		return new Point[0];
	}

	

}