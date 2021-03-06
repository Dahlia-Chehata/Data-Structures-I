package eg.edu.alexu.csd.datastructure.iceHockey.cs31;
import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
import java.util.Arrays;
import java.util.Comparator;
import java.awt.Point;
/**.
 * @author Dell
 */
final class Raster implements Comparator<Point> {
	/**.
	 * . .
	 */
	private int flagg = -1;
	/**.
	 */
	@Override
	public int compare(final Point o1, final Point o2) {
		// TODO Auto-generated method stub
		if (o2.x > o1.x) {
			return flagg;
		} else if (o1.x > o2.x) {
			return 1;
		} else {
			if (o2.y > o1.y) {
				return flagg;
			} else if (o2.y < o1.y) {
				return 1;
			}
		}
		return 0;
	}
}
/**.
 * @author Dell
 */
public class IceHockey implements IPlayersFinder {
	/**.
	 */
	final int num = 500;
	/**.
	 * . ;
	 */
	final int flagg = -1;
	/**.
	 */
	final int num100 = 100;
	/**.
	 */
	final int num4 = 4;
	/**.
	 */
	char[][] photos;
	/**.
	 */
	boolean[][] visited;
	/**.
	 * . ;
	 */
	Point[] temp;
	/**.
	 * . ;
	 */
	int n, m, index = 0, counter = 0, teams, area;
	/**.
	 * . ;
	 */
	int minRow = num, minCol = num, maxRow = flagg, maxCol = flagg;
	/**.
	 * . '
	 */
	Point center;
	/**
	 * . ;
	 * @param i index
	 * @param j index
	 * @param v index
	 * @return center
	 */
	public Point dfs(final int i, final int j, final int v) {
		if (canmove(i, j, teams)) {
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
            if (j < minCol) {
				minCol = j;
			}
			dfs(i - 1, j, v); // up
			dfs(i + 1, j, v); // down
			dfs(i, j - 1, v); // left
			dfs(i, j + 1, v); // right
		}
		int a = counter;
		if (a * num4 >= area) {
			/**.
			 * . '
			 */
			int xx = minCol + maxCol + 1;
			/**.
			 * . '
			 */
			int yy = minRow + maxRow + 1;
			center = new Point(xx, yy);
		}
		return center;
	}
	/**
	 * . ;
	 * @param xx index
	 * @param yy index
	 * @param team teamm
	 * @return boolean
	 */
	public boolean canmove(final int xx,
			final int yy, final int team) {
		/**
		 * . ;
		 */
		teams = team;
		if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
			return false;
		}
		if ((!isVisited(xx, yy)) && photos[xx][yy] == team + '0') {
			return true;
		}
		return false;
	}
	/**.
	 * . ;
	 * @param i index
	 * @param j index
	 * @return visited[i][j]
	 */
	private boolean isVisited(final int i, final int j) {
		return visited[i][j];
	}
	/**.
	 */
	@Override
	public Point[] findPlayers(final String[] photo,
		final int team, final int threshold) {
		// TODO Auto-generated method stub
		teams = team;
		area = threshold;
		/**.
		 */
		Point[] coor = new Point[num100];

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
					minRow = num;
					minCol = num;
					maxRow = flagg;
					maxCol = flagg;
				}
			}
			Raster c = new Raster();
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
