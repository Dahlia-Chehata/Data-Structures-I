package eg.edu.alexu.csd.datastructure.maze.cs31;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**.
 * .
 * @author Dell
 */

public class readfile {
	/**.
	 * .
	 */
	String[] arr1;
	/**.
	 * ;
	 */
	char[][] arr2;
	/**.
	 * ;
	 */
	String str;
	/**.
	 * ;
	 */
	public static int n,m;
	/**.
	 * ;
	 */
	char[] dim;
	/**.
	 * ;
	 * @param maze filename
	 * @return arr2
	 */
public char[][] readFile(File maze){
		if (maze.length() == 0) {
		    throw new RuntimeException();
		} 
		try{
			/**.
			 * ;
			 */
		FileReader fr=new FileReader(maze);
		/**.
		 * ;
		 */
		BufferedReader textReader=new BufferedReader(fr);
		/**.
		 * ;
		 */
		StringBuilder sb = new StringBuilder();
		/**.
		 * ;
		 */
	    String line = textReader.readLine();
	    /**.
	     * .
	     */
	    String dimensions=line;
	    /**.
	     * .
	     */
	    dim=dimensions.toCharArray();
	    /**.
	     * ;
	     */
	    String[] splited = dimensions.split("\\s+");
	    //n=Character.getNumericValue(dim[0]);
	    // m=Character.getNumericValue(dim[1]);
	    n=Integer.parseInt(splited[0]);
	    m=Integer.parseInt(splited[1]);
	   //  if (0>= n||n>9||0>= m||m>9)
	    	// throw new RuntimeException();
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
}